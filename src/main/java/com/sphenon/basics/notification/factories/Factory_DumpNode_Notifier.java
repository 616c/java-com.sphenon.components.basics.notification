package com.sphenon.basics.notification.factories;

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
import com.sphenon.basics.debug.*;

import com.sphenon.basics.notification.*;

import java.io.PrintStream;

public class Factory_DumpNode_Notifier extends Factory_DumpNode {

    public Factory_DumpNode_Notifier (CallContext context) {
        super(context);
    }

    public DumpNode create(CallContext context) {
        return new DumpNode_Notifier(context, Notifier.CHECKPOINT);
    }

    public DumpNode create(CallContext context, String indent, boolean show_names, boolean name_value_same_line, String indent_increment, boolean technical_details) {
        return new DumpNode_Notifier(context, Notifier.CHECKPOINT, indent, null, show_names, name_value_same_line, indent_increment, technical_details);
    }
}
