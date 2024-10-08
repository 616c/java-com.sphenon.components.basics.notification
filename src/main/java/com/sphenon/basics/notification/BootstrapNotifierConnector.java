package com.sphenon.basics.notification;

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
import com.sphenon.basics.customary.*;

public class BootstrapNotifierConnector extends BootstrapNotifier {
    public BootstrapNotifierConnector (CallContext context) {
        super(context);
        bootstrap_notifier = this;
    }

    public void do_sendTrace (CallContext context, String message) {
        CustomaryContext cc = CustomaryContext.create((Context) context);
        cc.sendTrace(context, message);
    }

    public void do_sendCheckpoint (CallContext context, String message) {
        CustomaryContext cc = CustomaryContext.create((Context) context);
        cc.sendTrace(context, Notifier.CHECKPOINT, message);
    }
}
