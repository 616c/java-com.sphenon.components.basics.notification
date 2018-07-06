package com.sphenon.basics.goal;

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
import com.sphenon.basics.monitoring.*;
import com.sphenon.basics.notification.*;

public class Goal {
    protected Goal parent;
    protected Goal previous;

    protected GoalContext goal_context;

    protected int state;
    protected Message message;

    static public final int INPROCESS = 0;
    static public final int DONE      = 1;
    static public final int MISSED    = 2;

    static protected Goal root_goal = null;

    protected Goal (CallContext context, Message message, Goal parent, Goal previous, GoalContext goal_context) {
        this.state = INPROCESS;
        this.message = message;
        this.parent = parent;
        this.goal_context = goal_context;
        this.previous = previous;
    }

    static public Goal getRootGoal(CallContext context) {
        if (root_goal == null) {
            root_goal = new Goal(context, null, null, null, null);
        }
        return root_goal;
    }

    public Goal getParent (CallContext cc) {
        return this.parent;
    }

    public Goal getPrevious (CallContext cc) {
        return this.previous;
    }

    public GoalContext getGoalContext (CallContext cc) {
        return this.goal_context;
    }

    public int getState (CallContext cc) {
        return this.state;
    }

    public Message getMessage (CallContext cc) {
        return this.message;
    }

    public void done(CallContext call_context) {
        Context context = Context.create(call_context);
        if (this.state != INPROCESS) {
            NotificationContext nc = NotificationContext.create(context);
            nc.send(call_context, SystemStateMessage.create(call_context, MessageText.create(call_context, GoalStringPool.get(context, "0.0.0" /* Invalid transition: trying to mark Goal as 'done' which is in state '%(state)' */), "state", this.state == INPROCESS ? "INPROCESS" : this.state == DONE ? "DONE" : this.state == MISSED ? "MISSED" : "???"), ProblemState.CAUTION), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
        }
        this.state = DONE;
    }

    public void missed(CallContext call_context) {
        Context context = Context.create(call_context);
        if (this.state != INPROCESS) {
            NotificationContext nc = NotificationContext.create(context);
            nc.send(call_context, SystemStateMessage.create(call_context, MessageText.create(call_context, GoalStringPool.get(context, "0.0.1" /* Invalid transition: trying to mark Goal as 'missed' which is in state '%(state)' */), "state", this.state == INPROCESS ? "INPROCESS" : this.state == DONE ? "DONE" : this.state == MISSED ? "MISSED" : "???"), ProblemState.CAUTION), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
        }
        this.state = MISSED;
    }


    public Goal createSubGoal(CallContext call_context, Message message) {
        return this.createSubGoalInGoalContext(call_context, message, this.goal_context);
    }

    public Goal createSubGoalInGoalContext(CallContext call_context, Message message, GoalContext target_goal_context) {
        Context context = Context.create(call_context);
        if (this.state != INPROCESS) {
            NotificationContext nc = NotificationContext.create(context);
            nc.send(call_context, SystemStateMessage.create(call_context, MessageText.create(call_context, GoalStringPool.get(context, "0.0.3" /* During creation of sub Goal: current is in state '%(state)', expected 'INPROCESS' */), "state", this.state == INPROCESS ? "INPROCESS" : this.state == DONE ? "DONE" : this.state == MISSED ? "MISSED" : "???"), ProblemState.CAUTION), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
        }
        Goal subgoal = new Goal (context, message, this, null, target_goal_context);
        target_goal_context.setCurrentGoal(context, subgoal);
        return subgoal;
    }

    public Goal createNextGoal(CallContext call_context, Message message) {
        Context context = Context.create(call_context);
        if (this.state == INPROCESS) {
            NotificationContext nc = NotificationContext.create(context);
            nc.send(call_context, SystemStateMessage.create(call_context, MessageText.create(call_context, GoalStringPool.get(context, "0.0.4" /* During creation of next Goal: current is in state '%(state)', expected 'DONE' or 'MISSED' */), "state", this.state == INPROCESS ? "INPROCESS" : this.state == DONE ? "DONE" : this.state == MISSED ? "MISSED" : "???"), ProblemState.CAUTION), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
        }
        Goal nextgoal = new Goal (context, message, this.parent, this, this.getGoalContext(context));
        this.goal_context.setCurrentGoal(context, nextgoal);
        return nextgoal;
    }

    public String toString () {
        return "Goal: " + (this.message == null ? "---" : this.message.toString()) + (this.state == INPROCESS ? " ..." : this.state == DONE ? " - done." : this.state == MISSED ? " - missed." : " - [invalid goal state?]");
        // RootContext.getFallbackCallContext()
    }
}


