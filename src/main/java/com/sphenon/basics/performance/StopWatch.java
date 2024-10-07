package com.sphenon.basics.performance;

/****************************************************************************
  Copyright 2001-2024 Sphenon GmbH

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
import com.sphenon.basics.notification.*;
import com.sphenon.basics.customary.*;
import com.sphenon.basics.configuration.*;

import java.util.Vector;

public class StopWatch {

    public    long notification_level;
    public    long adjustNotificationLevel(long new_level) { long old_level = notification_level; notification_level = new_level; return old_level; }
    public    long getNotificationLevel() { return notification_level; }

    public    long notification_category;

    static protected boolean initialised = false;
    static protected boolean enabled = false;

    static protected Vector<StopWatch> watches_to_summarise;
    
    static public boolean getEnabled (CallContext context) {
        if (initialised == false) {
            initialised = true;
            enabled = Configuration.get (context, "com.sphenon.basics.performance.STOPWATCH", "Enabled", false);
        }
        return enabled;
    }

    static public void setEnabled (CallContext context, boolean enabled_par) {
        initialised = true;
        enabled = enabled_par;
    }

    protected String category;
    protected String packagepath;

    protected long initially_started;
    protected long restarted;
    protected long duration;
    protected long duration_brutto;

    static protected long counter = 0;
    static protected synchronized long getIndex(CallContext context) {
        return counter++;
    }

    protected long watch_index;

    protected String current_mark;
    protected long current_mark_started;

    protected boolean summarise;
    protected java.util.Hashtable totals;

    protected StopWatch (CallContext context, String packagepath, String category, long notification_category) {
        CustomaryContext cc = CustomaryContext.create((Context)context);
        this.notification_level = NotificationLocationContext.getLevel(context, packagepath + ".STOPWATCH");
        this.packagepath = packagepath;
        this.category = category;
        this.notification_category = notification_category;
        this.watch_index = getIndex(context);
        this.summarise = Configuration.get(context, packagepath + ".STOPWATCH", "Summarise", false);
        if (this.summarise) {
            if (watches_to_summarise == null) {
                watches_to_summarise = new Vector<StopWatch>();
                java.lang.Runtime.getRuntime().addShutdownHook(new Thread() { public void run() { showAllTotals(RootContext.getDestructionContext()); } });
            }
            watches_to_summarise.add(this);
    }

        if ((this.notification_level & this.notification_category) != 0) {
            cc.sendTrace(context, this.notification_category, "Stopwatch(%(index)) '%(category)' in '%(packagepath)': created", "index", t.s(this.watch_index), "category", this.category, "packagepath", this.packagepath);
        }
    }

    static public StopWatch optionallyCreate (CallContext context, String packagepath, String category, long notification_category) {
        return optionallyCreate (context, packagepath, null, category, notification_category);
    }

    static public StopWatch optionallyCreate (CallContext context, Class j_class, String category, long notification_category) {
        return optionallyCreate (context, null, j_class, category, notification_category);
    }

    static protected StopWatch optionallyCreate (CallContext context, String packagepath, Class j_class, String category, long notification_category) {
        if (getEnabled(context) == false) {
            return null;
        }
        if (packagepath == null) {
            packagepath = j_class.getName();
        }
        if (Configuration.get (context, packagepath + ".STOPWATCH", "Enabled", false) == false) {
            return null;
        }
        return new StopWatch (context, packagepath, category, notification_category);
    }

    public void start (CallContext context) {
        start(context, null, null);
    }

    public void start (CallContext context, String message) {
        start(context, message, null);
    }

    public void start (CallContext context, String message, String mark) {
        long now = System.currentTimeMillis();
        this.initially_started = now;
        this.restarted = now;
        this.duration = 0L;
        this.duration_brutto = 0L;
        this.current_mark = (mark == null ? "<start>" : mark);
        this.current_mark_started = now;
        if ((this.notification_level & this.notification_category) != 0) {
            CustomaryContext.create((Context)context).sendTrace(context, this.notification_category, "Stopwatch(%(index)): started at %(absolute)%(message)", "index", t.s(this.watch_index), "absolute", t.s(now), "message", (message == null ? (mark == null ? "" : " - " + mark) : (" - " + message)));
        }
    }

    public void stop (CallContext context) {
        stop(context, null, null);
    }

    public void stop (CallContext context, String message) {
        stop(context, message, null);
    }

    public void stop (CallContext context, String message, String mark) {
        long now = System.currentTimeMillis();
        this.duration += (now - this.restarted);
        this.duration_brutto = (now - this.initially_started);
        mark(context, mark == null ? "<stop>" : mark, now);
        if ((this.notification_level & this.notification_category) != 0) {
            CustomaryContext.create((Context)context).sendTrace(context, this.notification_category, "Stopwatch(%(index)): stopped at %(absolute) - netto duration %(duration) ms, brutto duration %(brutto) ms,%(message)", "index", t.s(this.watch_index), "absolute", t.s(now), "duration", t.s(duration), "brutto", t.s(duration_brutto), "message", (message == null ? (mark == null ? "" : " - " + mark) : (" - " + message)));
        }
    }

    public void pause (CallContext context) {
        pause(context, null, null);
    }

    public void pause (CallContext context, String message) {
        pause(context, message, null);
    }

    public void pause (CallContext context, String message, String mark) {
        long now = System.currentTimeMillis();
        this.duration += now - this.restarted;
        mark(context, mark == null ? "<pause>" : mark, now);
        if ((this.notification_level & this.notification_category) != 0) {
            CustomaryContext.create((Context)context).sendTrace(context, this.notification_category, "Stopwatch(%(index)): paused at %(absolute) - duration %(duration) ms%(message)", "index", t.s(this.watch_index), "absolute", t.s(now), "duration", t.s(duration), "message", (message == null ? (mark == null ? "" : " - " + mark) : (" - " + message)));
        }
    }

    public void cont (CallContext context) {
        cont(context, null, null);
    }

    public void cont (CallContext context, String message) {
        cont(context, message, null);
    }

    public void cont (CallContext context, String message, String mark) {
        long now = System.currentTimeMillis();
        this.restarted = now;
        this.current_mark = mark == null ? "<cont>" : mark;
        this.current_mark_started = now;
        if ((this.notification_level & this.notification_category) != 0) {
            CustomaryContext.create((Context)context).sendTrace(context, this.notification_category, "Stopwatch(%(index)): continued at %(absolute)%(message)", "index", t.s(this.watch_index), "absolute", t.s(now), "message", (message == null ? (mark == null ? "" : " - " + mark) : (" - " + message)));
        }
    }

    public void show (CallContext call_context) {
        show(call_context, null, null);
    }

    public void show (CallContext call_context, String message) {
        show(call_context, message, null);
    }

    public void show (CallContext context, String message, String mark) {
        long now = System.currentTimeMillis();
        mark(context, mark, now);
        if ((this.notification_level & this.notification_category) != 0) {
            CustomaryContext.create((Context)context).sendTrace(context, this.notification_category, "Stopwatch(%(index)): interim at %(absolute) - %(duration) ms%(message)", "index", t.s(this.watch_index), "absolute", t.s(now), "duration", t.s(this.duration + now - this.restarted), "message", (message == null ? (mark == null ? "" : " - " + mark) : (" - " + message)));
        }
    }

    protected void mark (CallContext context, String mark, long now) {
        if (mark != null && mark.length() != 0) {
            String previous_mark = this.current_mark;
            long previous_mark_started = this.current_mark_started;
            this.current_mark = mark;
            this.current_mark_started = now;
            long mark_duration = this.current_mark_started - previous_mark_started;
            addToTotals(context, previous_mark+"-"+current_mark, mark_duration);
            if (mark.charAt(0) != '<' || previous_mark.charAt(0) != '<') {
                if ((this.notification_level & this.notification_category) != 0) {
                    CustomaryContext.create((Context)context).sendTrace(context, this.notification_category, "Stopwatch(%(index)): elpased mark time ['%(mark1)','%(mark2)'] %(markduration) ms", "index", t.s(this.watch_index), "mark1", previous_mark, "mark2", this.current_mark, "markduration", t.s(mark_duration));
                }
            }
        }
    }

    public void resetTotals(CallContext context) {
        totals = null;
    }

    protected void addToTotals(CallContext context, String key, long duration) {
        if (summarise) {
            if (totals == null) {
                totals = new java.util.Hashtable();
            }
            Long l = (Long) totals.get(key);
            totals.put(key, new Long(duration + (l == null ? 0L : l.longValue())));
        }
    }

    public void showTotals(CallContext context) {
        if (summarise && totals != null) {
            if ((this.notification_level & Notifier.OBSERVATION) != 0) {
                CustomaryContext cc = CustomaryContext.create((Context)context);
                java.util.Iterator iterator = totals.entrySet().iterator();
                while (iterator.hasNext()) {
                    java.util.Map.Entry me = (java.util.Map.Entry) iterator.next();
                    cc.sendDigest(context, this.notification_category, "Stopwatch(%(index)): total duration in interval %(interval) - %(duration) ms", "index", t.s(this.watch_index), "interval", me.getKey(), "duration", me.getValue());
                }
            }
        }
    }

    static public void showAllTotals(CallContext context) {
        for (StopWatch stop_watch : watches_to_summarise) {
            stop_watch.showTotals(context);
        }
    }
}
