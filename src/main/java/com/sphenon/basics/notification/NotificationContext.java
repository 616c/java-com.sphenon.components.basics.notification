package com.sphenon.basics.notification;

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
import com.sphenon.basics.message.*;
import com.sphenon.basics.monitoring.*;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.customary.*;
import com.sphenon.basics.variatives.tplinst.*;
import com.sphenon.basics.notification.classes.*;

public class NotificationContext extends SpecificContext {

    static protected NotificationContext default_singleton;
    protected boolean is_default_singelton;

    static public NotificationContext get(Context context) {
        NotificationContext notification_context = (NotificationContext) context.getSpecificContext(NotificationContext.class);
        if (notification_context != null) {
            return notification_context;
        }
        return default_singleton == null ? (default_singleton = new NotificationContext(context, true)) : default_singleton;
    }

    static public NotificationContext create(Context context) {
        NotificationContext nc = new NotificationContext(context, false);
        context.setSpecificContext(NotificationContext.class, nc);
        return nc;
    }

    protected NotificationContext (Context context, boolean is_default_singelton) {
        super(context);
        this.is_default_singelton = is_default_singelton;
        this.notifier = null;
    }

    protected Notifier notifier;
    static protected Notifier default_notifier;

    static protected Notifier getDefaultNotifier(CallContext cc) {
        return (default_notifier != null ? default_notifier
                                         : (default_notifier = Notifier.create(cc))
               );
    }

    public void setNotifier(CallContext cc, Notifier notifier) {
        if (is_default_singelton) {
            CustomaryContext.create((Context) cc).throwPreConditionViolation(cc, "Cannot modify default singelton NotificationContext");
            throw (ExceptionPreConditionViolation) null; // compiler insists
        }
        this.notifier = notifier;
    }

    public Notifier getNotifier(CallContext cc) {
        if (is_default_singelton) { return this.getDefaultNotifier(cc); }
        NotificationContext nc;
        return (this.notifier != null ?
                     this.notifier
                  : (nc = (NotificationContext) this.getCallContext(NotificationContext.class)) != null ?
                       nc.getNotifier(cc)
                     : this.getDefaultNotifier(cc)
               );
    }

    public void send(CallContext cc, Message message, int reliability, long lifetime, long level) {
        this.getNotifier(cc).send(cc, message, reliability, lifetime, level);
    }
   
    static public void setDefaultNotifier(Context context, Notifier notifier) {
        if (default_notifier != null) {
            ExceptionPreConditionViolation.createAndThrow(context, SystemStateMessage.create(context, MessageText.create(context, NotificationStringPool.get(context, "1.0.0" /* cannot set default notifier twice or after first access */)), ProblemState.ERROR));
        }
        default_notifier = notifier;
    }

    static public void dump(CallContext cc, String name, Object instance, long level) {
        (new DumpNode_Notifier(cc, NotificationContext.get((Context)cc).getNotifier(cc), level)).dump(cc, name, instance);
    }
   
    // ---------------------------------------------------------------------------------------------------------------------------------------------------

    static public void sendApplicationLog(CallContext context, String text) {
        NotificationContext.get((Context)context).send(context, ApplicationMessage.create(context, MessageText.create(context, text)), Notifier.RELIABLE, Notifier.LOG, Notifier.PRODUCTION);
    }

    static public void sendApplicationLog(CallContext context, String text, Object... attributes) {
        NotificationContext.get((Context)context).send(context, ApplicationMessage.create(context, MessageText.create(context, text, attributes)), Notifier.RELIABLE, Notifier.LOG, Notifier.PRODUCTION);
    }

    static public void sendApplicationLog(CallContext context, Variative_String_ text) {
        NotificationContext.get((Context)context).send(context, ApplicationMessage.create(context, MessageText.create(context, text)), Notifier.RELIABLE, Notifier.LOG, Notifier.PRODUCTION);
    }

    static public void sendApplicationLog(CallContext context, Variative_String_ text, Object... attributes) {
        NotificationContext.get((Context)context).send(context, ApplicationMessage.create(context, MessageText.create(context, text, attributes)), Notifier.RELIABLE, Notifier.LOG, Notifier.PRODUCTION);
    }

    static public void sendTrace(CallContext context, long level, String text) {
        NotificationContext.get((Context)context).send(context, TraceMessage.create(context, MessageText.create(context, text), 1), Notifier.DISCARDABLE, Notifier.TRANSIENT, level);
    }

    static public void sendTrace(CallContext context, long level, String text, Object... attributes) {
        NotificationContext.get((Context)context).send(context, TraceMessage.create(context, MessageText.create(context, text, attributes), 1), Notifier.DISCARDABLE, Notifier.TRANSIENT, level);
    }

    static public void sendTrace(CallContext context, long level, Variative_String_ text) {
        NotificationContext.get((Context)context).send(context, TraceMessage.create(context, MessageText.create(context, text), 1), Notifier.DISCARDABLE, Notifier.TRANSIENT, level);
    }

    static public void sendTrace(CallContext context, long level, Variative_String_ text, Object... attributes) {
        NotificationContext.get((Context)context).send(context, TraceMessage.create(context, MessageText.create(context, text, attributes), 1), Notifier.DISCARDABLE, Notifier.TRANSIENT, level);
    }

    static public void sendCheckpoint(CallContext context, String text) {
        NotificationContext.get((Context)context).send(context, TraceMessage.create(context, MessageText.create(context, text), 1), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.CHECKPOINT);
    }

    static public void sendCheckpoint(CallContext context, String text, Object... attributes) {
        NotificationContext.get((Context)context).send(context, TraceMessage.create(context, MessageText.create(context, text, attributes), 1), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.CHECKPOINT);
    }

    static public void sendCheckpoint(CallContext context, Variative_String_ text) {
        NotificationContext.get((Context)context).send(context, TraceMessage.create(context, MessageText.create(context, text), 1), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.CHECKPOINT);
    }

    static public void sendCheckpoint(CallContext context, Variative_String_ text, Object... attributes) {
        NotificationContext.get((Context)context).send(context, TraceMessage.create(context, MessageText.create(context, text, attributes), 1), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.CHECKPOINT);
    }

    static public void sendDiagnostics(CallContext context, String text) {
        NotificationContext.get((Context)context).send(context, TraceMessage.create(context, MessageText.create(context, text), 1), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.DIAGNOSTICS);
    }

    static public void sendDiagnostics(CallContext context, String text, Object... attributes) {
        NotificationContext.get((Context)context).send(context, TraceMessage.create(context, MessageText.create(context, text, attributes), 1), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.DIAGNOSTICS);
    }

    static public void sendDiagnostics(CallContext context, Variative_String_ text) {
        NotificationContext.get((Context)context).send(context, TraceMessage.create(context, MessageText.create(context, text), 1), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.DIAGNOSTICS);
    }

    static public void sendDiagnostics(CallContext context, Variative_String_ text, Object... attributes) {
        NotificationContext.get((Context)context).send(context, TraceMessage.create(context, MessageText.create(context, text, attributes), 1), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.DIAGNOSTICS);
    }

    static public void sendSelfDiagnostics(CallContext context, String text) {
        NotificationContext.get((Context)context).send(context, TraceMessage.create(context, MessageText.create(context, text), 1), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.SELF_DIAGNOSTICS);
    }

    static public void sendSelfDiagnostics(CallContext context, String text, Object... attributes) {
        NotificationContext.get((Context)context).send(context, TraceMessage.create(context, MessageText.create(context, text, attributes), 1), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.SELF_DIAGNOSTICS);
    }

    static public void sendSelfDiagnostics(CallContext context, Variative_String_ text) {
        NotificationContext.get((Context)context).send(context, TraceMessage.create(context, MessageText.create(context, text), 1), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.SELF_DIAGNOSTICS);
    }

    static public void sendSelfDiagnostics(CallContext context, Variative_String_ text, Object... attributes) {
        NotificationContext.get((Context)context).send(context, TraceMessage.create(context, MessageText.create(context, text, attributes), 1), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.SELF_DIAGNOSTICS);
    }

    static public void sendOk(CallContext context, String text) {
        NotificationContext.get((Context)context).send(context, SystemStateMessage.create(context, MessageText.create(context, text), ProblemState.OK), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    static public void sendOk(CallContext context, String text, Object... attributes) {
        NotificationContext.get((Context)context).send(context, SystemStateMessage.create(context, MessageText.create(context, text, attributes), ProblemState.OK), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    static public void sendOk(CallContext context, Variative_String_ text) {
        NotificationContext.get((Context)context).send(context, SystemStateMessage.create(context, MessageText.create(context, text), ProblemState.OK), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    static public void sendOk(CallContext context, Variative_String_ text, Object... attributes) {
        NotificationContext.get((Context)context).send(context, SystemStateMessage.create(context, MessageText.create(context, text, attributes), ProblemState.OK), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    static public void sendInfo(CallContext context, String text) {
        NotificationContext.get((Context)context).send(context, SystemStateMessage.create(context, MessageText.create(context, text), ProblemState.INFO), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    static public void sendInfo(CallContext context, String text, Object... attributes) {
        NotificationContext.get((Context)context).send(context, SystemStateMessage.create(context, MessageText.create(context, text, attributes), ProblemState.INFO), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    static public void sendInfo(CallContext context, Variative_String_ text) {
        NotificationContext.get((Context)context).send(context, SystemStateMessage.create(context, MessageText.create(context, text), ProblemState.INFO), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    static public void sendInfo(CallContext context, Variative_String_ text, Object... attributes) {
        NotificationContext.get((Context)context).send(context, SystemStateMessage.create(context, MessageText.create(context, text, attributes), ProblemState.INFO), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    static public void sendNotice(CallContext context, String text) {
        NotificationContext.get((Context)context).send(context, SystemStateMessage.create(context, MessageText.create(context, text), ProblemState.NOTICE), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    static public void sendNotice(CallContext context, String text, Object... attributes) {
        NotificationContext.get((Context)context).send(context, SystemStateMessage.create(context, MessageText.create(context, text, attributes), ProblemState.NOTICE), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    static public void sendNotice(CallContext context, Variative_String_ text) {
        NotificationContext.get((Context)context).send(context, SystemStateMessage.create(context, MessageText.create(context, text), ProblemState.NOTICE), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    static public void sendNotice(CallContext context, Variative_String_ text, Object... attributes) {
        NotificationContext.get((Context)context).send(context, SystemStateMessage.create(context, MessageText.create(context, text, attributes), ProblemState.NOTICE), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    static public void sendCaution(CallContext context, String text) {
        NotificationContext.get((Context)context).send(context, SystemStateMessage.create(context, MessageText.create(context, text), ProblemState.CAUTION), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    static public void sendCaution(CallContext context, String text, Object... attributes) {
        NotificationContext.get((Context)context).send(context, SystemStateMessage.create(context, MessageText.create(context, text, attributes), ProblemState.CAUTION), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    static public void sendCaution(CallContext context, Variative_String_ text) {
        NotificationContext.get((Context)context).send(context, SystemStateMessage.create(context, MessageText.create(context, text), ProblemState.CAUTION), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    static public void sendCaution(CallContext context, Variative_String_ text, Object... attributes) {
        NotificationContext.get((Context)context).send(context, SystemStateMessage.create(context, MessageText.create(context, text, attributes), ProblemState.CAUTION), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    static public void sendWarning(CallContext context, String text) {
        NotificationContext.get((Context)context).send(context, SystemStateMessage.create(context, MessageText.create(context, text), ProblemState.WARNING), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    static public void sendWarning(CallContext context, String text, Object... attributes) {
        NotificationContext.get((Context)context).send(context, SystemStateMessage.create(context, MessageText.create(context, text, attributes), ProblemState.WARNING), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    static public void sendWarning(CallContext context, Variative_String_ text) {
        NotificationContext.get((Context)context).send(context, SystemStateMessage.create(context, MessageText.create(context, text), ProblemState.WARNING), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    static public void sendWarning(CallContext context, Variative_String_ text, Object... attributes) {
        NotificationContext.get((Context)context).send(context, SystemStateMessage.create(context, MessageText.create(context, text, attributes), ProblemState.WARNING), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    static public void sendSevereWarning(CallContext context, String text) {
        NotificationContext.get((Context)context).send(context, SystemStateMessage.create(context, MessageText.create(context, text), ProblemState.SEVERE_WARNING), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    static public void sendSevereWarning(CallContext context, String text, Object... attributes) {
        NotificationContext.get((Context)context).send(context, SystemStateMessage.create(context, MessageText.create(context, text, attributes), ProblemState.SEVERE_WARNING), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    static public void sendSevereWarning(CallContext context, Variative_String_ text) {
        NotificationContext.get((Context)context).send(context, SystemStateMessage.create(context, MessageText.create(context, text), ProblemState.SEVERE_WARNING), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    static public void sendSevereWarning(CallContext context, Variative_String_ text, Object... attributes) {
        NotificationContext.get((Context)context).send(context, SystemStateMessage.create(context, MessageText.create(context, text, attributes), ProblemState.SEVERE_WARNING), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    static public void sendError(CallContext context, String text) {
        NotificationContext.get((Context)context).send(context, SystemStateMessage.create(context, MessageText.create(context, text), ProblemState.ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    static public void sendError(CallContext context, String text, Object... attributes) {
        NotificationContext.get((Context)context).send(context, SystemStateMessage.create(context, MessageText.create(context, text, attributes), ProblemState.ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    static public void sendError(CallContext context, Variative_String_ text) {
        NotificationContext.get((Context)context).send(context, SystemStateMessage.create(context, MessageText.create(context, text), ProblemState.ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    static public void sendError(CallContext context, Variative_String_ text, Object... attributes) {
        NotificationContext.get((Context)context).send(context, SystemStateMessage.create(context, MessageText.create(context, text, attributes), ProblemState.ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    static public void sendCriticalError(CallContext context, String text) {
        NotificationContext.get((Context)context).send(context, SystemStateMessage.create(context, MessageText.create(context, text), ProblemState.CRITICAL_ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    static public void sendCriticalError(CallContext context, String text, Object... attributes) {
        NotificationContext.get((Context)context).send(context, SystemStateMessage.create(context, MessageText.create(context, text, attributes), ProblemState.CRITICAL_ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    static public void sendCriticalError(CallContext context, Variative_String_ text) {
        NotificationContext.get((Context)context).send(context, SystemStateMessage.create(context, MessageText.create(context, text), ProblemState.CRITICAL_ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    static public void sendCriticalError(CallContext context, Variative_String_ text, Object... attributes) {
        NotificationContext.get((Context)context).send(context, SystemStateMessage.create(context, MessageText.create(context, text, attributes), ProblemState.CRITICAL_ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    static public void sendFatalError(CallContext context, String text) {
        NotificationContext.get((Context)context).send(context, SystemStateMessage.create(context, MessageText.create(context, text), ProblemState.FATAL_ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    static public void sendFatalError(CallContext context, String text, Object... attributes) {
        NotificationContext.get((Context)context).send(context, SystemStateMessage.create(context, MessageText.create(context, text, attributes), ProblemState.FATAL_ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    static public void sendFatalError(CallContext context, Variative_String_ text) {
        NotificationContext.get((Context)context).send(context, SystemStateMessage.create(context, MessageText.create(context, text), ProblemState.FATAL_ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    static public void sendFatalError(CallContext context, Variative_String_ text, Object... attributes) {
        NotificationContext.get((Context)context).send(context, SystemStateMessage.create(context, MessageText.create(context, text, attributes), ProblemState.FATAL_ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    static public void sendEmergency(CallContext context, String text) {
        NotificationContext.get((Context)context).send(context, SystemStateMessage.create(context, MessageText.create(context, text), ProblemState.EMERGENCY), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    static public void sendEmergency(CallContext context, String text, Object... attributes) {
        NotificationContext.get((Context)context).send(context, SystemStateMessage.create(context, MessageText.create(context, text, attributes), ProblemState.EMERGENCY), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    static public void sendEmergency(CallContext context, Variative_String_ text) {
        NotificationContext.get((Context)context).send(context, SystemStateMessage.create(context, MessageText.create(context, text), ProblemState.EMERGENCY), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    static public void sendEmergency(CallContext context, Variative_String_ text, Object... attributes) {
        NotificationContext.get((Context)context).send(context, SystemStateMessage.create(context, MessageText.create(context, text, attributes), ProblemState.EMERGENCY), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    static public void sendPanic(CallContext context, String text) {
        NotificationContext.get((Context)context).send(context, SystemStateMessage.create(context, MessageText.create(context, text), ProblemState.PANIC), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    static public void sendPanic(CallContext context, String text, Object... attributes) {
        NotificationContext.get((Context)context).send(context, SystemStateMessage.create(context, MessageText.create(context, text, attributes), ProblemState.PANIC), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    static public void sendPanic(CallContext context, Variative_String_ text) {
        NotificationContext.get((Context)context).send(context, SystemStateMessage.create(context, MessageText.create(context, text), ProblemState.PANIC), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    static public void sendPanic(CallContext context, Variative_String_ text, Object... attributes) {
        NotificationContext.get((Context)context).send(context, SystemStateMessage.create(context, MessageText.create(context, text, attributes), ProblemState.PANIC), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }
}
