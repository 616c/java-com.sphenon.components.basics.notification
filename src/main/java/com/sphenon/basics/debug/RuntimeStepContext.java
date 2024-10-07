package com.sphenon.basics.debug;

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
import com.sphenon.basics.exception.*;
import com.sphenon.basics.customary.*;
import com.sphenon.basics.debug.*;

import java.util.Vector;
import java.util.List;
import java.util.LinkedList;

public class RuntimeStepContext extends SpecificContext implements Dumpable {

    static public RuntimeStepContext getOrCreate(Context context, boolean only_local) {
        RuntimeStepContext runtime_step_context = (RuntimeStepContext) context.getSpecificContext(RuntimeStepContext.class, only_local);
        if (runtime_step_context == null) {
            runtime_step_context = new RuntimeStepContext(context);
            context.setSpecificContext(RuntimeStepContext.class, runtime_step_context);
        }
        return runtime_step_context;
    }

    static public RuntimeStepContext getOrCreate(Context context) {
        return getOrCreate(context, false);
    }

    static public RuntimeStepContext get(Context context) {
        RuntimeStepContext runtime_step_context = (RuntimeStepContext) context.getSpecificContext(RuntimeStepContext.class);
        return runtime_step_context;
    }

    static public RuntimeStepContext create(Context context) {
        RuntimeStepContext runtime_step_context = new RuntimeStepContext(context);
        context.setSpecificContext(RuntimeStepContext.class, runtime_step_context);
        return runtime_step_context;
    }

    protected RuntimeStepContext (Context context) {
        super(context);
        this.runtime_steps = null;
    }

    protected Vector<RuntimeStep> runtime_steps;
    protected RuntimeStep current_runtime_step;

    public void addRuntimeStep(CallContext context, RuntimeStep runtime_step) {
        if (this.runtime_steps == null) {
            this.runtime_steps = new Vector<RuntimeStep>();
        }
        this.runtime_steps.add(runtime_step);
        this.current_runtime_step = runtime_step;
    }

    public Vector<RuntimeStep> getRuntimeSteps(CallContext cc) {
        RuntimeStepContext runtime_step_context;
        return (this.runtime_steps != null ?
                     this.runtime_steps
                  : (runtime_step_context = (RuntimeStepContext) this.getCallContext(RuntimeStepContext.class)) != null ?
                       runtime_step_context.getRuntimeSteps(cc)
                     : null
               );
    }

    public RuntimeStep geCurrenttRuntimeStep(CallContext cc) {
        return this.current_runtime_step;
    }

    public void dump(CallContext context, DumpNode dump_node) {
        if (this.runtime_steps != null) {
            dump_node.dump(context, "Local History", this.runtime_steps);
        }
        RuntimeStepContext runtime_step_parent_context = (RuntimeStepContext) this.getCallContext(RuntimeStepContext.class);
        if (runtime_step_parent_context != null) {
            dump_node.dump(context, "Parent", runtime_step_parent_context);
        }
    }

    public String getStackDump(CallContext context) {
        StringBuffer dump = new StringBuffer();
        getStackDump(context, dump);
        return dump.toString();
    }

    public void getStackDump(CallContext context, StringBuffer dump) {
        RuntimeStepContext runtime_step_parent_context = (RuntimeStepContext) this.getCallContext(RuntimeStepContext.class);
        if (runtime_step_parent_context != null) {
            runtime_step_parent_context.getStackDump(context, dump);
        }
        if (this.runtime_steps != null) {
            dump.append("---------------\n");
            for (RuntimeStep rs : this.runtime_steps) {
                dump.append(" - " + t.s(context, rs) + "\n");
            }
        }
    }

    protected Long stack_depth;

    public long getStackDepth(CallContext context) {
        if (stack_depth == null) {
            RuntimeStepContext runtime_step_parent_context = (RuntimeStepContext) this.getCallContext(RuntimeStepContext.class);
            if (runtime_step_parent_context != null) {
                stack_depth = runtime_step_parent_context.getStackDepth(context) + 1;
            } else {
                stack_depth = 1L;
            }
        }
        return stack_depth;
    }

    public RuntimeStep getParent(CallContext context) {
        RuntimeStepContext runtime_step_parent_context = (RuntimeStepContext) this.getCallContext(RuntimeStepContext.class);
        if (runtime_step_parent_context != null) {
            return runtime_step_parent_context.geCurrenttRuntimeStep(context);
        } else {
            return null;
        }
    }

    static public void printStackDump(CallContext context) {
        RuntimeStepContext rsc = RuntimeStepContext.get((Context) context);
        if (rsc != null) {
            System.out.println("Stackdump:");
            System.out.println(rsc.getStackDump(context));
        } else {
            System.out.println("Stackdump: empty or disabled");
        }
    }

    public Vector<String> getStack(CallContext context) {
        Vector<String> stack = new Vector<String>();
        getStack(context, stack);
        return stack;
    }

    public void getStack(CallContext context, Vector<String> stack) {
        RuntimeStepContext runtime_step_parent_context = (RuntimeStepContext) this.getCallContext(RuntimeStepContext.class);
        if (runtime_step_parent_context != null) {
            runtime_step_parent_context.getStack(context, stack);
        }
        if (this.runtime_steps != null) {
            stack.add("---------------");
            for (RuntimeStep rs : this.runtime_steps) {
                stack.add(" - " + t.s(context, rs) + "");
            }
        }
    }

    public List<List<RuntimeStep>> getRuntimeStepStack(CallContext context) {
        List<List<RuntimeStep>> stack = new Vector<List<RuntimeStep>>();
        getRuntimeStepStack(context, stack);
        return stack;
    }

    public void getRuntimeStepStack(CallContext context, List<List<RuntimeStep>> stack) {
        RuntimeStepContext runtime_step_parent_context = (RuntimeStepContext) this.getCallContext(RuntimeStepContext.class);
        if (runtime_step_parent_context != null) {
            runtime_step_parent_context.getRuntimeStepStack(context, stack);
        }
        if (this.runtime_steps != null) {
            List<RuntimeStep> sequence = new LinkedList<RuntimeStep>();
            stack.add(sequence);
            for (RuntimeStep rs : this.runtime_steps) {
                sequence.add(rs);
            }
        }
    }

}
