package com.sphenon.basics.customary;

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
import com.sphenon.basics.monitoring.*;
import com.sphenon.basics.variatives.*;
import com.sphenon.basics.variatives.tplinst.*;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.notification.*;
import com.sphenon.basics.goal.*;
import com.sphenon.basics.performance.*;

public class CustomaryContext {
    static protected long notification_level;
    static public    long adjustNotifcationLevel(long new_level) { long old_level = notification_level; notification_level = new_level; return old_level; }
    static public    long getNotifcationLevel() { return notification_level; }

    static public InstanceCounter instance_counter;

    static {
        CallContext context = RootContext.getInitialisationContext();
        notification_level = NotificationLocationContext.getLevel(context, "com.sphenon.basics.customary.CustomaryContext");
        instance_counter = InstanceCounterHandler.optionallyCreateInstanceCounter (context, "com.sphenon.basics.customary.CustomaryContext");
    };

    private NotificationContext notification_context;
    private GoalContext goal_context;
    protected Context context;

    static public CustomaryContext create (Context context) {
        return new CustomaryContext(context, null, null);
    }

    static public CustomaryContext create (Context context, CustomaryContext customary_context) {
        return (customary_context != null ? customary_context : new CustomaryContext(context, null, null));
    }

    static public CustomaryContext create (Context context, NotificationContext notification_context) {
        return new CustomaryContext(context, notification_context, null);
    }

    static public CustomaryContext create (Context context, GoalContext goal_context) {
        return new CustomaryContext(context, null, goal_context);
    }

    static public CustomaryContext create (Context context, NotificationContext notification_context, GoalContext goal_context) {
        return new CustomaryContext(context, notification_context, goal_context);
    }

    protected CustomaryContext (Context context, NotificationContext notification_context, GoalContext goal_context) {
        this.context = context;
        this.notification_context = notification_context;
        this.goal_context = goal_context;

        if (instance_counter != null) { instance_counter.notifyInstanceCreation(context); }
    }

    protected void finalize() throws Throwable {
        if (instance_counter != null) { instance_counter.notifyInstanceFinalization(context); }
    }

    public NotificationContext getNotificationContext (CallContext cc) {
        if (this.notification_context == null) {
            this.notification_context = NotificationContext.get(context);
        }
        return this.notification_context;
    }

    public GoalContext getGoalContext (CallContext cc) {
        if (this.goal_context == null) {
            this.goal_context = GoalContext.create(context);
        }
        return this.goal_context;
    }

    //------------------------------------------------------------------------------------------------

    public void logApplicationMessage(CallContext cc, String text) {
        this.getNotificationContext(cc).send(cc, ApplicationMessage.create(cc, MessageText.create(cc, text)), Notifier.RELIABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void logApplicationMessage(CallContext cc, String text, Object[][] attributes) {
        this.getNotificationContext(cc).send(cc, ApplicationMessage.create(cc, MessageText.create(cc, text, attributes)), Notifier.RELIABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void logApplicationMessage(CallContext cc, String text, String an1, Object av1) {
        this.getNotificationContext(cc).send(cc, ApplicationMessage.create(cc, MessageText.create(cc, text, an1, av1)), Notifier.RELIABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void logApplicationMessage(CallContext cc, String text, String an1, Object av1, String an2, Object av2) {
        this.getNotificationContext(cc).send(cc, ApplicationMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2)), Notifier.RELIABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void logApplicationMessage(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        this.getNotificationContext(cc).send(cc, ApplicationMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3)), Notifier.RELIABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void logApplicationMessage(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        this.getNotificationContext(cc).send(cc, ApplicationMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4)), Notifier.RELIABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void logApplicationMessage(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        this.getNotificationContext(cc).send(cc, ApplicationMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5)), Notifier.RELIABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void logApplicationMessage(CallContext cc, Variative_String_ text) {
        this.getNotificationContext(cc).send(cc, ApplicationMessage.create(cc, MessageText.create(cc, text)), Notifier.RELIABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void logApplicationMessage(CallContext cc, Variative_String_ text, Object[][] attributes) {
        this.getNotificationContext(cc).send(cc, ApplicationMessage.create(cc, MessageText.create(cc, text, attributes)), Notifier.RELIABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void logApplicationMessage(CallContext cc, Variative_String_ text, String an1, Object av1) {
        this.getNotificationContext(cc).send(cc, ApplicationMessage.create(cc, MessageText.create(cc, text, an1, av1)), Notifier.RELIABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void logApplicationMessage(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        this.getNotificationContext(cc).send(cc, ApplicationMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2)), Notifier.RELIABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void logApplicationMessage(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        this.getNotificationContext(cc).send(cc, ApplicationMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3)), Notifier.RELIABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void logApplicationMessage(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        this.getNotificationContext(cc).send(cc, ApplicationMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4)), Notifier.RELIABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void logApplicationMessage(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        this.getNotificationContext(cc).send(cc, ApplicationMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5)), Notifier.RELIABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    //------------------------------------------------------------------------------------------------

    public void sendApplicationMessage(CallContext cc, String text) {
        this.getNotificationContext(cc).send(cc, ApplicationMessage.create(cc, MessageText.create(cc, text)), Notifier.RELIABLE, Notifier.LOG, Notifier.PRODUCTION);
    }

    public void sendApplicationMessage(CallContext cc, String text, Object[][] attributes) {
        this.getNotificationContext(cc).send(cc, ApplicationMessage.create(cc, MessageText.create(cc, text, attributes)), Notifier.RELIABLE, Notifier.LOG, Notifier.PRODUCTION);
    }

    public void sendApplicationMessage(CallContext cc, String text, String an1, Object av1) {
        this.getNotificationContext(cc).send(cc, ApplicationMessage.create(cc, MessageText.create(cc, text, an1, av1)), Notifier.RELIABLE, Notifier.LOG, Notifier.PRODUCTION);
    }

    public void sendApplicationMessage(CallContext cc, String text, String an1, Object av1, String an2, Object av2) {
        this.getNotificationContext(cc).send(cc, ApplicationMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2)), Notifier.RELIABLE, Notifier.LOG, Notifier.PRODUCTION);
    }

    public void sendApplicationMessage(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        this.getNotificationContext(cc).send(cc, ApplicationMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3)), Notifier.RELIABLE, Notifier.LOG, Notifier.PRODUCTION);
    }

    public void sendApplicationMessage(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        this.getNotificationContext(cc).send(cc, ApplicationMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4)), Notifier.RELIABLE, Notifier.LOG, Notifier.PRODUCTION);
    }

    public void sendApplicationMessage(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        this.getNotificationContext(cc).send(cc, ApplicationMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5)), Notifier.RELIABLE, Notifier.LOG, Notifier.PRODUCTION);
    }

    public void sendApplicationMessage(CallContext cc, Variative_String_ text) {
        this.getNotificationContext(cc).send(cc, ApplicationMessage.create(cc, MessageText.create(cc, text)), Notifier.RELIABLE, Notifier.LOG, Notifier.PRODUCTION);
    }

    public void sendApplicationMessage(CallContext cc, Variative_String_ text, Object[][] attributes) {
        this.getNotificationContext(cc).send(cc, ApplicationMessage.create(cc, MessageText.create(cc, text, attributes)), Notifier.RELIABLE, Notifier.LOG, Notifier.PRODUCTION);
    }

    public void sendApplicationMessage(CallContext cc, Variative_String_ text, String an1, Object av1) {
        this.getNotificationContext(cc).send(cc, ApplicationMessage.create(cc, MessageText.create(cc, text, an1, av1)), Notifier.RELIABLE, Notifier.LOG, Notifier.PRODUCTION);
    }

    public void sendApplicationMessage(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        this.getNotificationContext(cc).send(cc, ApplicationMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2)), Notifier.RELIABLE, Notifier.LOG, Notifier.PRODUCTION);
    }

    public void sendApplicationMessage(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        this.getNotificationContext(cc).send(cc, ApplicationMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3)), Notifier.RELIABLE, Notifier.LOG, Notifier.PRODUCTION);
    }

    public void sendApplicationMessage(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        this.getNotificationContext(cc).send(cc, ApplicationMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4)), Notifier.RELIABLE, Notifier.LOG, Notifier.PRODUCTION);
    }

    public void sendApplicationMessage(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        this.getNotificationContext(cc).send(cc, ApplicationMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5)), Notifier.RELIABLE, Notifier.LOG, Notifier.PRODUCTION);
    }

    //------------------------------------------------------------------------------------------------

    public void sendTrace(CallContext cc, String text) {
        this.getNotificationContext(cc).send(cc, TraceMessage.create(cc, MessageText.create(cc, text), 1), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
    }

    public void sendTrace(CallContext cc, long level, String text) {
        this.getNotificationContext(cc).send(cc, TraceMessage.create(cc, MessageText.create(cc, text), 1), Notifier.DISCARDABLE, Notifier.TRANSIENT, level);
    }

    public void sendTrace(CallContext cc, String text, Object[][] attributes) {
        this.getNotificationContext(cc).send(cc, TraceMessage.create(cc, MessageText.create(cc, text, attributes), 1), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
    }

    public void sendTrace(CallContext cc, long level, String text, Object[][] attributes) {
        this.getNotificationContext(cc).send(cc, TraceMessage.create(cc, MessageText.create(cc, text, attributes), 1), Notifier.DISCARDABLE, Notifier.TRANSIENT, level);
    }

    public void sendTrace(CallContext cc, String text, String an1, Object av1) {
        this.getNotificationContext(cc).send(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1), 1), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
    }

    public void sendTrace(CallContext cc, long level, String text, String an1, Object av1) {
        this.getNotificationContext(cc).send(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1), 1), Notifier.DISCARDABLE, Notifier.TRANSIENT, level);
    }

    public void sendTrace(CallContext cc, String text, String an1, Object av1, String an2, Object av2) {
        this.getNotificationContext(cc).send(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), 1), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
    }

    public void sendTrace(CallContext cc, long level, String text, String an1, Object av1, String an2, Object av2) {
        this.getNotificationContext(cc).send(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), 1), Notifier.DISCARDABLE, Notifier.TRANSIENT, level);
    }

    public void sendTrace(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        this.getNotificationContext(cc).send(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), 1), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
    }

    public void sendTrace(CallContext cc, long level, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        this.getNotificationContext(cc).send(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), 1), Notifier.DISCARDABLE, Notifier.TRANSIENT, level);
    }

    public void sendTrace(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        this.getNotificationContext(cc).send(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), 1), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
    }

    public void sendTrace(CallContext cc, long level, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        this.getNotificationContext(cc).send(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), 1), Notifier.DISCARDABLE, Notifier.TRANSIENT, level);
    }

    public void sendTrace(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        this.getNotificationContext(cc).send(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), 1), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
    }

    public void sendTrace(CallContext cc, long level, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        this.getNotificationContext(cc).send(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), 1), Notifier.DISCARDABLE, Notifier.TRANSIENT, level);
    }

    public void sendTrace(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5, String an6, Object av6) {
        this.getNotificationContext(cc).send(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5, an6, av6), 1), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
    }

    public void sendTrace(CallContext cc, long level, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5, String an6, Object av6) {
        this.getNotificationContext(cc).send(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5, an6, av6), 1), Notifier.DISCARDABLE, Notifier.TRANSIENT, level);
    }

    public void sendTrace(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5, String an6, Object av6, String an7, Object av7) {
        this.getNotificationContext(cc).send(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5, an6, av6, an7, av7), 1), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
    }

    public void sendTrace(CallContext cc, long level, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5, String an6, Object av6, String an7, Object av7) {
        this.getNotificationContext(cc).send(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5, an6, av6, an7, av7), 1), Notifier.DISCARDABLE, Notifier.TRANSIENT, level);
    }

    public void sendTrace(CallContext cc, long level, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5, String an6, Object av6, String an7, Object av7, String an8, Object av8) {
        this.getNotificationContext(cc).send(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5, an6, av6, an7, av7, an8, av8), 1), Notifier.DISCARDABLE, Notifier.TRANSIENT, level);
    }

    public void sendTrace(CallContext cc, long level, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5, String an6, Object av6, String an7, Object av7, String an8, Object av8, String an9, Object av9) {
        this.getNotificationContext(cc).send(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5, an6, av6, an7, av7, an8, av8, an9, av9), 1), Notifier.DISCARDABLE, Notifier.TRANSIENT, level);
    }

    public void sendTrace(CallContext cc, long level, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5, String an6, Object av6, String an7, Object av7, String an8, Object av8, String an9, Object av9, String an10, Object av10) {
        this.getNotificationContext(cc).send(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5, an6, av6, an7, av7, an8, av8, an9, av9, an10, av10), 1), Notifier.DISCARDABLE, Notifier.TRANSIENT, level);
    }

    public void sendTrace(CallContext cc, Variative_String_ text) {
        this.getNotificationContext(cc).send(cc, TraceMessage.create(cc, MessageText.create(cc, text), 1), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
    }

    public void sendTrace(CallContext cc, long level, Variative_String_ text) {
        this.getNotificationContext(cc).send(cc, TraceMessage.create(cc, MessageText.create(cc, text), 1), Notifier.DISCARDABLE, Notifier.TRANSIENT, level);
    }

    public void sendTrace(CallContext cc, Variative_String_ text, Object[][] attributes) {
        this.getNotificationContext(cc).send(cc, TraceMessage.create(cc, MessageText.create(cc, text, attributes), 1), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
    }

    public void sendTrace(CallContext cc, long level, Variative_String_ text, Object[][] attributes) {
        this.getNotificationContext(cc).send(cc, TraceMessage.create(cc, MessageText.create(cc, text, attributes), 1), Notifier.DISCARDABLE, Notifier.TRANSIENT, level);
    }

    public void sendTrace(CallContext cc, Variative_String_ text, String an1, Object av1) {
        this.getNotificationContext(cc).send(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1), 1), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
    }

    public void sendTrace(CallContext cc, long level, Variative_String_ text, String an1, Object av1) {
        this.getNotificationContext(cc).send(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1), 1), Notifier.DISCARDABLE, Notifier.TRANSIENT, level);
    }

    public void sendTrace(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        this.getNotificationContext(cc).send(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), 1), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
    }

    public void sendTrace(CallContext cc, long level, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        this.getNotificationContext(cc).send(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), 1), Notifier.DISCARDABLE, Notifier.TRANSIENT, level);
    }

    public void sendTrace(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        this.getNotificationContext(cc).send(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), 1), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
    }

    public void sendTrace(CallContext cc, long level, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        this.getNotificationContext(cc).send(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), 1), Notifier.DISCARDABLE, Notifier.TRANSIENT, level);
    }

    public void sendTrace(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        this.getNotificationContext(cc).send(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), 1), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
    }

    public void sendTrace(CallContext cc, long level, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        this.getNotificationContext(cc).send(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), 1), Notifier.DISCARDABLE, Notifier.TRANSIENT, level);
    }

    public void sendTrace(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        this.getNotificationContext(cc).send(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), 1), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
    }

    public void sendTrace(CallContext cc, long level, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        this.getNotificationContext(cc).send(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), 1), Notifier.DISCARDABLE, Notifier.TRANSIENT, level);
    }

    public void sendTrace(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5, String an6, Object av6) {
        this.getNotificationContext(cc).send(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5, an6, av6), 1), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
    }

    public void sendTrace(CallContext cc, long level, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5, String an6, Object av6) {
        this.getNotificationContext(cc).send(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5, an6, av6), 1), Notifier.DISCARDABLE, Notifier.TRANSIENT, level);
    }

    //------------------------------------------------------------------------------------------------

    public void sendDigest(CallContext cc, String text) {
        this.getNotificationContext(cc).send(cc, DigestMessage.create(cc, MessageText.create(cc, text)), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
    }

    public void sendDigest(CallContext cc, long level, String text) {
        this.getNotificationContext(cc).send(cc, DigestMessage.create(cc, MessageText.create(cc, text)), Notifier.DISCARDABLE, Notifier.TRANSIENT, level);
    }

    public void sendDigest(CallContext cc, String text, Object[][] attributes) {
        this.getNotificationContext(cc).send(cc, DigestMessage.create(cc, MessageText.create(cc, text, attributes)), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
    }

    public void sendDigest(CallContext cc, long level, String text, Object[][] attributes) {
        this.getNotificationContext(cc).send(cc, DigestMessage.create(cc, MessageText.create(cc, text, attributes)), Notifier.DISCARDABLE, Notifier.TRANSIENT, level);
    }

    public void sendDigest(CallContext cc, String text, String an1, Object av1) {
        this.getNotificationContext(cc).send(cc, DigestMessage.create(cc, MessageText.create(cc, text, an1, av1)), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
    }

    public void sendDigest(CallContext cc, long level, String text, String an1, Object av1) {
        this.getNotificationContext(cc).send(cc, DigestMessage.create(cc, MessageText.create(cc, text, an1, av1)), Notifier.DISCARDABLE, Notifier.TRANSIENT, level);
    }

    public void sendDigest(CallContext cc, String text, String an1, Object av1, String an2, Object av2) {
        this.getNotificationContext(cc).send(cc, DigestMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2)), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
    }

    public void sendDigest(CallContext cc, long level, String text, String an1, Object av1, String an2, Object av2) {
        this.getNotificationContext(cc).send(cc, DigestMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2)), Notifier.DISCARDABLE, Notifier.TRANSIENT, level);
    }

    public void sendDigest(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        this.getNotificationContext(cc).send(cc, DigestMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3)), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
    }

    public void sendDigest(CallContext cc, long level, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        this.getNotificationContext(cc).send(cc, DigestMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3)), Notifier.DISCARDABLE, Notifier.TRANSIENT, level);
    }

    public void sendDigest(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        this.getNotificationContext(cc).send(cc, DigestMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4)), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
    }

    public void sendDigest(CallContext cc, long level, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        this.getNotificationContext(cc).send(cc, DigestMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4)), Notifier.DISCARDABLE, Notifier.TRANSIENT, level);
    }

    public void sendDigest(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        this.getNotificationContext(cc).send(cc, DigestMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5)), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
    }

    public void sendDigest(CallContext cc, long level, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        this.getNotificationContext(cc).send(cc, DigestMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5)), Notifier.DISCARDABLE, Notifier.TRANSIENT, level);
    }

    public void sendDigest(CallContext cc, Variative_String_ text) {
        this.getNotificationContext(cc).send(cc, DigestMessage.create(cc, MessageText.create(cc, text)), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
    }

    public void sendDigest(CallContext cc, long level, Variative_String_ text) {
        this.getNotificationContext(cc).send(cc, DigestMessage.create(cc, MessageText.create(cc, text)), Notifier.DISCARDABLE, Notifier.TRANSIENT, level);
    }

    public void sendDigest(CallContext cc, Variative_String_ text, Object[][] attributes) {
        this.getNotificationContext(cc).send(cc, DigestMessage.create(cc, MessageText.create(cc, text, attributes)), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
    }

    public void sendDigest(CallContext cc, long level, Variative_String_ text, Object[][] attributes) {
        this.getNotificationContext(cc).send(cc, DigestMessage.create(cc, MessageText.create(cc, text, attributes)), Notifier.DISCARDABLE, Notifier.TRANSIENT, level);
    }

    public void sendDigest(CallContext cc, Variative_String_ text, String an1, Object av1) {
        this.getNotificationContext(cc).send(cc, DigestMessage.create(cc, MessageText.create(cc, text, an1, av1)), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
    }

    public void sendDigest(CallContext cc, long level, Variative_String_ text, String an1, Object av1) {
        this.getNotificationContext(cc).send(cc, DigestMessage.create(cc, MessageText.create(cc, text, an1, av1)), Notifier.DISCARDABLE, Notifier.TRANSIENT, level);
    }

    public void sendDigest(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        this.getNotificationContext(cc).send(cc, DigestMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2)), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
    }

    public void sendDigest(CallContext cc, long level, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        this.getNotificationContext(cc).send(cc, DigestMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2)), Notifier.DISCARDABLE, Notifier.TRANSIENT, level);
    }

    public void sendDigest(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        this.getNotificationContext(cc).send(cc, DigestMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3)), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
    }

    public void sendDigest(CallContext cc, long level, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        this.getNotificationContext(cc).send(cc, DigestMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3)), Notifier.DISCARDABLE, Notifier.TRANSIENT, level);
    }

    public void sendDigest(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        this.getNotificationContext(cc).send(cc, DigestMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4)), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
    }

    public void sendDigest(CallContext cc, long level, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        this.getNotificationContext(cc).send(cc, DigestMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4)), Notifier.DISCARDABLE, Notifier.TRANSIENT, level);
    }

    public void sendDigest(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        this.getNotificationContext(cc).send(cc, DigestMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5)), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
    }

    public void sendDigest(CallContext cc, long level, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        this.getNotificationContext(cc).send(cc, DigestMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5)), Notifier.DISCARDABLE, Notifier.TRANSIENT, level);
    }

    //------------------------------------------------------------------------------------------------

    public void sendOk(CallContext cc, String text) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.OK), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
    }

    public void sendOk(CallContext cc, String text, Object[][] attributes) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.OK), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
    }

    public void sendOk(CallContext cc, String text, String an1, Object av1) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.OK), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
    }

    public void sendOk(CallContext cc, String text, String an1, Object av1, String an2, Object av2) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.OK), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
    }

    public void sendOk(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.OK), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
    }

    public void sendOk(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.OK), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
    }

    public void sendOk(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.OK), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
    }

    public void sendOk(CallContext cc, Variative_String_ text) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.OK), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
    }

    public void sendOk(CallContext cc, Variative_String_ text, Object[][] attributes) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.OK), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
    }

    public void sendOk(CallContext cc, Variative_String_ text, String an1, Object av1) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.OK), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
    }

    public void sendOk(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.OK), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
    }

    public void sendOk(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.OK), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
    }

    public void sendOk(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.OK), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
    }

    public void sendOk(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.OK), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
    }

    //------------------------------------------------------------------------------------------------

    public void sendInfo(CallContext cc, String text) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.INFO), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
    }

    public void sendInfo(CallContext cc, String text, Object[][] attributes) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.INFO), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
    }

    public void sendInfo(CallContext cc, String text, String an1, Object av1) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.INFO), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
    }

    public void sendInfo(CallContext cc, String text, String an1, Object av1, String an2, Object av2) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.INFO), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
    }

    public void sendInfo(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.INFO), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
    }

    public void sendInfo(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.INFO), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
    }

    public void sendInfo(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.INFO), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
    }

    public void sendInfo(CallContext cc, Variative_String_ text) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.INFO), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
    }

    public void sendInfo(CallContext cc, Variative_String_ text, Object[][] attributes) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.INFO), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
    }

    public void sendInfo(CallContext cc, Variative_String_ text, String an1, Object av1) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.INFO), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
    }

    public void sendInfo(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.INFO), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
    }

    public void sendInfo(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.INFO), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
    }

    public void sendInfo(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.INFO), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
    }

    public void sendInfo(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.INFO), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
    }

    //------------------------------------------------------------------------------------------------

    public void sendNotice(CallContext cc, String text) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.NOTICE), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
    }

    public void sendNotice(CallContext cc, String text, Object[][] attributes) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.NOTICE), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
    }

    public void sendNotice(CallContext cc, String text, String an1, Object av1) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.NOTICE), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
    }

    public void sendNotice(CallContext cc, String text, String an1, Object av1, String an2, Object av2) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.NOTICE), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
    }

    public void sendNotice(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.NOTICE), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
    }

    public void sendNotice(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.NOTICE), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
    }

    public void sendNotice(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.NOTICE), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
    }

    public void sendNotice(CallContext cc, Variative_String_ text) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.NOTICE), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
    }

    public void sendNotice(CallContext cc, Variative_String_ text, Object[][] attributes) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.NOTICE), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
    }

    public void sendNotice(CallContext cc, Variative_String_ text, String an1, Object av1) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.NOTICE), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
    }

    public void sendNotice(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.NOTICE), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
    }

    public void sendNotice(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.NOTICE), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
    }

    public void sendNotice(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.NOTICE), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
    }

    public void sendNotice(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.NOTICE), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
    }

    //------------------------------------------------------------------------------------------------

    public void sendCaution(CallContext cc, String text) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.CAUTION), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    public void sendCaution(CallContext cc, String text, Object[][] attributes) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.CAUTION), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    public void sendCaution(CallContext cc, String text, String an1, Object av1) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.CAUTION), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    public void sendCaution(CallContext cc, String text, String an1, Object av1, String an2, Object av2) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.CAUTION), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    public void sendCaution(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.CAUTION), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    public void sendCaution(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.CAUTION), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    public void sendCaution(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.CAUTION), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    public void sendCaution(CallContext cc, Variative_String_ text) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.CAUTION), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    public void sendCaution(CallContext cc, Variative_String_ text, Object[][] attributes) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.CAUTION), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    public void sendCaution(CallContext cc, Variative_String_ text, String an1, Object av1) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.CAUTION), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    public void sendCaution(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.CAUTION), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    public void sendCaution(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.CAUTION), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    public void sendCaution(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.CAUTION), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    public void sendCaution(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.CAUTION), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    //------------------------------------------------------------------------------------------------

    public void sendWarning(CallContext cc, String text) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.WARNING), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    public void sendWarning(CallContext cc, String text, Object[][] attributes) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.WARNING), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    public void sendWarning(CallContext cc, String text, String an1, Object av1) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.WARNING), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    public void sendWarning(CallContext cc, String text, String an1, Object av1, String an2, Object av2) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.WARNING), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    public void sendWarning(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.WARNING), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    public void sendWarning(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.WARNING), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    public void sendWarning(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.WARNING), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    public void sendWarning(CallContext cc, Variative_String_ text) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.WARNING), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    public void sendWarning(CallContext cc, Variative_String_ text, Object[][] attributes) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.WARNING), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    public void sendWarning(CallContext cc, Variative_String_ text, String an1, Object av1) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.WARNING), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    public void sendWarning(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.WARNING), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    public void sendWarning(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.WARNING), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    public void sendWarning(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.WARNING), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    public void sendWarning(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.WARNING), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    //------------------------------------------------------------------------------------------------

    public void sendSevereWarning(CallContext cc, String text) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.SEVERE_WARNING), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    public void sendSevereWarning(CallContext cc, String text, Object[][] attributes) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.SEVERE_WARNING), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    public void sendSevereWarning(CallContext cc, String text, String an1, Object av1) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.SEVERE_WARNING), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    public void sendSevereWarning(CallContext cc, String text, String an1, Object av1, String an2, Object av2) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.SEVERE_WARNING), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    public void sendSevereWarning(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.SEVERE_WARNING), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    public void sendSevereWarning(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.SEVERE_WARNING), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    public void sendSevereWarning(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.SEVERE_WARNING), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    public void sendSevereWarning(CallContext cc, Variative_String_ text) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.SEVERE_WARNING), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    public void sendSevereWarning(CallContext cc, Variative_String_ text, Object[][] attributes) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.SEVERE_WARNING), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    public void sendSevereWarning(CallContext cc, Variative_String_ text, String an1, Object av1) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.SEVERE_WARNING), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    public void sendSevereWarning(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.SEVERE_WARNING), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    public void sendSevereWarning(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.SEVERE_WARNING), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    public void sendSevereWarning(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.SEVERE_WARNING), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    public void sendSevereWarning(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.SEVERE_WARNING), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.MONITORING);
    }

    //------------------------------------------------------------------------------------------------

    public void sendError(CallContext cc, String text) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendError(CallContext cc, String text, Object[][] attributes) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendError(CallContext cc, String text, String an1, Object av1) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendError(CallContext cc, String text, String an1, Object av1, String an2, Object av2) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendError(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendError(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendError(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendError(CallContext cc, Variative_String_ text) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendError(CallContext cc, Variative_String_ text, Object[][] attributes) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendError(CallContext cc, Variative_String_ text, String an1, Object av1) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendError(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendError(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendError(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendError(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    //------------------------------------------------------------------------------------------------

    public void sendCriticalError(CallContext cc, String text) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.CRITICAL_ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendCriticalError(CallContext cc, String text, Object[][] attributes) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.CRITICAL_ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendCriticalError(CallContext cc, String text, String an1, Object av1) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.CRITICAL_ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendCriticalError(CallContext cc, String text, String an1, Object av1, String an2, Object av2) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.CRITICAL_ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendCriticalError(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.CRITICAL_ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendCriticalError(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.CRITICAL_ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendCriticalError(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.CRITICAL_ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendCriticalError(CallContext cc, Variative_String_ text) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.CRITICAL_ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendCriticalError(CallContext cc, Variative_String_ text, Object[][] attributes) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.CRITICAL_ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendCriticalError(CallContext cc, Variative_String_ text, String an1, Object av1) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.CRITICAL_ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendCriticalError(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.CRITICAL_ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendCriticalError(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.CRITICAL_ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendCriticalError(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.CRITICAL_ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendCriticalError(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.CRITICAL_ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    //------------------------------------------------------------------------------------------------

    public void sendFatalError(CallContext cc, String text) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.FATAL_ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendFatalError(CallContext cc, String text, Object[][] attributes) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.FATAL_ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendFatalError(CallContext cc, String text, String an1, Object av1) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.FATAL_ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendFatalError(CallContext cc, String text, String an1, Object av1, String an2, Object av2) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.FATAL_ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendFatalError(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.FATAL_ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendFatalError(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.FATAL_ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendFatalError(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.FATAL_ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendFatalError(CallContext cc, Variative_String_ text) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.FATAL_ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendFatalError(CallContext cc, Variative_String_ text, Object[][] attributes) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.FATAL_ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendFatalError(CallContext cc, Variative_String_ text, String an1, Object av1) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.FATAL_ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendFatalError(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.FATAL_ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendFatalError(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.FATAL_ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendFatalError(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.FATAL_ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendFatalError(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.FATAL_ERROR), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    //------------------------------------------------------------------------------------------------

    public void sendEmergency(CallContext cc, String text) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.EMERGENCY), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendEmergency(CallContext cc, String text, Object[][] attributes) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.EMERGENCY), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendEmergency(CallContext cc, String text, String an1, Object av1) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.EMERGENCY), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendEmergency(CallContext cc, String text, String an1, Object av1, String an2, Object av2) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.EMERGENCY), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendEmergency(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.EMERGENCY), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendEmergency(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.EMERGENCY), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendEmergency(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.EMERGENCY), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendEmergency(CallContext cc, Variative_String_ text) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.EMERGENCY), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendEmergency(CallContext cc, Variative_String_ text, Object[][] attributes) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.EMERGENCY), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendEmergency(CallContext cc, Variative_String_ text, String an1, Object av1) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.EMERGENCY), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendEmergency(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.EMERGENCY), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendEmergency(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.EMERGENCY), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendEmergency(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.EMERGENCY), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendEmergency(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.EMERGENCY), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    //------------------------------------------------------------------------------------------------

    public void sendPanic(CallContext cc, String text) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.PANIC), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendPanic(CallContext cc, String text, Object[][] attributes) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.PANIC), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendPanic(CallContext cc, String text, String an1, Object av1) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.PANIC), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendPanic(CallContext cc, String text, String an1, Object av1, String an2, Object av2) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.PANIC), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendPanic(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.PANIC), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendPanic(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.PANIC), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendPanic(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.PANIC), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendPanic(CallContext cc, Variative_String_ text) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.PANIC), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendPanic(CallContext cc, Variative_String_ text, Object[][] attributes) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.PANIC), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendPanic(CallContext cc, Variative_String_ text, String an1, Object av1) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.PANIC), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendPanic(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.PANIC), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendPanic(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.PANIC), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendPanic(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.PANIC), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    public void sendPanic(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        this.getNotificationContext(cc).send(cc, SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.PANIC), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
    }

    //------------------------------------------------------------------------------------------------

    public ExceptionEnvironmentError createEnvironmentError(CallContext cc, String text, Object... arguments) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, arguments), ProblemState.ERROR);
        return ExceptionEnvironmentError.createExceptionEnvironmentError(cc, message);
    }

    public ExceptionEnvironmentError createEnvironmentError(CallContext cc, Throwable cause, String text, Object... arguments) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, arguments), ProblemState.ERROR);
        return ExceptionEnvironmentError.createExceptionEnvironmentError(cc, cause, message);
    }

    public void throwEnvironmentError(CallContext cc, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, message);
    }

    public void throwEnvironmentError(CallContext cc, Throwable cause, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentError(CallContext cc, ProblemState problem_state, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, message);
    }

    public void throwEnvironmentError(CallContext cc, ProblemState problem_state, Throwable cause, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentError(CallContext cc, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, message);
    }

    public void throwEnvironmentError(CallContext cc, Throwable cause, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentError(CallContext cc, ProblemState problem_state, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, message);
    }

    public void throwEnvironmentError(CallContext cc, ProblemState problem_state, Throwable cause, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentError(CallContext cc, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, message);
    }

    public void throwEnvironmentError(CallContext cc, Throwable cause, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentError(CallContext cc, ProblemState problem_state, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, message);
    }

    public void throwEnvironmentError(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentError(CallContext cc, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, message);
    }

    public void throwEnvironmentError(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentError(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, message);
    }

    public void throwEnvironmentError(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentError(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, message);
    }

    public void throwEnvironmentError(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentError(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, message);
    }

    public void throwEnvironmentError(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentError(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, message);
    }

    public void throwEnvironmentError(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentError(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, message);
    }

    public void throwEnvironmentError(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentError(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, message);
    }

    public void throwEnvironmentError(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentError(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, message);
    }

    public void throwEnvironmentError(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentError(CallContext cc, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, message);
    }

    public void throwEnvironmentError(CallContext cc, Throwable cause, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentError(CallContext cc, ProblemState problem_state, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, message);
    }

    public void throwEnvironmentError(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentError(CallContext cc, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, message);
    }

    public void throwEnvironmentError(CallContext cc, Throwable cause, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentError(CallContext cc, ProblemState problem_state, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, message);
    }

    public void throwEnvironmentError(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentError(CallContext cc, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, message);
    }

    public void throwEnvironmentError(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentError(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, message);
    }

    public void throwEnvironmentError(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentError(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, message);
    }

    public void throwEnvironmentError(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentError(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, message);
    }

    public void throwEnvironmentError(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentError(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, message);
    }

    public void throwEnvironmentError(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentError(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, message);
    }

    public void throwEnvironmentError(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentError(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, message);
    }

    public void throwEnvironmentError(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentError(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, message);
    }

    public void throwEnvironmentError(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentError(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, message);
    }

    public void throwEnvironmentError(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentError(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, message);
    }

    public void throwEnvironmentError(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentError.createAndThrow(cc, cause, message);
    }

    //------------------------------------------------------------------------------------------------

    public ExceptionInstallationError createInstallationError(CallContext cc, String text, Object... arguments) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, arguments), ProblemState.ERROR);
        return ExceptionInstallationError.createExceptionInstallationError(cc, message);
    }

    public ExceptionInstallationError createInstallationError(CallContext cc, Throwable cause, String text, Object... arguments) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, arguments), ProblemState.ERROR);
        return ExceptionInstallationError.createExceptionInstallationError(cc, cause, message);
    }

    public void throwInstallationError(CallContext cc, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, message);
    }

    public void throwInstallationError(CallContext cc, Throwable cause, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, cause, message);
    }

    public void throwInstallationError(CallContext cc, ProblemState problem_state, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, message);
    }

    public void throwInstallationError(CallContext cc, ProblemState problem_state, Throwable cause, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, cause, message);
    }

    public void throwInstallationError(CallContext cc, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, message);
    }

    public void throwInstallationError(CallContext cc, Throwable cause, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, cause, message);
    }

    public void throwInstallationError(CallContext cc, ProblemState problem_state, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, message);
    }

    public void throwInstallationError(CallContext cc, ProblemState problem_state, Throwable cause, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, cause, message);
    }

    public void throwInstallationError(CallContext cc, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, message);
    }

    public void throwInstallationError(CallContext cc, Throwable cause, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, cause, message);
    }

    public void throwInstallationError(CallContext cc, ProblemState problem_state, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, message);
    }

    public void throwInstallationError(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, cause, message);
    }

    public void throwInstallationError(CallContext cc, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, message);
    }

    public void throwInstallationError(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, cause, message);
    }

    public void throwInstallationError(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, message);
    }

    public void throwInstallationError(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, cause, message);
    }

    public void throwInstallationError(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, message);
    }

    public void throwInstallationError(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, cause, message);
    }

    public void throwInstallationError(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, message);
    }

    public void throwInstallationError(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, cause, message);
    }

    public void throwInstallationError(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, message);
    }

    public void throwInstallationError(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, cause, message);
    }

    public void throwInstallationError(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, message);
    }

    public void throwInstallationError(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, cause, message);
    }

    public void throwInstallationError(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, message);
    }

    public void throwInstallationError(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, cause, message);
    }

    public void throwInstallationError(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, message);
    }

    public void throwInstallationError(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, cause, message);
    }

    public void throwInstallationError(CallContext cc, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, message);
    }

    public void throwInstallationError(CallContext cc, Throwable cause, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, cause, message);
    }

    public void throwInstallationError(CallContext cc, ProblemState problem_state, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, message);
    }

    public void throwInstallationError(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, cause, message);
    }

    public void throwInstallationError(CallContext cc, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, message);
    }

    public void throwInstallationError(CallContext cc, Throwable cause, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, cause, message);
    }

    public void throwInstallationError(CallContext cc, ProblemState problem_state, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, message);
    }

    public void throwInstallationError(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, cause, message);
    }

    public void throwInstallationError(CallContext cc, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, message);
    }

    public void throwInstallationError(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, cause, message);
    }

    public void throwInstallationError(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, message);
    }

    public void throwInstallationError(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, cause, message);
    }

    public void throwInstallationError(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, message);
    }

    public void throwInstallationError(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, cause, message);
    }

    public void throwInstallationError(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, message);
    }

    public void throwInstallationError(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, cause, message);
    }

    public void throwInstallationError(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, message);
    }

    public void throwInstallationError(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, cause, message);
    }

    public void throwInstallationError(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, message);
    }

    public void throwInstallationError(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, cause, message);
    }

    public void throwInstallationError(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, message);
    }

    public void throwInstallationError(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, cause, message);
    }

    public void throwInstallationError(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, message);
    }

    public void throwInstallationError(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, cause, message);
    }

    public void throwInstallationError(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, message);
    }

    public void throwInstallationError(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, cause, message);
    }

    public void throwInstallationError(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, message);
    }

    public void throwInstallationError(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInstallationError.createAndThrow(cc, cause, message);
    }

    //------------------------------------------------------------------------------------------------

    public ExceptionConfigurationError createConfigurationError(CallContext cc, String text, Object... arguments) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, arguments), ProblemState.ERROR);
        return ExceptionConfigurationError.createExceptionConfigurationError(cc, message);
    }

    public ExceptionConfigurationError createConfigurationError(CallContext cc, Throwable cause, String text, Object... arguments) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, arguments), ProblemState.ERROR);
        return ExceptionConfigurationError.createExceptionConfigurationError(cc, cause, message);
    }

    public void throwConfigurationError(CallContext cc, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, message);
    }

    public void throwConfigurationError(CallContext cc, Throwable cause, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, cause, message);
    }

    public void throwConfigurationError(CallContext cc, ProblemState problem_state, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, message);
    }

    public void throwConfigurationError(CallContext cc, ProblemState problem_state, Throwable cause, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, cause, message);
    }

    public void throwConfigurationError(CallContext cc, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, message);
    }

    public void throwConfigurationError(CallContext cc, Throwable cause, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, cause, message);
    }

    public void throwConfigurationError(CallContext cc, ProblemState problem_state, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, message);
    }

    public void throwConfigurationError(CallContext cc, ProblemState problem_state, Throwable cause, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, cause, message);
    }

    public void throwConfigurationError(CallContext cc, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, message);
    }

    public void throwConfigurationError(CallContext cc, Throwable cause, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, cause, message);
    }

    public void throwConfigurationError(CallContext cc, ProblemState problem_state, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, message);
    }

    public void throwConfigurationError(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, cause, message);
    }

    public void throwConfigurationError(CallContext cc, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, message);
    }

    public void throwConfigurationError(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, cause, message);
    }

    public void throwConfigurationError(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, message);
    }

    public void throwConfigurationError(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, cause, message);
    }

    public void throwConfigurationError(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, message);
    }

    public void throwConfigurationError(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, cause, message);
    }

    public void throwConfigurationError(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, message);
    }

    public void throwConfigurationError(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, cause, message);
    }

    public void throwConfigurationError(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, message);
    }

    public void throwConfigurationError(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, cause, message);
    }

    public void throwConfigurationError(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, message);
    }

    public void throwConfigurationError(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, cause, message);
    }

    public void throwConfigurationError(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, message);
    }

    public void throwConfigurationError(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, cause, message);
    }

    public void throwConfigurationError(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, message);
    }

    public void throwConfigurationError(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, cause, message);
    }

    public void throwConfigurationError(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5, String an6, Object av6) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5, an6, av6), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, message);
    }

    public void throwConfigurationError(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5, String an6, Object av6) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5, an6, av6), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, cause, message);
    }

    public void throwConfigurationError(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5, String an6, Object av6) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5, an6, av6), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, message);
    }

    public void throwConfigurationError(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5, String an6, Object av6) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5, an6, av6), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, cause, message);
    }

    public void throwConfigurationError(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5, String an6, Object av6, String an7, Object av7) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5, an6, av6, an7, av7), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, message);
    }

    public void throwConfigurationError(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5, String an6, Object av6, String an7, Object av7) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5, an6, av6, an7, av7), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, cause, message);
    }

    public void throwConfigurationError(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5, String an6, Object av6, String an7, Object av7) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5, an6, av6, an7, av7), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, message);
    }

    public void throwConfigurationError(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5, String an6, Object av6, String an7, Object av7) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5, an6, av6, an7, av7), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, cause, message);
    }

    public void throwConfigurationError(CallContext cc, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, message);
    }

    public void throwConfigurationError(CallContext cc, Throwable cause, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, cause, message);
    }

    public void throwConfigurationError(CallContext cc, ProblemState problem_state, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, message);
    }

    public void throwConfigurationError(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, cause, message);
    }

    public void throwConfigurationError(CallContext cc, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, message);
    }

    public void throwConfigurationError(CallContext cc, Throwable cause, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, cause, message);
    }

    public void throwConfigurationError(CallContext cc, ProblemState problem_state, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, message);
    }

    public void throwConfigurationError(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, cause, message);
    }

    public void throwConfigurationError(CallContext cc, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, message);
    }

    public void throwConfigurationError(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, cause, message);
    }

    public void throwConfigurationError(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, message);
    }

    public void throwConfigurationError(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, cause, message);
    }

    public void throwConfigurationError(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, message);
    }

    public void throwConfigurationError(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, cause, message);
    }

    public void throwConfigurationError(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, message);
    }

    public void throwConfigurationError(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, cause, message);
    }

    public void throwConfigurationError(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, message);
    }

    public void throwConfigurationError(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, cause, message);
    }

    public void throwConfigurationError(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, message);
    }

    public void throwConfigurationError(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, cause, message);
    }

    public void throwConfigurationError(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, message);
    }

    public void throwConfigurationError(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, cause, message);
    }

    public void throwConfigurationError(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, message);
    }

    public void throwConfigurationError(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, cause, message);
    }

    public void throwConfigurationError(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, message);
    }

    public void throwConfigurationError(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, cause, message);
    }

    public void throwConfigurationError(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, message);
    }

    public void throwConfigurationError(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionConfigurationError.createAndThrow(cc, cause, message);
    }

    //------------------------------------------------------------------------------------------------

    public ExceptionSecurityViolation createSecurityViolation(CallContext cc, String text, Object... arguments) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, arguments), ProblemState.ERROR);
        return ExceptionSecurityViolation.createExceptionSecurityViolation(cc, message);
    }

    public ExceptionSecurityViolation createSecurityViolation(CallContext cc, Throwable cause, String text, Object... arguments) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, arguments), ProblemState.ERROR);
        return ExceptionSecurityViolation.createExceptionSecurityViolation(cc, cause, message);
    }

    public void throwSecurityViolation(CallContext cc, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, message);
    }

    public void throwSecurityViolation(CallContext cc, Throwable cause, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, cause, message);
    }

    public void throwSecurityViolation(CallContext cc, ProblemState problem_state, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, message);
    }

    public void throwSecurityViolation(CallContext cc, ProblemState problem_state, Throwable cause, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, cause, message);
    }

    public void throwSecurityViolation(CallContext cc, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, message);
    }

    public void throwSecurityViolation(CallContext cc, Throwable cause, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, cause, message);
    }

    public void throwSecurityViolation(CallContext cc, ProblemState problem_state, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, message);
    }

    public void throwSecurityViolation(CallContext cc, ProblemState problem_state, Throwable cause, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, cause, message);
    }

    public void throwSecurityViolation(CallContext cc, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, message);
    }

    public void throwSecurityViolation(CallContext cc, Throwable cause, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, cause, message);
    }

    public void throwSecurityViolation(CallContext cc, ProblemState problem_state, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, message);
    }

    public void throwSecurityViolation(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, cause, message);
    }

    public void throwSecurityViolation(CallContext cc, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, message);
    }

    public void throwSecurityViolation(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, cause, message);
    }

    public void throwSecurityViolation(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, message);
    }

    public void throwSecurityViolation(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, cause, message);
    }

    public void throwSecurityViolation(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, message);
    }

    public void throwSecurityViolation(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, cause, message);
    }

    public void throwSecurityViolation(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, message);
    }

    public void throwSecurityViolation(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, cause, message);
    }

    public void throwSecurityViolation(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, message);
    }

    public void throwSecurityViolation(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, cause, message);
    }

    public void throwSecurityViolation(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, message);
    }

    public void throwSecurityViolation(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, cause, message);
    }

    public void throwSecurityViolation(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, message);
    }

    public void throwSecurityViolation(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, cause, message);
    }

    public void throwSecurityViolation(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, message);
    }

    public void throwSecurityViolation(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, cause, message);
    }

    public void throwSecurityViolation(CallContext cc, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, message);
    }

    public void throwSecurityViolation(CallContext cc, Throwable cause, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, cause, message);
    }

    public void throwSecurityViolation(CallContext cc, ProblemState problem_state, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, message);
    }

    public void throwSecurityViolation(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, cause, message);
    }

    public void throwSecurityViolation(CallContext cc, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, message);
    }

    public void throwSecurityViolation(CallContext cc, Throwable cause, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, cause, message);
    }

    public void throwSecurityViolation(CallContext cc, ProblemState problem_state, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, message);
    }

    public void throwSecurityViolation(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, cause, message);
    }

    public void throwSecurityViolation(CallContext cc, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, message);
    }

    public void throwSecurityViolation(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, cause, message);
    }

    public void throwSecurityViolation(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, message);
    }

    public void throwSecurityViolation(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, cause, message);
    }

    public void throwSecurityViolation(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, message);
    }

    public void throwSecurityViolation(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, cause, message);
    }

    public void throwSecurityViolation(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, message);
    }

    public void throwSecurityViolation(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, cause, message);
    }

    public void throwSecurityViolation(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, message);
    }

    public void throwSecurityViolation(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, cause, message);
    }

    public void throwSecurityViolation(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, message);
    }

    public void throwSecurityViolation(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, cause, message);
    }

    public void throwSecurityViolation(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, message);
    }

    public void throwSecurityViolation(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, cause, message);
    }

    public void throwSecurityViolation(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, message);
    }

    public void throwSecurityViolation(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, cause, message);
    }

    public void throwSecurityViolation(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, message);
    }

    public void throwSecurityViolation(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, cause, message);
    }

    public void throwSecurityViolation(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, message);
    }

    public void throwSecurityViolation(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionSecurityViolation.createAndThrow(cc, cause, message);
    }

    //------------------------------------------------------------------------------------------------

    public ExceptionEnvironmentFailure createEnvironmentFailure(CallContext cc, String text, Object... arguments) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, arguments), ProblemState.ERROR);
        return ExceptionEnvironmentFailure.createExceptionEnvironmentFailure(cc, message);
    }

    public ExceptionEnvironmentFailure createEnvironmentFailure(CallContext cc, Throwable cause, String text, Object... arguments) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, arguments), ProblemState.ERROR);
        return ExceptionEnvironmentFailure.createExceptionEnvironmentFailure(cc, cause, message);
    }

    public void throwEnvironmentFailure(CallContext cc, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, message);
    }

    public void throwEnvironmentFailure(CallContext cc, Throwable cause, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentFailure(CallContext cc, ProblemState problem_state, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, message);
    }

    public void throwEnvironmentFailure(CallContext cc, ProblemState problem_state, Throwable cause, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentFailure(CallContext cc, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, message);
    }

    public void throwEnvironmentFailure(CallContext cc, Throwable cause, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentFailure(CallContext cc, ProblemState problem_state, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, message);
    }

    public void throwEnvironmentFailure(CallContext cc, ProblemState problem_state, Throwable cause, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentFailure(CallContext cc, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, message);
    }

    public void throwEnvironmentFailure(CallContext cc, Throwable cause, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentFailure(CallContext cc, ProblemState problem_state, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, message);
    }

    public void throwEnvironmentFailure(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentFailure(CallContext cc, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, message);
    }

    public void throwEnvironmentFailure(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentFailure(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, message);
    }

    public void throwEnvironmentFailure(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentFailure(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, message);
    }

    public void throwEnvironmentFailure(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentFailure(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, message);
    }

    public void throwEnvironmentFailure(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentFailure(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, message);
    }

    public void throwEnvironmentFailure(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentFailure(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, message);
    }

    public void throwEnvironmentFailure(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentFailure(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, message);
    }

    public void throwEnvironmentFailure(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentFailure(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, message);
    }

    public void throwEnvironmentFailure(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentFailure(CallContext cc, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, message);
    }

    public void throwEnvironmentFailure(CallContext cc, Throwable cause, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentFailure(CallContext cc, ProblemState problem_state, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, message);
    }

    public void throwEnvironmentFailure(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentFailure(CallContext cc, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, message);
    }

    public void throwEnvironmentFailure(CallContext cc, Throwable cause, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentFailure(CallContext cc, ProblemState problem_state, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, message);
    }

    public void throwEnvironmentFailure(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentFailure(CallContext cc, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, message);
    }

    public void throwEnvironmentFailure(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentFailure(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, message);
    }

    public void throwEnvironmentFailure(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentFailure(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, message);
    }

    public void throwEnvironmentFailure(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentFailure(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, message);
    }

    public void throwEnvironmentFailure(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentFailure(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, message);
    }

    public void throwEnvironmentFailure(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentFailure(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, message);
    }

    public void throwEnvironmentFailure(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentFailure(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, message);
    }

    public void throwEnvironmentFailure(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentFailure(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, message);
    }

    public void throwEnvironmentFailure(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentFailure(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, message);
    }

    public void throwEnvironmentFailure(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, cause, message);
    }

    public void throwEnvironmentFailure(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, message);
    }

    public void throwEnvironmentFailure(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionEnvironmentFailure.createAndThrow(cc, cause, message);
    }

    //------------------------------------------------------------------------------------------------

    public ExceptionLimitation createLimitation(CallContext cc, String text, Object... arguments) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, arguments), ProblemState.ERROR);
        return ExceptionLimitation.createExceptionLimitation(cc, message);
    }

    public ExceptionLimitation createLimitation(CallContext cc, Throwable cause, String text, Object... arguments) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, arguments), ProblemState.ERROR);
        return ExceptionLimitation.createExceptionLimitation(cc, cause, message);
    }

    public void throwLimitation(CallContext cc, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, message);
    }

    public void throwLimitation(CallContext cc, Throwable cause, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, cause, message);
    }

    public void throwLimitation(CallContext cc, ProblemState problem_state, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, message);
    }

    public void throwLimitation(CallContext cc, ProblemState problem_state, Throwable cause, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, cause, message);
    }

    public void throwLimitation(CallContext cc, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, message);
    }

    public void throwLimitation(CallContext cc, Throwable cause, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, cause, message);
    }

    public void throwLimitation(CallContext cc, ProblemState problem_state, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, message);
    }

    public void throwLimitation(CallContext cc, ProblemState problem_state, Throwable cause, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, cause, message);
    }

    public void throwLimitation(CallContext cc, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, message);
    }

    public void throwLimitation(CallContext cc, Throwable cause, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, cause, message);
    }

    public void throwLimitation(CallContext cc, ProblemState problem_state, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, message);
    }

    public void throwLimitation(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, cause, message);
    }

    public void throwLimitation(CallContext cc, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, message);
    }

    public void throwLimitation(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, cause, message);
    }

    public void throwLimitation(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, message);
    }

    public void throwLimitation(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, cause, message);
    }

    public void throwLimitation(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, message);
    }

    public void throwLimitation(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, cause, message);
    }

    public void throwLimitation(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, message);
    }

    public void throwLimitation(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, cause, message);
    }

    public void throwLimitation(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, message);
    }

    public void throwLimitation(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, cause, message);
    }

    public void throwLimitation(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, message);
    }

    public void throwLimitation(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, cause, message);
    }

    public void throwLimitation(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, message);
    }

    public void throwLimitation(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, cause, message);
    }

    public void throwLimitation(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, message);
    }

    public void throwLimitation(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, cause, message);
    }

    public void throwLimitation(CallContext cc, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, message);
    }

    public void throwLimitation(CallContext cc, Throwable cause, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, cause, message);
    }

    public void throwLimitation(CallContext cc, ProblemState problem_state, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, message);
    }

    public void throwLimitation(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, cause, message);
    }

    public void throwLimitation(CallContext cc, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, message);
    }

    public void throwLimitation(CallContext cc, Throwable cause, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, cause, message);
    }

    public void throwLimitation(CallContext cc, ProblemState problem_state, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, message);
    }

    public void throwLimitation(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, cause, message);
    }

    public void throwLimitation(CallContext cc, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, message);
    }

    public void throwLimitation(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, cause, message);
    }

    public void throwLimitation(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, message);
    }

    public void throwLimitation(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, cause, message);
    }

    public void throwLimitation(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, message);
    }

    public void throwLimitation(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, cause, message);
    }

    public void throwLimitation(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, message);
    }

    public void throwLimitation(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, cause, message);
    }

    public void throwLimitation(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, message);
    }

    public void throwLimitation(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, cause, message);
    }

    public void throwLimitation(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, message);
    }

    public void throwLimitation(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, cause, message);
    }

    public void throwLimitation(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, message);
    }

    public void throwLimitation(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, cause, message);
    }

    public void throwLimitation(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, message);
    }

    public void throwLimitation(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, cause, message);
    }

    public void throwLimitation(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, message);
    }

    public void throwLimitation(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, cause, message);
    }

    public void throwLimitation(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, message);
    }

    public void throwLimitation(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionLimitation.createAndThrow(cc, cause, message);
    }

    //------------------------------------------------------------------------------------------------

    public ExceptionVerificationFailure createVerificationFailure(CallContext cc, String text, Object... arguments) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, arguments), ProblemState.ERROR);
        return ExceptionVerificationFailure.createExceptionVerificationFailure(cc, message);
    }

    public ExceptionVerificationFailure createVerificationFailure(CallContext cc, Throwable cause, String text, Object... arguments) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, arguments), ProblemState.ERROR);
        return ExceptionVerificationFailure.createExceptionVerificationFailure(cc, cause, message);
    }

    public void throwVerificationFailure(CallContext cc, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, message);
    }

    public void throwVerificationFailure(CallContext cc, Throwable cause, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, cause, message);
    }

    public void throwVerificationFailure(CallContext cc, ProblemState problem_state, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, message);
    }

    public void throwVerificationFailure(CallContext cc, ProblemState problem_state, Throwable cause, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, cause, message);
    }

    public void throwVerificationFailure(CallContext cc, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, message);
    }

    public void throwVerificationFailure(CallContext cc, Throwable cause, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, cause, message);
    }

    public void throwVerificationFailure(CallContext cc, ProblemState problem_state, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, message);
    }

    public void throwVerificationFailure(CallContext cc, ProblemState problem_state, Throwable cause, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, cause, message);
    }

    public void throwVerificationFailure(CallContext cc, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, message);
    }

    public void throwVerificationFailure(CallContext cc, Throwable cause, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, cause, message);
    }

    public void throwVerificationFailure(CallContext cc, ProblemState problem_state, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, message);
    }

    public void throwVerificationFailure(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, cause, message);
    }

    public void throwVerificationFailure(CallContext cc, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, message);
    }

    public void throwVerificationFailure(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, cause, message);
    }

    public void throwVerificationFailure(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, message);
    }

    public void throwVerificationFailure(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, cause, message);
    }

    public void throwVerificationFailure(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, message);
    }

    public void throwVerificationFailure(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, cause, message);
    }

    public void throwVerificationFailure(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, message);
    }

    public void throwVerificationFailure(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, cause, message);
    }

    public void throwVerificationFailure(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, message);
    }

    public void throwVerificationFailure(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, cause, message);
    }

    public void throwVerificationFailure(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, message);
    }

    public void throwVerificationFailure(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, cause, message);
    }

    public void throwVerificationFailure(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, message);
    }

    public void throwVerificationFailure(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, cause, message);
    }

    public void throwVerificationFailure(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, message);
    }

    public void throwVerificationFailure(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, cause, message);
    }

    public void throwVerificationFailure(CallContext cc, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, message);
    }

    public void throwVerificationFailure(CallContext cc, Throwable cause, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, cause, message);
    }

    public void throwVerificationFailure(CallContext cc, ProblemState problem_state, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, message);
    }

    public void throwVerificationFailure(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, cause, message);
    }

    public void throwVerificationFailure(CallContext cc, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, message);
    }

    public void throwVerificationFailure(CallContext cc, Throwable cause, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, cause, message);
    }

    public void throwVerificationFailure(CallContext cc, ProblemState problem_state, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, message);
    }

    public void throwVerificationFailure(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, cause, message);
    }

    public void throwVerificationFailure(CallContext cc, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, message);
    }

    public void throwVerificationFailure(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, cause, message);
    }

    public void throwVerificationFailure(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, message);
    }

    public void throwVerificationFailure(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, cause, message);
    }

    public void throwVerificationFailure(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, message);
    }

    public void throwVerificationFailure(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, cause, message);
    }

    public void throwVerificationFailure(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, message);
    }

    public void throwVerificationFailure(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, cause, message);
    }

    public void throwVerificationFailure(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, message);
    }

    public void throwVerificationFailure(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, cause, message);
    }

    public void throwVerificationFailure(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, message);
    }

    public void throwVerificationFailure(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, cause, message);
    }

    public void throwVerificationFailure(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, message);
    }

    public void throwVerificationFailure(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, cause, message);
    }

    public void throwVerificationFailure(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, message);
    }

    public void throwVerificationFailure(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, cause, message);
    }

    public void throwVerificationFailure(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, message);
    }

    public void throwVerificationFailure(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, cause, message);
    }

    public void throwVerificationFailure(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, message);
    }

    public void throwVerificationFailure(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionVerificationFailure.createAndThrow(cc, cause, message);
    }

    //------------------------------------------------------------------------------------------------

    public ExceptionContractViolation createContractViolation(CallContext cc, String text, Object... arguments) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, arguments), ProblemState.ERROR);
        return ExceptionContractViolation.createExceptionContractViolation(cc, message);
    }

    public ExceptionContractViolation createContractViolation(CallContext cc, Throwable cause, String text, Object... arguments) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, arguments), ProblemState.ERROR);
        return ExceptionContractViolation.createExceptionContractViolation(cc, cause, message);
    }

    public void throwContractViolation(CallContext cc, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, message);
    }

    public void throwContractViolation(CallContext cc, Throwable cause, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, cause, message);
    }

    public void throwContractViolation(CallContext cc, ProblemState problem_state, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, message);
    }

    public void throwContractViolation(CallContext cc, ProblemState problem_state, Throwable cause, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, cause, message);
    }

    public void throwContractViolation(CallContext cc, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, message);
    }

    public void throwContractViolation(CallContext cc, Throwable cause, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, cause, message);
    }

    public void throwContractViolation(CallContext cc, ProblemState problem_state, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, message);
    }

    public void throwContractViolation(CallContext cc, ProblemState problem_state, Throwable cause, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, cause, message);
    }

    public void throwContractViolation(CallContext cc, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, message);
    }

    public void throwContractViolation(CallContext cc, Throwable cause, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, cause, message);
    }

    public void throwContractViolation(CallContext cc, ProblemState problem_state, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, message);
    }

    public void throwContractViolation(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, cause, message);
    }

    public void throwContractViolation(CallContext cc, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, message);
    }

    public void throwContractViolation(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, cause, message);
    }

    public void throwContractViolation(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, message);
    }

    public void throwContractViolation(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, cause, message);
    }

    public void throwContractViolation(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, message);
    }

    public void throwContractViolation(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, cause, message);
    }

    public void throwContractViolation(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, message);
    }

    public void throwContractViolation(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, cause, message);
    }

    public void throwContractViolation(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, message);
    }

    public void throwContractViolation(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, cause, message);
    }

    public void throwContractViolation(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, message);
    }

    public void throwContractViolation(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, cause, message);
    }

    public void throwContractViolation(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, message);
    }

    public void throwContractViolation(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, cause, message);
    }

    public void throwContractViolation(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, message);
    }

    public void throwContractViolation(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, cause, message);
    }

    public void throwContractViolation(CallContext cc, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, message);
    }

    public void throwContractViolation(CallContext cc, Throwable cause, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, cause, message);
    }

    public void throwContractViolation(CallContext cc, ProblemState problem_state, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, message);
    }

    public void throwContractViolation(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, cause, message);
    }

    public void throwContractViolation(CallContext cc, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, message);
    }

    public void throwContractViolation(CallContext cc, Throwable cause, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, cause, message);
    }

    public void throwContractViolation(CallContext cc, ProblemState problem_state, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, message);
    }

    public void throwContractViolation(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, cause, message);
    }

    public void throwContractViolation(CallContext cc, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, message);
    }

    public void throwContractViolation(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, cause, message);
    }

    public void throwContractViolation(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, message);
    }

    public void throwContractViolation(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, cause, message);
    }

    public void throwContractViolation(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, message);
    }

    public void throwContractViolation(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, cause, message);
    }

    public void throwContractViolation(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, message);
    }

    public void throwContractViolation(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, cause, message);
    }

    public void throwContractViolation(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, message);
    }

    public void throwContractViolation(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, cause, message);
    }

    public void throwContractViolation(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, message);
    }

    public void throwContractViolation(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, cause, message);
    }

    public void throwContractViolation(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, message);
    }

    public void throwContractViolation(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, cause, message);
    }

    public void throwContractViolation(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, message);
    }

    public void throwContractViolation(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, cause, message);
    }

    public void throwContractViolation(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, message);
    }

    public void throwContractViolation(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, cause, message);
    }

    public void throwContractViolation(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, message);
    }

    public void throwContractViolation(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionContractViolation.createAndThrow(cc, cause, message);
    }

    //------------------------------------------------------------------------------------------------

    public ExceptionPreConditionViolation createPreConditionViolation(CallContext cc, String text, Object... arguments) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, arguments), ProblemState.ERROR);
        return ExceptionPreConditionViolation.createExceptionPreConditionViolation(cc, message);
    }

    public ExceptionPreConditionViolation createPreConditionViolation(CallContext cc, Throwable cause, String text, Object... arguments) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, arguments), ProblemState.ERROR);
        return ExceptionPreConditionViolation.createExceptionPreConditionViolation(cc, cause, message);
    }

    public void throwPreConditionViolation(CallContext cc, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, message);
    }

    public void throwPreConditionViolation(CallContext cc, Throwable cause, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPreConditionViolation(CallContext cc, ProblemState problem_state, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, message);
    }

    public void throwPreConditionViolation(CallContext cc, ProblemState problem_state, Throwable cause, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPreConditionViolation(CallContext cc, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, message);
    }

    public void throwPreConditionViolation(CallContext cc, Throwable cause, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPreConditionViolation(CallContext cc, ProblemState problem_state, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, message);
    }

    public void throwPreConditionViolation(CallContext cc, ProblemState problem_state, Throwable cause, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPreConditionViolation(CallContext cc, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, message);
    }

    public void throwPreConditionViolation(CallContext cc, Throwable cause, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPreConditionViolation(CallContext cc, ProblemState problem_state, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, message);
    }

    public void throwPreConditionViolation(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPreConditionViolation(CallContext cc, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, message);
    }

    public void throwPreConditionViolation(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPreConditionViolation(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, message);
    }

    public void throwPreConditionViolation(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPreConditionViolation(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, message);
    }

    public void throwPreConditionViolation(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPreConditionViolation(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, message);
    }

    public void throwPreConditionViolation(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPreConditionViolation(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, message);
    }

    public void throwPreConditionViolation(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPreConditionViolation(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, message);
    }

    public void throwPreConditionViolation(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPreConditionViolation(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, message);
    }

    public void throwPreConditionViolation(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPreConditionViolation(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, message);
    }

    public void throwPreConditionViolation(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPreConditionViolation(CallContext cc, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, message);
    }

    public void throwPreConditionViolation(CallContext cc, Throwable cause, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPreConditionViolation(CallContext cc, ProblemState problem_state, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, message);
    }

    public void throwPreConditionViolation(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPreConditionViolation(CallContext cc, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, message);
    }

    public void throwPreConditionViolation(CallContext cc, Throwable cause, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPreConditionViolation(CallContext cc, ProblemState problem_state, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, message);
    }

    public void throwPreConditionViolation(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPreConditionViolation(CallContext cc, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, message);
    }

    public void throwPreConditionViolation(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPreConditionViolation(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, message);
    }

    public void throwPreConditionViolation(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPreConditionViolation(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, message);
    }

    public void throwPreConditionViolation(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPreConditionViolation(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, message);
    }

    public void throwPreConditionViolation(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPreConditionViolation(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, message);
    }

    public void throwPreConditionViolation(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPreConditionViolation(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, message);
    }

    public void throwPreConditionViolation(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPreConditionViolation(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, message);
    }

    public void throwPreConditionViolation(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPreConditionViolation(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, message);
    }

    public void throwPreConditionViolation(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPreConditionViolation(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, message);
    }

    public void throwPreConditionViolation(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPreConditionViolation(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, message);
    }

    public void throwPreConditionViolation(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPreConditionViolation.createAndThrow(cc, cause, message);
    }

    //------------------------------------------------------------------------------------------------

    public ExceptionProtocolViolation createProtocolViolation(CallContext cc, String text, Object... arguments) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, arguments), ProblemState.ERROR);
        return ExceptionProtocolViolation.createExceptionProtocolViolation(cc, message);
    }

    public ExceptionProtocolViolation createProtocolViolation(CallContext cc, Throwable cause, String text, Object... arguments) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, arguments), ProblemState.ERROR);
        return ExceptionProtocolViolation.createExceptionProtocolViolation(cc, cause, message);
    }

    public void throwProtocolViolation(CallContext cc, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, message);
    }

    public void throwProtocolViolation(CallContext cc, Throwable cause, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, cause, message);
    }

    public void throwProtocolViolation(CallContext cc, ProblemState problem_state, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, message);
    }

    public void throwProtocolViolation(CallContext cc, ProblemState problem_state, Throwable cause, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, cause, message);
    }

    public void throwProtocolViolation(CallContext cc, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, message);
    }

    public void throwProtocolViolation(CallContext cc, Throwable cause, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, cause, message);
    }

    public void throwProtocolViolation(CallContext cc, ProblemState problem_state, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, message);
    }

    public void throwProtocolViolation(CallContext cc, ProblemState problem_state, Throwable cause, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, cause, message);
    }

    public void throwProtocolViolation(CallContext cc, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, message);
    }

    public void throwProtocolViolation(CallContext cc, Throwable cause, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, cause, message);
    }

    public void throwProtocolViolation(CallContext cc, ProblemState problem_state, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, message);
    }

    public void throwProtocolViolation(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, cause, message);
    }

    public void throwProtocolViolation(CallContext cc, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, message);
    }

    public void throwProtocolViolation(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, cause, message);
    }

    public void throwProtocolViolation(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, message);
    }

    public void throwProtocolViolation(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, cause, message);
    }

    public void throwProtocolViolation(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, message);
    }

    public void throwProtocolViolation(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, cause, message);
    }

    public void throwProtocolViolation(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, message);
    }

    public void throwProtocolViolation(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, cause, message);
    }

    public void throwProtocolViolation(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, message);
    }

    public void throwProtocolViolation(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, cause, message);
    }

    public void throwProtocolViolation(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, message);
    }

    public void throwProtocolViolation(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, cause, message);
    }

    public void throwProtocolViolation(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, message);
    }

    public void throwProtocolViolation(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, cause, message);
    }

    public void throwProtocolViolation(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, message);
    }

    public void throwProtocolViolation(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, cause, message);
    }

    public void throwProtocolViolation(CallContext cc, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, message);
    }

    public void throwProtocolViolation(CallContext cc, Throwable cause, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, cause, message);
    }

    public void throwProtocolViolation(CallContext cc, ProblemState problem_state, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, message);
    }

    public void throwProtocolViolation(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, cause, message);
    }

    public void throwProtocolViolation(CallContext cc, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, message);
    }

    public void throwProtocolViolation(CallContext cc, Throwable cause, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, cause, message);
    }

    public void throwProtocolViolation(CallContext cc, ProblemState problem_state, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, message);
    }

    public void throwProtocolViolation(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, cause, message);
    }

    public void throwProtocolViolation(CallContext cc, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, message);
    }

    public void throwProtocolViolation(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, cause, message);
    }

    public void throwProtocolViolation(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, message);
    }

    public void throwProtocolViolation(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, cause, message);
    }

    public void throwProtocolViolation(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, message);
    }

    public void throwProtocolViolation(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, cause, message);
    }

    public void throwProtocolViolation(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, message);
    }

    public void throwProtocolViolation(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, cause, message);
    }

    public void throwProtocolViolation(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, message);
    }

    public void throwProtocolViolation(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, cause, message);
    }

    public void throwProtocolViolation(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, message);
    }

    public void throwProtocolViolation(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, cause, message);
    }

    public void throwProtocolViolation(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, message);
    }

    public void throwProtocolViolation(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, cause, message);
    }

    public void throwProtocolViolation(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, message);
    }

    public void throwProtocolViolation(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, cause, message);
    }

    public void throwProtocolViolation(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, message);
    }

    public void throwProtocolViolation(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, cause, message);
    }

    public void throwProtocolViolation(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, message);
    }

    public void throwProtocolViolation(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionProtocolViolation.createAndThrow(cc, cause, message);
    }

    //------------------------------------------------------------------------------------------------

    public ExceptionPostConditionViolation createPostConditionViolation(CallContext cc, String text, Object... arguments) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, arguments), ProblemState.ERROR);
        return ExceptionPostConditionViolation.createExceptionPostConditionViolation(cc, message);
    }

    public ExceptionPostConditionViolation createPostConditionViolation(CallContext cc, Throwable cause, String text, Object... arguments) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, arguments), ProblemState.ERROR);
        return ExceptionPostConditionViolation.createExceptionPostConditionViolation(cc, cause, message);
    }

    public void throwPostConditionViolation(CallContext cc, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, message);
    }

    public void throwPostConditionViolation(CallContext cc, Throwable cause, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPostConditionViolation(CallContext cc, ProblemState problem_state, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, message);
    }

    public void throwPostConditionViolation(CallContext cc, ProblemState problem_state, Throwable cause, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPostConditionViolation(CallContext cc, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, message);
    }

    public void throwPostConditionViolation(CallContext cc, Throwable cause, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPostConditionViolation(CallContext cc, ProblemState problem_state, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, message);
    }

    public void throwPostConditionViolation(CallContext cc, ProblemState problem_state, Throwable cause, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPostConditionViolation(CallContext cc, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, message);
    }

    public void throwPostConditionViolation(CallContext cc, Throwable cause, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPostConditionViolation(CallContext cc, ProblemState problem_state, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, message);
    }

    public void throwPostConditionViolation(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPostConditionViolation(CallContext cc, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, message);
    }

    public void throwPostConditionViolation(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPostConditionViolation(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, message);
    }

    public void throwPostConditionViolation(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPostConditionViolation(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, message);
    }

    public void throwPostConditionViolation(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPostConditionViolation(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, message);
    }

    public void throwPostConditionViolation(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPostConditionViolation(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, message);
    }

    public void throwPostConditionViolation(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPostConditionViolation(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, message);
    }

    public void throwPostConditionViolation(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPostConditionViolation(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, message);
    }

    public void throwPostConditionViolation(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPostConditionViolation(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, message);
    }

    public void throwPostConditionViolation(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPostConditionViolation(CallContext cc, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, message);
    }

    public void throwPostConditionViolation(CallContext cc, Throwable cause, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPostConditionViolation(CallContext cc, ProblemState problem_state, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, message);
    }

    public void throwPostConditionViolation(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPostConditionViolation(CallContext cc, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, message);
    }

    public void throwPostConditionViolation(CallContext cc, Throwable cause, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPostConditionViolation(CallContext cc, ProblemState problem_state, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, message);
    }

    public void throwPostConditionViolation(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPostConditionViolation(CallContext cc, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, message);
    }

    public void throwPostConditionViolation(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPostConditionViolation(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, message);
    }

    public void throwPostConditionViolation(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPostConditionViolation(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, message);
    }

    public void throwPostConditionViolation(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPostConditionViolation(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, message);
    }

    public void throwPostConditionViolation(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPostConditionViolation(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, message);
    }

    public void throwPostConditionViolation(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPostConditionViolation(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, message);
    }

    public void throwPostConditionViolation(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPostConditionViolation(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, message);
    }

    public void throwPostConditionViolation(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPostConditionViolation(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, message);
    }

    public void throwPostConditionViolation(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPostConditionViolation(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, message);
    }

    public void throwPostConditionViolation(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, cause, message);
    }

    public void throwPostConditionViolation(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, message);
    }

    public void throwPostConditionViolation(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionPostConditionViolation.createAndThrow(cc, cause, message);
    }

    //------------------------------------------------------------------------------------------------

    public ExceptionAssertionProvedFalse createAssertionProvedFalse(CallContext cc, String text, Object... arguments) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, arguments), ProblemState.ERROR);
        return ExceptionAssertionProvedFalse.createExceptionAssertionProvedFalse(cc, message);
    }

    public ExceptionAssertionProvedFalse createAssertionProvedFalse(CallContext cc, Throwable cause, String text, Object... arguments) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, arguments), ProblemState.ERROR);
        return ExceptionAssertionProvedFalse.createExceptionAssertionProvedFalse(cc, cause, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, Throwable cause, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, cause, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, ProblemState problem_state, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, ProblemState problem_state, Throwable cause, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, cause, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, Throwable cause, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, cause, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, ProblemState problem_state, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, ProblemState problem_state, Throwable cause, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, cause, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, Throwable cause, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, cause, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, ProblemState problem_state, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, cause, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, cause, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, cause, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, cause, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, cause, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, cause, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, cause, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, cause, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, cause, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, Throwable cause, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, cause, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, ProblemState problem_state, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, cause, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, Throwable cause, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, cause, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, ProblemState problem_state, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, cause, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, cause, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, cause, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, cause, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, cause, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, cause, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, cause, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, cause, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, cause, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, cause, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, message);
    }

    public void throwAssertionProvedFalse(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionAssertionProvedFalse.createAndThrow(cc, cause, message);
    }

    //------------------------------------------------------------------------------------------------

    public ExceptionInvalidState createInvalidState(CallContext cc, String text, Object... arguments) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, arguments), ProblemState.ERROR);
        return ExceptionInvalidState.createExceptionInvalidState(cc, message);
    }

    public ExceptionInvalidState createInvalidState(CallContext cc, Throwable cause, String text, Object... arguments) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, arguments), ProblemState.ERROR);
        return ExceptionInvalidState.createExceptionInvalidState(cc, cause, message);
    }

    public void throwInvalidState(CallContext cc, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, message);
    }

    public void throwInvalidState(CallContext cc, Throwable cause, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, cause, message);
    }

    public void throwInvalidState(CallContext cc, ProblemState problem_state, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, message);
    }

    public void throwInvalidState(CallContext cc, ProblemState problem_state, Throwable cause, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, cause, message);
    }

    public void throwInvalidState(CallContext cc, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, message);
    }

    public void throwInvalidState(CallContext cc, Throwable cause, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, cause, message);
    }

    public void throwInvalidState(CallContext cc, ProblemState problem_state, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, message);
    }

    public void throwInvalidState(CallContext cc, ProblemState problem_state, Throwable cause, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, cause, message);
    }

    public void throwInvalidState(CallContext cc, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, message);
    }

    public void throwInvalidState(CallContext cc, Throwable cause, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, cause, message);
    }

    public void throwInvalidState(CallContext cc, ProblemState problem_state, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, message);
    }

    public void throwInvalidState(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, cause, message);
    }

    public void throwInvalidState(CallContext cc, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, message);
    }

    public void throwInvalidState(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, cause, message);
    }

    public void throwInvalidState(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, message);
    }

    public void throwInvalidState(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, cause, message);
    }

    public void throwInvalidState(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, message);
    }

    public void throwInvalidState(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, cause, message);
    }

    public void throwInvalidState(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, message);
    }

    public void throwInvalidState(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, cause, message);
    }

    public void throwInvalidState(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, message);
    }

    public void throwInvalidState(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, cause, message);
    }

    public void throwInvalidState(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, message);
    }

    public void throwInvalidState(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, cause, message);
    }

    public void throwInvalidState(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, message);
    }

    public void throwInvalidState(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, cause, message);
    }

    public void throwInvalidState(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, message);
    }

    public void throwInvalidState(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, cause, message);
    }

    public void throwInvalidState(CallContext cc, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, message);
    }

    public void throwInvalidState(CallContext cc, Throwable cause, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, cause, message);
    }

    public void throwInvalidState(CallContext cc, ProblemState problem_state, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, message);
    }

    public void throwInvalidState(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, cause, message);
    }

    public void throwInvalidState(CallContext cc, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, message);
    }

    public void throwInvalidState(CallContext cc, Throwable cause, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, cause, message);
    }

    public void throwInvalidState(CallContext cc, ProblemState problem_state, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, message);
    }

    public void throwInvalidState(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, cause, message);
    }

    public void throwInvalidState(CallContext cc, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, message);
    }

    public void throwInvalidState(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, cause, message);
    }

    public void throwInvalidState(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, message);
    }

    public void throwInvalidState(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, cause, message);
    }

    public void throwInvalidState(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, message);
    }

    public void throwInvalidState(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, cause, message);
    }

    public void throwInvalidState(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, message);
    }

    public void throwInvalidState(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, cause, message);
    }

    public void throwInvalidState(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, message);
    }

    public void throwInvalidState(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, cause, message);
    }

    public void throwInvalidState(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, message);
    }

    public void throwInvalidState(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, cause, message);
    }

    public void throwInvalidState(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, message);
    }

    public void throwInvalidState(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, cause, message);
    }

    public void throwInvalidState(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, message);
    }

    public void throwInvalidState(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, cause, message);
    }

    public void throwInvalidState(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, message);
    }

    public void throwInvalidState(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, cause, message);
    }

    public void throwInvalidState(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, message);
    }

    public void throwInvalidState(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionInvalidState.createAndThrow(cc, cause, message);
    }

    //------------------------------------------------------------------------------------------------

    public ExceptionImpossibleState createImpossibleState(CallContext cc, String text, Object... arguments) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, arguments), ProblemState.ERROR);
        return ExceptionImpossibleState.createExceptionImpossibleState(cc, message);
    }

    public ExceptionImpossibleState createImpossibleState(CallContext cc, Throwable cause, String text, Object... arguments) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, arguments), ProblemState.ERROR);
        return ExceptionImpossibleState.createExceptionImpossibleState(cc, cause, message);
    }

    public void throwImpossibleState(CallContext cc, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, message);
    }

    public void throwImpossibleState(CallContext cc, Throwable cause, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, cause, message);
    }

    public void throwImpossibleState(CallContext cc, ProblemState problem_state, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, message);
    }

    public void throwImpossibleState(CallContext cc, ProblemState problem_state, Throwable cause, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, cause, message);
    }

    public void throwImpossibleState(CallContext cc, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, message);
    }

    public void throwImpossibleState(CallContext cc, Throwable cause, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, cause, message);
    }

    public void throwImpossibleState(CallContext cc, ProblemState problem_state, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, message);
    }

    public void throwImpossibleState(CallContext cc, ProblemState problem_state, Throwable cause, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, cause, message);
    }

    public void throwImpossibleState(CallContext cc, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, message);
    }

    public void throwImpossibleState(CallContext cc, Throwable cause, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, cause, message);
    }

    public void throwImpossibleState(CallContext cc, ProblemState problem_state, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, message);
    }

    public void throwImpossibleState(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, cause, message);
    }

    public void throwImpossibleState(CallContext cc, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, message);
    }

    public void throwImpossibleState(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, cause, message);
    }

    public void throwImpossibleState(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, message);
    }

    public void throwImpossibleState(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, cause, message);
    }

    public void throwImpossibleState(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, message);
    }

    public void throwImpossibleState(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, cause, message);
    }

    public void throwImpossibleState(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, message);
    }

    public void throwImpossibleState(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, cause, message);
    }

    public void throwImpossibleState(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, message);
    }

    public void throwImpossibleState(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, cause, message);
    }

    public void throwImpossibleState(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, message);
    }

    public void throwImpossibleState(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, cause, message);
    }

    public void throwImpossibleState(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, message);
    }

    public void throwImpossibleState(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, cause, message);
    }

    public void throwImpossibleState(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, message);
    }

    public void throwImpossibleState(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, cause, message);
    }

    public void throwImpossibleState(CallContext cc, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, message);
    }

    public void throwImpossibleState(CallContext cc, Throwable cause, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, cause, message);
    }

    public void throwImpossibleState(CallContext cc, ProblemState problem_state, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, message);
    }

    public void throwImpossibleState(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, cause, message);
    }

    public void throwImpossibleState(CallContext cc, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, message);
    }

    public void throwImpossibleState(CallContext cc, Throwable cause, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, cause, message);
    }

    public void throwImpossibleState(CallContext cc, ProblemState problem_state, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, message);
    }

    public void throwImpossibleState(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, cause, message);
    }

    public void throwImpossibleState(CallContext cc, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, message);
    }

    public void throwImpossibleState(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, cause, message);
    }

    public void throwImpossibleState(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, message);
    }

    public void throwImpossibleState(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, cause, message);
    }

    public void throwImpossibleState(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, message);
    }

    public void throwImpossibleState(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, cause, message);
    }

    public void throwImpossibleState(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, message);
    }

    public void throwImpossibleState(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, cause, message);
    }

    public void throwImpossibleState(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, message);
    }

    public void throwImpossibleState(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, cause, message);
    }

    public void throwImpossibleState(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, message);
    }

    public void throwImpossibleState(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, cause, message);
    }

    public void throwImpossibleState(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, message);
    }

    public void throwImpossibleState(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, cause, message);
    }

    public void throwImpossibleState(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, message);
    }

    public void throwImpossibleState(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, cause, message);
    }

    public void throwImpossibleState(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, message);
    }

    public void throwImpossibleState(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, cause, message);
    }

    public void throwImpossibleState(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, message);
    }

    public void throwImpossibleState(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionImpossibleState.createAndThrow(cc, cause, message);
    }

    //------------------------------------------------------------------------------------------------

    public ExceptionExternalIntervention createExternalIntervention(CallContext cc, String text, Object... arguments) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, arguments), ProblemState.ERROR);
        return ExceptionExternalIntervention.createExceptionExternalIntervention(cc, message);
    }

    public ExceptionExternalIntervention createExternalIntervention(CallContext cc, Throwable cause, String text, Object... arguments) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, arguments), ProblemState.ERROR);
        return ExceptionExternalIntervention.createExceptionExternalIntervention(cc, cause, message);
    }

    public void throwExternalIntervention(CallContext cc, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, message);
    }

    public void throwExternalIntervention(CallContext cc, Throwable cause, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, cause, message);
    }

    public void throwExternalIntervention(CallContext cc, ProblemState problem_state, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, message);
    }

    public void throwExternalIntervention(CallContext cc, ProblemState problem_state, Throwable cause, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, cause, message);
    }

    public void throwExternalIntervention(CallContext cc, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, message);
    }

    public void throwExternalIntervention(CallContext cc, Throwable cause, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, cause, message);
    }

    public void throwExternalIntervention(CallContext cc, ProblemState problem_state, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, message);
    }

    public void throwExternalIntervention(CallContext cc, ProblemState problem_state, Throwable cause, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, cause, message);
    }

    public void throwExternalIntervention(CallContext cc, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, message);
    }

    public void throwExternalIntervention(CallContext cc, Throwable cause, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, cause, message);
    }

    public void throwExternalIntervention(CallContext cc, ProblemState problem_state, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, message);
    }

    public void throwExternalIntervention(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, cause, message);
    }

    public void throwExternalIntervention(CallContext cc, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, message);
    }

    public void throwExternalIntervention(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, cause, message);
    }

    public void throwExternalIntervention(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, message);
    }

    public void throwExternalIntervention(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, cause, message);
    }

    public void throwExternalIntervention(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, message);
    }

    public void throwExternalIntervention(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, cause, message);
    }

    public void throwExternalIntervention(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, message);
    }

    public void throwExternalIntervention(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, cause, message);
    }

    public void throwExternalIntervention(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, message);
    }

    public void throwExternalIntervention(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, cause, message);
    }

    public void throwExternalIntervention(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, message);
    }

    public void throwExternalIntervention(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, cause, message);
    }

    public void throwExternalIntervention(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, message);
    }

    public void throwExternalIntervention(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, cause, message);
    }

    public void throwExternalIntervention(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, message);
    }

    public void throwExternalIntervention(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, cause, message);
    }

    public void throwExternalIntervention(CallContext cc, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, message);
    }

    public void throwExternalIntervention(CallContext cc, Throwable cause, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, cause, message);
    }

    public void throwExternalIntervention(CallContext cc, ProblemState problem_state, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, message);
    }

    public void throwExternalIntervention(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, cause, message);
    }

    public void throwExternalIntervention(CallContext cc, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, message);
    }

    public void throwExternalIntervention(CallContext cc, Throwable cause, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, cause, message);
    }

    public void throwExternalIntervention(CallContext cc, ProblemState problem_state, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, message);
    }

    public void throwExternalIntervention(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, cause, message);
    }

    public void throwExternalIntervention(CallContext cc, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, message);
    }

    public void throwExternalIntervention(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, cause, message);
    }

    public void throwExternalIntervention(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, message);
    }

    public void throwExternalIntervention(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, cause, message);
    }

    public void throwExternalIntervention(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, message);
    }

    public void throwExternalIntervention(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, cause, message);
    }

    public void throwExternalIntervention(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, message);
    }

    public void throwExternalIntervention(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, cause, message);
    }

    public void throwExternalIntervention(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, message);
    }

    public void throwExternalIntervention(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, cause, message);
    }

    public void throwExternalIntervention(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, message);
    }

    public void throwExternalIntervention(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, cause, message);
    }

    public void throwExternalIntervention(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, message);
    }

    public void throwExternalIntervention(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, cause, message);
    }

    public void throwExternalIntervention(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, message);
    }

    public void throwExternalIntervention(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, cause, message);
    }

    public void throwExternalIntervention(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, message);
    }

    public void throwExternalIntervention(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, cause, message);
    }

    public void throwExternalIntervention(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, message);
    }

    public void throwExternalIntervention(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        ExceptionExternalIntervention.createAndThrow(cc, cause, message);
    }

    //------------------------------------------------------------------------------------------------

    public TransactionFailure createTransactionFailure(CallContext cc, String text, Object... arguments) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, arguments), ProblemState.ERROR);
        return TransactionFailure.createTransactionFailure(cc, message);
    }

    public TransactionFailure createTransactionFailure(CallContext cc, Throwable cause, String text, Object... arguments) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, arguments), ProblemState.ERROR);
        return TransactionFailure.createTransactionFailure(cc, cause, message);
    }

    public void throwTransactionFailure(CallContext cc, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, message);
    }

    public void throwTransactionFailure(CallContext cc, Throwable cause, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, cause, message);
    }

    public void throwTransactionFailure(CallContext cc, ProblemState problem_state, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, message);
    }

    public void throwTransactionFailure(CallContext cc, ProblemState problem_state, Throwable cause, String text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, cause, message);
    }

    public void throwTransactionFailure(CallContext cc, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, message);
    }

    public void throwTransactionFailure(CallContext cc, Throwable cause, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, cause, message);
    }

    public void throwTransactionFailure(CallContext cc, ProblemState problem_state, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, message);
    }

    public void throwTransactionFailure(CallContext cc, ProblemState problem_state, Throwable cause, String text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, cause, message);
    }

    public void throwTransactionFailure(CallContext cc, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, message);
    }

    public void throwTransactionFailure(CallContext cc, Throwable cause, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, cause, message);
    }

    public void throwTransactionFailure(CallContext cc, ProblemState problem_state, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, message);
    }

    public void throwTransactionFailure(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, cause, message);
    }

    public void throwTransactionFailure(CallContext cc, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, message);
    }

    public void throwTransactionFailure(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, cause, message);
    }

    public void throwTransactionFailure(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, message);
    }

    public void throwTransactionFailure(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, cause, message);
    }

    public void throwTransactionFailure(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, message);
    }

    public void throwTransactionFailure(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, cause, message);
    }

    public void throwTransactionFailure(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, message);
    }

    public void throwTransactionFailure(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, cause, message);
    }

    public void throwTransactionFailure(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, message);
    }

    public void throwTransactionFailure(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, cause, message);
    }

    public void throwTransactionFailure(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, message);
    }

    public void throwTransactionFailure(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, cause, message);
    }

    public void throwTransactionFailure(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, message);
    }

    public void throwTransactionFailure(CallContext cc, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, cause, message);
    }

    public void throwTransactionFailure(CallContext cc, ProblemState problem_state, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, message);
    }

    public void throwTransactionFailure(CallContext cc, ProblemState problem_state, Throwable cause, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, cause, message);
    }

    public void throwTransactionFailure(CallContext cc, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, message);
    }

    public void throwTransactionFailure(CallContext cc, Throwable cause, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, cause, message);
    }

    public void throwTransactionFailure(CallContext cc, ProblemState problem_state, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, message);
    }

    public void throwTransactionFailure(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, cause, message);
    }

    public void throwTransactionFailure(CallContext cc, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, message);
    }

    public void throwTransactionFailure(CallContext cc, Throwable cause, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, cause, message);
    }

    public void throwTransactionFailure(CallContext cc, ProblemState problem_state, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, message);
    }

    public void throwTransactionFailure(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, Object[][] attributes) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, attributes), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, cause, message);
    }

    public void throwTransactionFailure(CallContext cc, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, message);
    }

    public void throwTransactionFailure(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, cause, message);
    }

    public void throwTransactionFailure(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, message);
    }

    public void throwTransactionFailure(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, cause, message);
    }

    public void throwTransactionFailure(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, message);
    }

    public void throwTransactionFailure(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, cause, message);
    }

    public void throwTransactionFailure(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, message);
    }

    public void throwTransactionFailure(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, cause, message);
    }

    public void throwTransactionFailure(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, message);
    }

    public void throwTransactionFailure(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, cause, message);
    }

    public void throwTransactionFailure(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, message);
    }

    public void throwTransactionFailure(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, cause, message);
    }

    public void throwTransactionFailure(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, message);
    }

    public void throwTransactionFailure(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, cause, message);
    }

    public void throwTransactionFailure(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, message);
    }

    public void throwTransactionFailure(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, cause, message);
    }

    public void throwTransactionFailure(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, message);
    }

    public void throwTransactionFailure(CallContext cc, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), ProblemState.ERROR);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, cause, message);
    }

    public void throwTransactionFailure(CallContext cc, ProblemState problem_state, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, message);
    }

    public void throwTransactionFailure(CallContext cc, ProblemState problem_state, Throwable cause, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message message = SystemStateMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), problem_state);
        this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.PRODUCTION);
        TransactionFailure.createAndThrow(cc, cause, message);
    }

    //------------------------------------------------------------------------------------------------

    public Goal createGoal(CallContext cc, String text) {
        Goal goal = this.getGoalContext(cc).createGoal(cc, TraceMessage.create(cc, MessageText.create(cc, text), 1));
        if ((this.notification_level & Notifier.VERBOSE) != 0) {
            Message message = TraceMessage.create(cc, MessageText.create(cc, "%(goal)", "goal", goal), 1);
            this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
        }
        return goal;
    }

    public Goal createExceptionGoal(CallContext cc, String text, Object[][] attributes) {
        Goal goal = this.getGoalContext(cc).createGoal(cc, TraceMessage.create(cc, MessageText.create(cc, text, attributes), 1));
        if ((this.notification_level & Notifier.VERBOSE) != 0) {
            Message message = TraceMessage.create(cc, MessageText.create(cc, "%(goal)", "goal", goal), 1);
            this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
        }
        return goal;
    }

    public Goal createGoal(CallContext cc, String text, String an1, Object av1) {
        Goal goal = this.getGoalContext(cc).createGoal(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1), 1));
        if ((this.notification_level & Notifier.VERBOSE) != 0) {
            Message message = TraceMessage.create(cc, MessageText.create(cc, "%(goal)", "goal", goal), 1);
            this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
        }
        return goal;
    }

    public Goal createGoal(CallContext cc, String text, String an1, Object av1, String an2, Object av2) {
        Goal goal = this.getGoalContext(cc).createGoal(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), 1));
        if ((this.notification_level & Notifier.VERBOSE) != 0) {
            Message message = TraceMessage.create(cc, MessageText.create(cc, "%(goal)", "goal", goal), 1);
            this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
        }
        return goal;
    }

    public Goal createGoal(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Goal goal = this.getGoalContext(cc).createGoal(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), 1));
        if ((this.notification_level & Notifier.VERBOSE) != 0) {
            Message message = TraceMessage.create(cc, MessageText.create(cc, "%(goal)", "goal", goal), 1);
            this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
        }
        return goal;
    }

    public Goal createGoal(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Goal goal = this.getGoalContext(cc).createGoal(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), 1));
        if ((this.notification_level & Notifier.VERBOSE) != 0) {
            Message message = TraceMessage.create(cc, MessageText.create(cc, "%(goal)", "goal", goal), 1);
            this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
        }
        return goal;
    }

    public Goal createGoal(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Goal goal = this.getGoalContext(cc).createGoal(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), 1));
        if ((this.notification_level & Notifier.VERBOSE) != 0) {
            Message message = TraceMessage.create(cc, MessageText.create(cc, "%(goal)", "goal", goal), 1);
            this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
        }
        return goal;
    }

    public Goal createGoal(CallContext cc, Variative_String_ text) {
        Goal goal = this.getGoalContext(cc).createGoal(cc, TraceMessage.create(cc, MessageText.create(cc, text), 1));
        if ((this.notification_level & Notifier.VERBOSE) != 0) {
            Message message = TraceMessage.create(cc, MessageText.create(cc, "%(goal)", "goal", goal), 1);
            this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
        }
        return goal;
    }

    public Goal createGoal(CallContext cc, Variative_String_ text, Object[][] attributes) {
        Goal goal = this.getGoalContext(cc).createGoal(cc, TraceMessage.create(cc, MessageText.create(cc, text, attributes), 1));
        if ((this.notification_level & Notifier.VERBOSE) != 0) {
            Message message = TraceMessage.create(cc, MessageText.create(cc, "%(goal)", "goal", goal), 1);
            this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
        }
        return goal;
    }

    public Goal createGoal(CallContext cc, Variative_String_ text, String an1, Object av1) {
        Goal goal = this.getGoalContext(cc).createGoal(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1), 1));
        if ((this.notification_level & Notifier.VERBOSE) != 0) {
            Message message = TraceMessage.create(cc, MessageText.create(cc, "%(goal)", "goal", goal), 1);
            this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
        }
        return goal;
    }

    public Goal createGoal(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Goal goal = this.getGoalContext(cc).createGoal(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), 1));
        if ((this.notification_level & Notifier.VERBOSE) != 0) {
            Message message = TraceMessage.create(cc, MessageText.create(cc, "%(goal)", "goal", goal), 1);
            this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
        }
        return goal;
    }

    public Goal createGoal(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Goal goal = this.getGoalContext(cc).createGoal(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), 1));
        if ((this.notification_level & Notifier.VERBOSE) != 0) {
            Message message = TraceMessage.create(cc, MessageText.create(cc, "%(goal)", "goal", goal), 1);
            this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
        }
        return goal;
    }

    public Goal createGoal(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Goal goal = this.getGoalContext(cc).createGoal(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), 1));
        if ((this.notification_level & Notifier.VERBOSE) != 0) {
            Message message = TraceMessage.create(cc, MessageText.create(cc, "%(goal)", "goal", goal), 1);
            this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
        }
        return goal;
    }

    public Goal createGoal(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Goal goal = this.getGoalContext(cc).createGoal(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), 1));
        if ((this.notification_level & Notifier.VERBOSE) != 0) {
            Message message = TraceMessage.create(cc, MessageText.create(cc, "%(goal)", "goal", goal), 1);
            this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
        }
        return goal;
    }

    //------------------------------------------------------------------------------------------------

    public Goal createSubGoal(CallContext cc, String text) {
        Goal goal = this.getGoalContext(cc).createSubGoal(cc, TraceMessage.create(cc, MessageText.create(cc, text), 1));
        if ((this.notification_level & Notifier.VERBOSE) != 0) {
            Message message = TraceMessage.create(cc, MessageText.create(cc, "%(goal)", "goal", goal), 1);
            this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
        }
        return goal;
    }

    public Goal createSubGoal(CallContext cc, String text, Object[][] attributes) {
        Goal goal = this.getGoalContext(cc).createSubGoal(cc, TraceMessage.create(cc, MessageText.create(cc, text, attributes), 1));
        if ((this.notification_level & Notifier.VERBOSE) != 0) {
            Message message = TraceMessage.create(cc, MessageText.create(cc, "%(goal)", "goal", goal), 1);
            this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
        }
        return goal;
    }

    public Goal createSubGoal(CallContext cc, String text, String an1, Object av1) {
        Goal goal = this.getGoalContext(cc).createSubGoal(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1), 1));
        if ((this.notification_level & Notifier.VERBOSE) != 0) {
            Message message = TraceMessage.create(cc, MessageText.create(cc, "%(goal)", "goal", goal), 1);
            this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
        }
        return goal;
    }

    public Goal createSubGoal(CallContext cc, String text, String an1, Object av1, String an2, Object av2) {
        Goal goal = this.getGoalContext(cc).createSubGoal(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), 1));
        if ((this.notification_level & Notifier.VERBOSE) != 0) {
            Message message = TraceMessage.create(cc, MessageText.create(cc, "%(goal)", "goal", goal), 1);
            this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
        }
        return goal;
    }

    public Goal createSubGoal(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Goal goal = this.getGoalContext(cc).createSubGoal(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), 1));
        if ((this.notification_level & Notifier.VERBOSE) != 0) {
            Message message = TraceMessage.create(cc, MessageText.create(cc, "%(goal)", "goal", goal), 1);
            this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
        }
        return goal;
    }

    public Goal createSubGoal(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Goal goal = this.getGoalContext(cc).createSubGoal(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), 1));
        if ((this.notification_level & Notifier.VERBOSE) != 0) {
            Message message = TraceMessage.create(cc, MessageText.create(cc, "%(goal)", "goal", goal), 1);
            this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
        }
        return goal;
    }

    public Goal createSubGoal(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Goal goal = this.getGoalContext(cc).createSubGoal(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), 1));
        if ((this.notification_level & Notifier.VERBOSE) != 0) {
            Message message = TraceMessage.create(cc, MessageText.create(cc, "%(goal)", "goal", goal), 1);
            this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
        }
        return goal;
    }

    public Goal createSubGoal(CallContext cc, Variative_String_ text) {
        Goal goal = this.getGoalContext(cc).createSubGoal(cc, TraceMessage.create(cc, MessageText.create(cc, text), 1));
        if ((this.notification_level & Notifier.VERBOSE) != 0) {
            Message message = TraceMessage.create(cc, MessageText.create(cc, "%(goal)", "goal", goal), 1);
            this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
        }
        return goal;
    }

    public Goal createSubGoal(CallContext cc, Variative_String_ text, Object[][] attributes) {
        Goal goal = this.getGoalContext(cc).createSubGoal(cc, TraceMessage.create(cc, MessageText.create(cc, text, attributes), 1));
        if ((this.notification_level & Notifier.VERBOSE) != 0) {
            Message message = TraceMessage.create(cc, MessageText.create(cc, "%(goal)", "goal", goal), 1);
            this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
        }
        return goal;
    }

    public Goal createSubGoal(CallContext cc, Variative_String_ text, String an1, Object av1) {
        Goal goal = this.getGoalContext(cc).createSubGoal(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1), 1));
        if ((this.notification_level & Notifier.VERBOSE) != 0) {
            Message message = TraceMessage.create(cc, MessageText.create(cc, "%(goal)", "goal", goal), 1);
            this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
        }
        return goal;
    }

    public Goal createSubGoal(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Goal goal = this.getGoalContext(cc).createSubGoal(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), 1));
        if ((this.notification_level & Notifier.VERBOSE) != 0) {
            Message message = TraceMessage.create(cc, MessageText.create(cc, "%(goal)", "goal", goal), 1);
            this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
        }
        return goal;
    }

    public Goal createSubGoal(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Goal goal = this.getGoalContext(cc).createSubGoal(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), 1));
        if ((this.notification_level & Notifier.VERBOSE) != 0) {
            Message message = TraceMessage.create(cc, MessageText.create(cc, "%(goal)", "goal", goal), 1);
            this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
        }
        return goal;
    }

    public Goal createSubGoal(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Goal goal = this.getGoalContext(cc).createSubGoal(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), 1));
        if ((this.notification_level & Notifier.VERBOSE) != 0) {
            Message message = TraceMessage.create(cc, MessageText.create(cc, "%(goal)", "goal", goal), 1);
            this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
        }
        return goal;
    }

    public Goal createSubGoal(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Goal goal = this.getGoalContext(cc).createSubGoal(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), 1));
        if ((this.notification_level & Notifier.VERBOSE) != 0) {
            Message message = TraceMessage.create(cc, MessageText.create(cc, "%(goal)", "goal", goal), 1);
            this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
        }
        return goal;
    }

    //------------------------------------------------------------------------------------------------

    public Goal createNextGoal(CallContext cc, String text) {
        Goal goal = this.getGoalContext(cc).createNextGoal(cc, TraceMessage.create(cc, MessageText.create(cc, text), 1));
        if ((this.notification_level & Notifier.VERBOSE) != 0) {
            Message message = TraceMessage.create(cc, MessageText.create(cc, "%(goal)", "goal", goal), 1);
            this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
        }
        return goal;
    }

    public Goal createNextGoal(CallContext cc, String text, Object[][] attributes) {
        Goal goal = this.getGoalContext(cc).createNextGoal(cc, TraceMessage.create(cc, MessageText.create(cc, text, attributes), 1));
        if ((this.notification_level & Notifier.VERBOSE) != 0) {
            Message message = TraceMessage.create(cc, MessageText.create(cc, "%(goal)", "goal", goal), 1);
            this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
        }
        return goal;
    }

    public Goal createNextGoal(CallContext cc, String text, String an1, Object av1) {
        Goal goal = this.getGoalContext(cc).createNextGoal(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1), 1));
        if ((this.notification_level & Notifier.VERBOSE) != 0) {
            Message message = TraceMessage.create(cc, MessageText.create(cc, "%(goal)", "goal", goal), 1);
            this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
        }
        return goal;
    }

    public Goal createNextGoal(CallContext cc, String text, String an1, Object av1, String an2, Object av2) {
        Goal goal = this.getGoalContext(cc).createNextGoal(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), 1));
        if ((this.notification_level & Notifier.VERBOSE) != 0) {
            Message message = TraceMessage.create(cc, MessageText.create(cc, "%(goal)", "goal", goal), 1);
            this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
        }
        return goal;
    }

    public Goal createNextGoal(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Goal goal = this.getGoalContext(cc).createNextGoal(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), 1));
        if ((this.notification_level & Notifier.VERBOSE) != 0) {
            Message message = TraceMessage.create(cc, MessageText.create(cc, "%(goal)", "goal", goal), 1);
            this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
        }
        return goal;
    }

    public Goal createNextGoal(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Goal goal = this.getGoalContext(cc).createNextGoal(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), 1));
        if ((this.notification_level & Notifier.VERBOSE) != 0) {
            Message message = TraceMessage.create(cc, MessageText.create(cc, "%(goal)", "goal", goal), 1);
            this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
        }
        return goal;
    }

    public Goal createNextGoal(CallContext cc, String text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Goal goal = this.getGoalContext(cc).createNextGoal(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), 1));
        if ((this.notification_level & Notifier.VERBOSE) != 0) {
            Message message = TraceMessage.create(cc, MessageText.create(cc, "%(goal)", "goal", goal), 1);
            this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
        }
        return goal;
    }

    public Goal createNextGoal(CallContext cc, Variative_String_ text) {
        Goal goal = this.getGoalContext(cc).createNextGoal(cc, TraceMessage.create(cc, MessageText.create(cc, text), 1));
        if ((this.notification_level & Notifier.VERBOSE) != 0) {
            Message message = TraceMessage.create(cc, MessageText.create(cc, "%(goal)", "goal", goal), 1);
            this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
        }
        return goal;
    }

    public Goal createNextGoal(CallContext cc, Variative_String_ text, Object[][] attributes) {
        Goal goal = this.getGoalContext(cc).createNextGoal(cc, TraceMessage.create(cc, MessageText.create(cc, text, attributes), 1));
        if ((this.notification_level & Notifier.VERBOSE) != 0) {
            Message message = TraceMessage.create(cc, MessageText.create(cc, "%(goal)", "goal", goal), 1);
            this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
        }
        return goal;
    }

    public Goal createNextGoal(CallContext cc, Variative_String_ text, String an1, Object av1) {
        Goal goal = this.getGoalContext(cc).createNextGoal(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1), 1));
        if ((this.notification_level & Notifier.VERBOSE) != 0) {
            Message message = TraceMessage.create(cc, MessageText.create(cc, "%(goal)", "goal", goal), 1);
            this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
        }
        return goal;
    }

    public Goal createNextGoal(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2) {
        Goal goal = this.getGoalContext(cc).createNextGoal(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2), 1));
        if ((this.notification_level & Notifier.VERBOSE) != 0) {
            Message message = TraceMessage.create(cc, MessageText.create(cc, "%(goal)", "goal", goal), 1);
            this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
        }
        return goal;
    }

    public Goal createNextGoal(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Goal goal = this.getGoalContext(cc).createNextGoal(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3), 1));
        if ((this.notification_level & Notifier.VERBOSE) != 0) {
            Message message = TraceMessage.create(cc, MessageText.create(cc, "%(goal)", "goal", goal), 1);
            this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
        }
        return goal;
    }

    public Goal createNextGoal(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Goal goal = this.getGoalContext(cc).createNextGoal(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4), 1));
        if ((this.notification_level & Notifier.VERBOSE) != 0) {
            Message message = TraceMessage.create(cc, MessageText.create(cc, "%(goal)", "goal", goal), 1);
            this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
        }
        return goal;
    }

    public Goal createNextGoal(CallContext cc, Variative_String_ text, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Goal goal = this.getGoalContext(cc).createNextGoal(cc, TraceMessage.create(cc, MessageText.create(cc, text, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5), 1));
        if ((this.notification_level & Notifier.VERBOSE) != 0) {
            Message message = TraceMessage.create(cc, MessageText.create(cc, "%(goal)", "goal", goal), 1);
            this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
        }
        return goal;
    }

    //------------------------------------------------------------------------------------------------

    public void done (CallContext cc) {
        this.getGoalContext(cc).done(cc);
        if ((this.notification_level & Notifier.VERBOSE) != 0) {
            Message message = TraceMessage.create(cc, MessageText.create(cc, "%(goal)", "goal", this.getGoalContext(cc).getCurrentGoal(cc)), 1);
            this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
        }
    }

    public void missed (CallContext cc) {
        this.getGoalContext(cc).missed(cc);
        if ((this.notification_level & Notifier.VERBOSE) != 0) {
            Message message = TraceMessage.create(cc, MessageText.create(cc, "%(goal)", "goal", this.getGoalContext(cc).getCurrentGoal(cc)), 1);
            this.getNotificationContext(cc).send(cc, message, Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.VERBOSE);
        }
    }

    public void doneSubGoals (CallContext cc) {
        this.getGoalContext(cc).doneSubGoals(cc);
    }
}
