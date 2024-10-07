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

import com.sphenon.basics.context.Context;
import com.sphenon.basics.context.CallContext;
import com.sphenon.basics.context.classes.*;
import com.sphenon.basics.debug.RuntimeStep;
import com.sphenon.basics.debug.RuntimeStepFactoryImpl;
import com.sphenon.basics.configuration.*;
import com.sphenon.basics.performance.*;

import com.sphenon.basics.notification.classes.*;
import com.sphenon.basics.notification.factories.*;

public class NotificationPackageInitialiser {
    static protected boolean initialised = false;

    static {
        initialise(RootContext.getRootContext());
    }

    static public synchronized void initialise (CallContext call_context) {
      Context context = Context.create( call_context );
      
        if (initialised == false) {
            initialised = true;

            // we need this before setMessenger to avoid a cycle during startup
            NotificationContext.getDefaultNotifier(context);

            Configuration.setMessenger( context, new ConfigurationMessengerNotification() );

            new BootstrapNotifierConnector(context);

            Configuration.initialise(context);

            // we do this here since InstanceCounterHandler is not already defined in context, but here in notification
            Context.instance_counter = InstanceCounterHandler.optionallyCreateInstanceCounter (context, "com.sphenon.basics.context.Context");

            RuntimeStep.runtime_step_factory = new com.sphenon.basics.debug.RuntimeStepFactoryImpl(context);

            com.sphenon.basics.debug.Dumper.setFactory(context, new Factory_DumpNode_Notifier(context));
        }
    }
}
