package com.sphenon.basics.performance;

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
import com.sphenon.basics.notification.*;
import com.sphenon.basics.customary.*;
import com.sphenon.basics.configuration.*;

public class InstanceCounterHandler {
    static public InstanceCounter optionallyCreateInstanceCounter (CallContext context, String fullclassname) {
        if (Configuration.get (context, fullclassname + ".INSTANCECOUNTER", "Enabled", false) == false) {
            return null;
        }
        return new InstanceCounter (context, fullclassname);
    }

    static public synchronized void dumpInstances(CallContext call_context, String message) {
        Context context = Context.create(call_context);
        CustomaryContext cc = CustomaryContext.create(context);

        InstanceCounter ic = InstanceCounter.getFirst(context);
        while (ic != null) {
            long ic_notification_level = NotificationLocationContext.getLevel(context, ic.fullclassname + ".INSTANCECOUNTER");
            if ((ic_notification_level & Notifier.DIAGNOSTICS) != 0) {
                cc.sendTrace(context, Notifier.DIAGNOSTICS, "Instance counter '%(fullclassname)': since startup: + %(created_totally), - %(finalized_totally), since last measure: + %(created), - %(finalized), total instances: '%(total)'%(message)", "fullclassname", ic.fullclassname, "created_totally", t.s(ic.created), "finalized_totally", t.s(ic.finalized), "created", t.s(ic.created - ic.created_last), "finalized", t.s(ic.finalized - ic.finalized_last), "total", t.s(ic.created - ic.finalized), "message", (message == null ? "" : (" (" + message + ")")));
            }
            ic.created_last = ic.created;
            ic.finalized_last = ic.finalized;
            ic = ic.getNext(context);
        }
    }
}
