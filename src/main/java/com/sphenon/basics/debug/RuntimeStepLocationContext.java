package com.sphenon.basics.debug;

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
import com.sphenon.basics.customary.*;
import com.sphenon.basics.configuration.*;

import java.util.regex.*;

public class RuntimeStepLocationContext {

    static protected String property_name = "EnabledRuntimeSteps";

    static public long getLevel (Class _class) {
        return getLevel(RootContext.getInitialisationContext(), _class.getName());
    }

    static public long getLevel (CallContext context, String class_path) {
        while (class_path != null) {
            String property = Configuration.get(context, class_path, property_name, (String) null);
            if (property != null) {
                return parseProperty(context, property, class_path + "." + property_name);
            }
            int idx = class_path.lastIndexOf('.');
            class_path = (idx == -1 ? null : class_path.substring(0, idx));
        }
        String property = Configuration.get(context, property_name, null, (String) null);
        if (property != null) {
            return parseProperty(context, property, property_name);
        }
        return RuntimeStepLevel.PRODUCTION | RuntimeStepLevel.MONITORING | RuntimeStepLevel.OBSERVATION;
    }

    static public long parseProperty (CallContext call_context, String property, String full_property_name) {
        Context context = Context.create(call_context);
        CustomaryContext cc = CustomaryContext.create(context);
        long level = RuntimeStepLevel.PRODUCTION;
        try {
            Pattern pattern = Pattern.compile("[A-Za-z0-9_]+");
            Matcher matcher = pattern.matcher(property);
            while (matcher.find()) {
                String match = matcher.group();
                if (match.equals("PRODUCTION"))       { level |= RuntimeStepLevel.PRODUCTION; continue; }
                if (match.equals("MONITORING"))       { level |= RuntimeStepLevel.MONITORING; continue; }
                if (match.equals("OBSERVATION"))      { level |= RuntimeStepLevel.OBSERVATION; continue; }
                if (match.equals("CHECKPOINT"))       { level |= RuntimeStepLevel.CHECKPOINT; continue; }
                if (match.equals("DIAGNOSTICS"))      { level |= RuntimeStepLevel.DIAGNOSTICS; continue; }
                if (match.equals("SELF_DIAGNOSTICS")) { level |= RuntimeStepLevel.SELF_DIAGNOSTICS; continue; }
                if (match.equals("VERBOSE"))          { level |= RuntimeStepLevel.VERBOSE; continue; }
                if (match.equals("MORE_VERBOSE"))     { level |= RuntimeStepLevel.MORE_VERBOSE; continue; }
                if (match.equals("MOST_VERBOSE"))     { level |= RuntimeStepLevel.MOST_VERBOSE; continue; }
                cc.sendCaution(context, "Property '%(full_property_name)' contains invalid entry '%(entry)'", "full_property_name", full_property_name, "entry", match);
            }
        } catch (PatternSyntaxException pse) {
            cc.throwAssertionProvedFalse(context, pse, "Regular expression for notification level parsing is invalid");
            throw (ExceptionAssertionProvedFalse) null; // compiler insists
        }
        return level;
    }
}
