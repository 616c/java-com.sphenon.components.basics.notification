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
import com.sphenon.basics.context.classes.*;
import com.sphenon.basics.message.*;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.notification.*;
import com.sphenon.basics.customary.*;
import com.sphenon.basics.configuration.*;

import java.util.regex.*;

public class DebugFeatures {
 
    static protected String property_name = "EnabledDebugFeatures";

    static public boolean[] getFeatures (Class _class, Class feature_enum) {
        return getFeatures(RootContext.getInitialisationContext(), _class.getName(), feature_enum);
    }

    static public boolean[] getFeatures (CallContext context, String class_path, Class feature_enum) {
        while (class_path != null) {
            String property = Configuration.get(context, class_path, property_name, (String) null);
            if (property != null) {
                return parseProperty(context, property, class_path + "." + property_name, feature_enum);
            }
            int idx = class_path.lastIndexOf('.');
            class_path = (idx == -1 ? null : class_path.substring(0, idx));
        }
        String property = Configuration.get(context, property_name, null, (String) null);
        if (property != null) {
            return parseProperty(context, property, property_name, feature_enum);
        }
        return null;
    }

    static public boolean[] parseProperty (CallContext context, String property, String full_property_name, Class<Enum> feature_enum) {
        Enum[] feature_options = feature_enum.getEnumConstants();
        boolean[] features = new boolean[feature_options == null ? 0 : feature_options.length];
        try {
            Pattern pattern = Pattern.compile("[A-Za-z0-9_]+");
            Matcher matcher = pattern.matcher(property);
            ENTRIES: while (matcher.find()) {
                String match = matcher.group();
                if (feature_options != null) {
                    for (int i=0; i < feature_options.length; i++) {
                        if (match.equals(feature_options[i].name())) { features[i] = true; continue ENTRIES; }
                    }
                }
                NotificationContext.sendCaution(context, "Property '%(full_property_name)' contains invalid entry '%(entry)'", "full_property_name", full_property_name, "entry", match);
            }
        } catch (PatternSyntaxException pse) {
            CustomaryContext.create((Context)context).throwAssertionProvedFalse(context, pse, "Regular expression for debug features parsing is invalid");
            throw (ExceptionAssertionProvedFalse) null; // compiler insists
        }
        return features;
    }

    static public boolean isEnabled (CallContext context, Enum feature, boolean[] features) {
        return (features != null && features[feature.ordinal()] == true ? true : false);
    }
}
