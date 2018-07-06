package com.sphenon.basics.goal.test;

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
import com.sphenon.basics.exception.*;
import com.sphenon.basics.notification.*;
import com.sphenon.basics.customary.*;
import com.sphenon.basics.goal.*;

public class Test {

    public static void dump(CallContext context, Goal goal, String prefix) {
        System.out.println(prefix + goal);
        if (goal.getPrevious(context) != null) {
            dump(context, goal.getPrevious(context), "previous> ");
        } else if (goal.getParent(context) != null) {
            dump(context, goal.getParent(context), "parent  > ");
        }
    }

    public static void f(CallContext call_context) {
        System.out.println( "f, creating contexts..." );

        Context context = Context.create(call_context);
        GoalContext gc = GoalContext.create(context);
        
        System.out.println( "f, creating 1st goal..." );

        gc.createGoal(context, TraceMessage.create(context, MessageText.create(context, "Performing a bank robbery")));

        dump(context, gc.getCurrentGoal(context), "current > ");

        System.out.println( "f, creating sub goal..." );

        gc.createSubGoal(context, TraceMessage.create(context, MessageText.create(context, "Finding Fort Knox")));

        dump(context, gc.getCurrentGoal(context), "current > ");

        gc.done(context);

        System.out.println( "f, creating next goal..." );

        gc.createNextGoal(context, TraceMessage.create(context, MessageText.create(context, "Buying guns")));

        dump(context, gc.getCurrentGoal(context), "current > ");

        gc.done(context);

        gc.createNextGoal(context, TraceMessage.create(context, MessageText.create(context, "Getting the money")));

        gc.missed(context); // police arrives

        dump(context, gc.getCurrentGoal(context), "current > ");

        System.out.println( "f, done." );
    }

    public static void g(CallContext call_context) {
        System.out.println( "g, creating contexts..." );

        Context context = Context.create(call_context);
        CustomaryContext cc = CustomaryContext.create(context);
        
        System.out.println( "g, creating 1st goal..." );

        cc.createGoal(context, "Performing a bank robbery");

        dump(context, cc.getGoalContext(context).getCurrentGoal(context), "current > ");

        System.out.println( "g, creating sub goal..." );

        cc.createSubGoal(context, "Finding Fort Knox");

        dump(context, cc.getGoalContext(context).getCurrentGoal(context), "current > ");

        cc.done(context);

        System.out.println( "g, creating next goal..." );

        cc.createNextGoal(context, "Buying guns");

        dump(context, cc.getGoalContext(context).getCurrentGoal(context), "current > ");

        cc.done(context);

        cc.createNextGoal(context, "Getting the money");

        cc.missed(context); // police arrives

        dump(context, cc.getGoalContext(context).getCurrentGoal(context), "current > ");

        System.out.println( "g, done." );
    }

    public static void main(String[] args) {

        System.out.println( "main..." );

        System.out.println( "main, creating root context..." );

        Context context = com.sphenon.basics.context.classes.RootContext.getRootContext ();
        
        System.out.println( "main, creating goal..." );

        GoalContext gc = GoalContext.create(context);
        Goal my_goal = gc.createGoal(context, TraceMessage.create(context, MessageText.create(context, "Earning billions of dollars")));

        System.out.println( "main, dumping goal: " + my_goal );

        System.out.println( "main, calling f()..." );

        f(context);

        System.out.println( "main, calling g()..." );

        g(context);

        System.out.println( "main, marking goal as done..." );

        my_goal.done(context);

        System.out.println( "main, dumping goal: " + my_goal );
        
        System.out.println( "main done." );
    }
}
