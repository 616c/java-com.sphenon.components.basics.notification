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
import com.sphenon.basics.exception.*;
import com.sphenon.basics.notification.*;
import com.sphenon.basics.customary.*;
import com.sphenon.basics.configuration.*;

public class GoalLocationContext {

    static protected String property_name = ".Goals";

    static public boolean getGoalsEnabled (CallContext context, String class_path) {
        while (class_path != null) {
            String search_for = class_path + property_name;
            String property = Configuration.get(context, class_path, property_name, (String) null);
            if (property != null) {
                return parseProperty(context, property, search_for);
            }
            int idx = class_path.lastIndexOf('.');
            class_path = (idx == -1 ? null : class_path.substring(0, idx));
        }
        String property = Configuration.get(context, null, property_name, (String) null);
        if (property != null) {
            return parseProperty(context, property, property_name);
        }
        return false;
    }

    static public boolean parseProperty (CallContext call_context, String property, String full_property_name) {
        Context context = Context.create(call_context);
        CustomaryContext cc = CustomaryContext.create(context);
        if (property.equals("ENABLED")) {
            return true;
        } else if (property.equals("DISABLED")) {
            return false;
        } else {
            cc.sendCaution(context, GoalStringPool.get(context, "0.2.0" /* Property '%(full_property_name)' contains invalid entry '%(entry)' */), "full_property_name", full_property_name, "entry", property);
            return false;
        }
    }
}
