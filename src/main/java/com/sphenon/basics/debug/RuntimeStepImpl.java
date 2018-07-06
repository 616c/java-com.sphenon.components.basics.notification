package com.sphenon.basics.debug;

/****************************************************************************
  Copyright 2001-2018 Sphenon GmbH

  Licensed under the Apache License, Version 2.0 (the "License"); you may not
  use this file except in compliance with the License. You may obtain a copy
  of the License at http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
  License for the specific language governing permissions and limitations
  under the License.
*****************************************************************************/

import com.sphenon.basics.context.*;
import com.sphenon.basics.context.classes.*;
import com.sphenon.basics.message.*;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.configuration.*;
import com.sphenon.basics.customary.*;
import com.sphenon.basics.notification.*;
import com.sphenon.basics.performance.*;
import com.sphenon.basics.debug.*;

public class RuntimeStepImpl extends RuntimeStep implements Dumpable, ContextAware {
    static final public Class _class = RuntimeStepImpl.class;

    static protected long notification_level;
    static public    long adjustNotificationLevel(long new_level) { long old_level = notification_level; notification_level = new_level; return old_level; }
    static public    long getNotificationLevel() { return notification_level; }
    static { notification_level = NotificationLocationContext.getLevel(_class); };

    static protected Configuration config;
    static { config = Configuration.create(RootContext.getInitialisationContext(), "com.sphenon.basics.debug.RuntimeStepImpl"); };

    protected RuntimeStepImpl parent;
    protected StopWatch stop_watch;
    protected String id;
    protected int next_child_id;

    protected Throwable stack_trace_throwable;

    protected String getNextChildId(CallContext context) {
        return this.id + "." + next_child_id++;
    }

    protected String getIndent (long width) {
        StringBuffer sb = new StringBuffer();
        for (long i=0; i<width; i++) { sb.append("  "); }
        return new String(sb);
    }

    protected void pauseStopWatch(CallContext context) {
        if (this.stop_watch != null) { this.stop_watch.pause(context, "substep start"); }
    }

    protected void continueStopWatch(CallContext context) {
        if (this.stop_watch != null) { this.stop_watch.cont(context, "substep finished"); }
    }

    static protected Boolean are_stopwatches_enabled;
    static protected boolean areStopwatchesEnabled(CallContext context) {
        if (are_stopwatches_enabled == null) {
            are_stopwatches_enabled = config.get(context, "STOPWATCHES.Enabled", false);
        }
        return are_stopwatches_enabled;
    }

    static protected Boolean monitor_creation_stack_traces;
    static protected boolean monitorCreationStackTraces(CallContext context) {
        if (monitor_creation_stack_traces == null) {
            monitor_creation_stack_traces = config.get(context, "MonitorCreationStackTraces", false);
        }
        return monitor_creation_stack_traces;
    }

    public StackTraceElement[] getCreationStackTrace(CallContext context) {
        return stack_trace_throwable == null ? null : stack_trace_throwable.getStackTrace();
    }

    protected RuntimeStepImpl(Context context, long level, Class j_class, String message, Object... arguments) {
        super(context);

        RuntimeStepContext rsc = RuntimeStepContext.getOrCreate(context, true);
        this.parent = (RuntimeStepImpl) rsc.getParent(context);
        this.stack_depth = rsc.getStackDepth(context);
        this.next_child_id = 0;
        this.id = (this.parent == null ? "0" : this.parent.getNextChildId(context));

        this.level   = level;

        // should be set possibly depending on level or so
        this.trace_level = Notifier.SELF_DIAGNOSTICS;

        this.purpose = message == null ? null : MessageText.create(context, message, arguments);
        this.state = State.INPROGRESS;

        if ((notification_level & this.trace_level) != 0) {
            NotificationContext.get((Context)context).send(context, TraceMessage.create(context, MessageTextSequence.createSequence(context, MessageText.create(context, "RuntimeStep          : " + getIndent(this.stack_depth)), this.purpose), 0), Notifier.DISCARDABLE, Notifier.TRANSIENT, this.trace_level);
        }

        if (areStopwatchesEnabled(context)) {
            this.stop_watch = StopWatch.optionallyCreate(context, j_class, "step " + this.id, Notifier.SELF_DIAGNOSTICS);
        }

        if (monitorCreationStackTraces(context)) {
            this.stack_trace_throwable = new Throwable();
        }

        rsc.addRuntimeStep(context, this);
        if (this.parent != null) { this.parent.pauseStopWatch(context); }
        if (this.stop_watch != null) { this.stop_watch.start(context, "step begin"); }
    }

    public void setCompleted(CallContext context, String message, Object... arguments) {
        MessageText result_message = message == null ? null : MessageText.create(context, message, arguments);
        if (this.result != null) {
            System.err.println("ERROR: runtime step '" + t.s(context, this.purpose) + "' is completed twice, first message '" + t.s(context, this.result) + "', second message '" + t.s(context, result_message) + "'");
        }
        this.result = result_message;
        this.state = State.COMPLETED;

        if (this.stop_watch != null) { this.stop_watch.stop(context, "step completed"); }
        if (this.parent != null) { this.parent.continueStopWatch(context); }
        if ((notification_level & this.trace_level) != 0) {
            NotificationContext.get((Context)context).send(context, TraceMessage.create(context, MessageTextSequence.createSequence(context, MessageText.create(context, "RuntimeStep completed: " + getIndent(this.stack_depth)), this.result), 0), Notifier.DISCARDABLE, Notifier.TRANSIENT, this.trace_level);
        }
    }

    public void setFailed(CallContext context, Throwable exception, String message, Object... arguments) {
        MessageText result_message = message == null ? null : MessageText.create(context, message, arguments);
        if (this.result != null) {
            System.err.println("ERROR: runtime step '" + t.s(context, this.purpose) + "' is completed twice, first message '" + t.s(context, this.result) + "', second message '" + t.s(context, result_message) + "'");
        }
        if (this.exception != null) {
            System.err.println("ERROR: runtime step '" + t.s(context, this.purpose) + "' is completed twice, first exception '" + t.s(context, this.exception) + "', second exception '" + t.s(context, exception) + "'");
        }
        this.exception = exception;
        this.result    = result_message;
        this.state = State.FAILED;

        if (this.parent != null) { this.parent.continueStopWatch(context); }
        if (this.stop_watch != null) { this.stop_watch.stop(context, "step failed"); }
        if ((notification_level & this.trace_level) != 0) {
            NotificationContext.get((Context)context).send(context, TraceMessage.create(context, MessageTextSequence.createSequence(context, MessageText.create(context, "RuntimeStep failed   : " + getIndent(this.stack_depth)), this.result), 0), Notifier.DISCARDABLE, Notifier.TRANSIENT, this.trace_level);
        }
    }

    // Attributes ---------------------------------------------------

    protected long trace_level;

    protected long stack_depth;

    protected long level;

    public long getLevel (CallContext context) {
        return this.level;
    }

    protected MessageText purpose;

    public MessageText getPurpose (CallContext context) {
        return this.purpose;
    }

    protected enum State { INPROGRESS, COMPLETED, FAILED };

    protected State state;

    public String getState (CallContext context) {
        return this.state == State.INPROGRESS ? "InProgress" :
               this.state == State.COMPLETED  ? "Completed" :
               this.state == State.FAILED     ? "Failed" :
                                                "???";
    }

    protected MessageText result;

    public MessageText getResult (CallContext context) {
        return this.result;
    }

    public void dump(CallContext context, DumpNode dump_node) {
        DumpNode dn = dump_node.openDump(context, "RuntimeStep");
        dn.dump(context, "Purpose  ", this.getPurpose(context));
        dn.dump(context, "State    ", this.getState(context));
        dn.dump(context, "Result   ", this.getResult(context));
        if (this.exception != null) {
        dn.dump(context, "Exception", this.getException(context));
        }
    }

    public String toString(CallContext context) {
        return this.getState(context) + " - " + t.s(context, this.getPurpose(context)) + (this.getResult(context) == null ? "" : (" -> " + t.s(context, this.getResult(context)))) + (this.exception == null ? "" : (" ( " + ((this.getException(context) instanceof ExceptionError) ? ((ExceptionError)this.getException(context)).toString(false) : (this.getException(context) instanceof ReturnCode) ? ((ReturnCode)this.getException(context)).toString(false) : this.getException(context)) + " )"));
    }
}
