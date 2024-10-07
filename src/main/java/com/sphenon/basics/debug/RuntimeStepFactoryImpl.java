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

public class RuntimeStepFactoryImpl implements RuntimeStepFactory {

    public RuntimeStepFactoryImpl(CallContext context) {
    }

    public RuntimeStep createStep(Context context, long level, Class j_class, String message, Object... arguments) {
        return new RuntimeStepImpl(context, level, j_class, message, arguments);
    }

    public String getStackDump(CallContext context) {
        RuntimeStepContext rsc = RuntimeStepContext.get((Context)context);
        return (rsc == null ? "" : rsc.getStackDump(context));
    }

    public Vector<String> getStack(CallContext context) {
        RuntimeStepContext rsc = RuntimeStepContext.getOrCreate((Context)context);
        return (rsc == null ? null : rsc.getStack(context));
    }

    public List<List<RuntimeStep>> getRuntimeStepStack(CallContext context) {
        RuntimeStepContext rsc = RuntimeStepContext.getOrCreate((Context)context);
        return (rsc == null ? null : rsc.getRuntimeStepStack(context));
    }
}
