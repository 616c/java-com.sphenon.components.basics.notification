package com.sphenon.basics.debug.test;

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
import com.sphenon.basics.notification.*;
import com.sphenon.basics.notification.classes.*;
import com.sphenon.basics.customary.*;
import com.sphenon.basics.performance.*;

import com.sphenon.basics.debug.*;

public class Test_RuntimeStep {

    static final public Class _class = Test_RuntimeStep.class;

    static protected long runtimestep_level;
    static public    long adjustRuntimeStepLevel(long new_level) { long old_level = runtimestep_level; runtimestep_level = new_level; return old_level; }
    static public    long getRuntimeStepLevel() { return runtimestep_level; }
    static { runtimestep_level = RuntimeStepLocationContext.getLevel(_class); };

    public void f(CallContext context) {
        context = Context.create(context);
        RuntimeStep runtime_step = null;

        if ((runtimestep_level & RuntimeStepLevel.PRODUCTION) != 0) { runtime_step = RuntimeStep.create((Context) context, RuntimeStepLevel.PRODUCTION, _class, "Schritt 2.1"); }

        RuntimeStepContext.printStackDump(context);

        g(context);

        RuntimeStepContext.printStackDump(context);

        if (runtime_step != null) { runtime_step.setCompleted(context, "2.1, ok"); runtime_step = null; }

        if ((runtimestep_level & RuntimeStepLevel.PRODUCTION) != 0) { runtime_step = RuntimeStep.create((Context) context, RuntimeStepLevel.PRODUCTION, _class, "Schritt 2.2"); }

        RuntimeStepContext.printStackDump(context);

        g(context);

        RuntimeStepContext.printStackDump(context);

        if (runtime_step != null) { runtime_step.setCompleted(context, "2.2, ok"); runtime_step = null; }
    }    

    public void g(CallContext context) {
        context = Context.create(context);
        RuntimeStep runtime_step = null;

        if ((runtimestep_level & RuntimeStepLevel.PRODUCTION) != 0) { runtime_step = RuntimeStep.create((Context) context, RuntimeStepLevel.PRODUCTION, _class, "Schritt 3.1"); }

        RuntimeStepContext.printStackDump(context);

        if (runtime_step != null) { runtime_step.setCompleted(context, "3.1, ok"); runtime_step = null; }
    }    

    public void o(CallContext context) {
        context = Context.create(context);
        RuntimeStep runtime_step = null;

        try {
            if ((runtimestep_level & RuntimeStepLevel.PRODUCTION) != 0) { runtime_step = RuntimeStep.create((Context) context, RuntimeStepLevel.PRODUCTION, _class, "Schritt 2a.1"); }

            p(context);

        } catch(ExceptionError t) {
            if (runtime_step != null) { runtime_step.setFailed(context, t, "2a.1, failed"); runtime_step = null; }
            throw t;
        }
        if (runtime_step != null) { runtime_step.setCompleted(context, "2a.1, ok"); runtime_step = null; }
    }    

    public void p(CallContext context) {
        context = Context.create(context);
        RuntimeStep runtime_step = null;

        try {
            if ((runtimestep_level & RuntimeStepLevel.PRODUCTION) != 0) { runtime_step = RuntimeStep.create((Context) context, RuntimeStepLevel.PRODUCTION, _class, "Schritt 3a.1"); }

            RuntimeStepContext.printStackDump(context);

            CustomaryContext.create((Context)context).throwExternalIntervention(context, "Test Exception");

        } catch(ExceptionError t) {
            if (runtime_step != null) { runtime_step.setFailed(context, t, "3a.1, failed"); runtime_step = null; }
            throw t;
        }
        if (runtime_step != null) { runtime_step.setCompleted(context, "3a.1, ok"); runtime_step = null; }
    }    

    public static void main(String[] args) {

        try {
            System.out.println( "main..." );

            System.out.println( "main, creating root context..." );

            Context context = com.sphenon.basics.context.classes.RootContext.getRootContext ();
            NotificationPackageInitialiser.initialise(context);

            RuntimeStep runtime_step = null;

            System.out.println("level is: " + runtimestep_level);

            if ((runtimestep_level & RuntimeStepLevel.PRODUCTION) != 0) { runtime_step = RuntimeStep.create(context, RuntimeStepLevel.PRODUCTION, _class, "Schritt 1.1"); }

            System.out.println("runtime step is: " + runtime_step);

            Test_RuntimeStep trs = new Test_RuntimeStep();
            trs.f(context);

            try {
                trs.o(context);
            } catch (ExceptionExternalIntervention eei) {
                System.err.println("Expected exception caught:");
                System.err.println(eei);
            }

            if (runtime_step != null) { runtime_step.setCompleted(context, "1.1, ok"); runtime_step = null; }

            System.out.println( "main done." );
        } catch (Throwable t) {
            System.err.println("EXCEPTION CAUGHT:");
            System.err.println(t.getMessage());
            t.printStackTrace();
        }
    }
}
