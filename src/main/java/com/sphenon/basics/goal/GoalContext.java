package com.sphenon.basics.goal;

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
import com.sphenon.basics.message.*;
import com.sphenon.basics.monitoring.*;
import com.sphenon.basics.notification.*;

public class GoalContext extends SpecificContext {

    static public GoalContext get(Context context) {
        GoalContext goal_context = (GoalContext) context.getSpecificContext(GoalContext.class);
        if (goal_context != null) {
            return goal_context;
        }
        return null;
    }

    static public GoalContext create(Context context) {
        GoalContext nc = new GoalContext(context, false);
        context.setSpecificContext(GoalContext.class, nc);
        return nc;
    }

    protected GoalContext (Context context, boolean is_default_singelton) {
        super(context);
        this.local_main_goal = null;
        this.current_goal = null;
    }

    protected Goal local_main_goal;
    protected Goal current_goal;

    public Goal createGoal(CallContext cc, Message message) {
        Context context = Context.create(cc);
        if (this.local_main_goal != null || this.current_goal != null) {
            NotificationContext nc = NotificationContext.create(context);
            nc.send(context, SystemStateMessage.create(context, MessageText.create(context, GoalStringPool.get(context, "0.1.0" /* Cannot create GoalContext specific main goal twice */)), ProblemState.CAUTION), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
        }
        GoalContext gc;
        Goal parent = (gc = (GoalContext) this.getCallContext(GoalContext.class)) != null
                      ? gc.getCurrentGoal(cc)
                      : Goal.getRootGoal(context);

        this.local_main_goal = parent.createSubGoalInGoalContext(context, message, this);
        this.local_main_goal = this.current_goal;
        return this.local_main_goal;
    }

    public Goal createSubGoal(CallContext cc, Message message) {
        Context context = Context.create(cc);
        if (! this.haveCurrentGoal(context)) {
            NotificationContext nc = NotificationContext.create(context);
            nc.send(context, SystemStateMessage.create(context, MessageText.create(context, GoalStringPool.get(context, "0.1.1" /* Cannot create SubGoal: there is no current goal created yet */)), ProblemState.CAUTION), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
            return null;
        }
        return this.current_goal = this.getCurrentGoal(context).createSubGoal(context, message);
    }

    public Goal createNextGoal(CallContext cc, Message message) {
        Context context = Context.create(cc);
        if (! this.haveCurrentGoal(context)) {
            NotificationContext nc = NotificationContext.create(context);
            nc.send(context, SystemStateMessage.create(context, MessageText.create(context, GoalStringPool.get(context, "0.1.2" /* Cannot create NextGoal: there is no current goal created yet */)), ProblemState.CAUTION), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
            return null;
        }
        return this.current_goal = this.getCurrentGoal(context).createNextGoal(context, message);
    }

    public void doneSubGoals(CallContext cc) {
        Context context = Context.create(cc);
        if (! this.haveCurrentGoal(context)) {
            NotificationContext nc = NotificationContext.create(context);
            nc.send(context, SystemStateMessage.create(context, MessageText.create(context, GoalStringPool.get(context, "0.1.5" /* Cannot complete SubGoals: there is no current goal created yet */)), ProblemState.CAUTION), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
            return;
        }
        if (this.getCurrentGoal(context).getState(context) != Goal.DONE) {
            NotificationContext nc = NotificationContext.create(context);
            nc.send(context, SystemStateMessage.create(context, MessageText.create(context, GoalStringPool.get(context, "0.1.6" /* Invalid transition: trying to complete SubGoals while current goal is not marked as 'done', but in state '%(state)' */), "state", this.getCurrentGoal(context).getState(context) == Goal.INPROCESS ? "INPROCESS" : this.getCurrentGoal(context).getState(context) == Goal.DONE ? "DONE" : this.getCurrentGoal(context).getState(context) == Goal.MISSED ? "MISSED" : "???"), ProblemState.CAUTION), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
        }
        Goal parent = this.getCurrentGoal(context).getParent(context);
        if (this.getCurrentGoal(context) == local_main_goal) {
            NotificationContext nc = NotificationContext.create(context);
            nc.send(context, SystemStateMessage.create(context, MessageText.create(context, GoalStringPool.get(context, "0.1.7" /* Cannot complete SubGoals, since current goal is already the local main Gaol */)), ProblemState.CAUTION), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
            return;
        }
        this.current_goal = parent;
    }

    public void done(CallContext cc) {
        Context context = Context.create(cc);
        if (! this.haveCurrentGoal(context)) {
            NotificationContext nc = NotificationContext.create(context);
            nc.send(context, SystemStateMessage.create(context, MessageText.create(context, GoalStringPool.get(context, "0.1.3" /* Cannot mark current goal as 'done', since there is no such goal */)), ProblemState.CAUTION), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
        }
        this.getCurrentGoal(context).done(context);
    }

    public void missed(CallContext cc) {
        Context context = Context.create(cc);
        if (! this.haveCurrentGoal(context)) {
            NotificationContext nc = NotificationContext.create(context);
            nc.send(context, SystemStateMessage.create(context, MessageText.create(context, GoalStringPool.get(context, "0.1.4" /* Cannot mark current goal as 'missed', since there is no such goal */)), ProblemState.CAUTION), Notifier.DISCARDABLE, Notifier.TRANSIENT, Notifier.OBSERVATION);
        }
        this.getCurrentGoal(context).missed(context);
    }

    public Goal getCurrentGoal (CallContext cc) {
        return this.current_goal != null ? this.current_goal : Goal.getRootGoal(cc);
    }

    public boolean haveCurrentGoal (CallContext cc) {
        return (this.current_goal != null);
    }

    public void setCurrentGoal (CallContext cc, Goal goal) {
        this.current_goal = goal;
    }
}
