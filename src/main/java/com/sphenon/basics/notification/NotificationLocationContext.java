package com.sphenon.basics.notification;

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

public class NotificationLocationContext {

    final static protected String property_name = "EnabledNotifications";

    static public long getLevel (Class _class) {
        return getLevel(RootContext.getInitialisationContext(), _class);
    }

    static public long getLevel (Class _class, String sub_topic) {
        return getLevel(RootContext.getInitialisationContext(), _class, sub_topic);
    }

    static public long getLevel (CallContext context, Class _class) {
        return getLevel(context, _class.getName());
    }

    static public long getLevel (CallContext context, Class _class, String sub_topic) {
        return getLevel(context, _class.getName(), sub_topic);
    }

    static public long getLevel (CallContext context, String class_path) {
        return getLevel(context, class_path, null);
    }

    static public long getLevel (CallContext context, String class_path, String sub_topic) {
        String pn = (sub_topic == null ? property_name : (sub_topic + "." + property_name));
        while (class_path != null) {
            String property = Configuration.get(context, class_path, pn, (String) null);
            if (property != null) {
                return parseProperty(context, property, class_path + "." + pn);
            }
            int idx = class_path.lastIndexOf('.');
            class_path = (idx == -1 ? null : class_path.substring(0, idx));
        }
        String property = Configuration.get(context, pn, null, (String) null);
        if (property != null) {
            return parseProperty(context, property, pn);
        }
        return Notifier.PRODUCTION | Notifier.MONITORING | Notifier.OBSERVATION;
    }

    static public long parseProperty (CallContext context, String property, String full_property_name) {
        return parseProperty(context, property, full_property_name, Notifier.PRODUCTION);
    }

    static public long parseProperty (CallContext context, String property, String full_property_name, long level) {
        try {
            Pattern pattern = Pattern.compile("[A-Za-z0-9_]+");
            Matcher matcher = pattern.matcher(property);
            while (matcher.find()) {
                String match = matcher.group();
                if (match.equals("PRODUCTION"))       { level |= Notifier.PRODUCTION; continue; }
                if (match.equals("MONITORING"))       { level |= Notifier.MONITORING; continue; }
                if (match.equals("OBSERVATION"))      { level |= Notifier.OBSERVATION; continue; }
                if (match.equals("CHECKPOINT"))       { level |= Notifier.CHECKPOINT; continue; }
                if (match.equals("DIAGNOSTICS"))      { level |= Notifier.DIAGNOSTICS; continue; }
                if (match.equals("SELF_DIAGNOSTICS")) { level |= Notifier.SELF_DIAGNOSTICS; continue; }
                if (match.equals("VERBOSE"))          { level |= Notifier.VERBOSE; continue; }
                if (match.equals("MORE_VERBOSE"))     { level |= Notifier.MORE_VERBOSE; continue; }
                if (match.equals("MOST_VERBOSE"))     { level |= Notifier.MOST_VERBOSE; continue; }
                NotificationContext.sendCaution(context, NotificationStringPool.get(context, "1.1.0" /* Property '%(full_property_name)' contains invalid entry '%(entry)' */), "full_property_name", full_property_name, "entry", match);
            }
        } catch (PatternSyntaxException pse) {
            CustomaryContext.create((Context)context).throwAssertionProvedFalse(context, pse, "Regular expression for notification level parsing is invalid");
            throw (ExceptionAssertionProvedFalse) null; // compiler insists
        }
        return level;
    }
}
