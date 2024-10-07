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
import com.sphenon.basics.context.classes.RootContext;
import com.sphenon.basics.message.*;
import com.sphenon.basics.notification.*;
import com.sphenon.basics.configuration.*;
import com.sphenon.basics.debug.*;

public class DumpNode_Notifier implements DumpNode {

    static final public Class _class = DumpNode_Notifier.class;

    static protected Configuration config;
    static { config = Configuration.create(RootContext.getInitialisationContext(), _class); };

    protected DumpNode_Notifier parent;
    protected Object            currently_dumped;
    protected Notifier          notifier;
    protected boolean           first;
    protected String            indent;
    protected String            local_indent;
    protected long              level;
    protected StringBuffer      buffer;
    protected boolean           show_names;
    protected boolean           name_value_same_line;
    protected String            indent_increment;
    protected boolean           technical_details;

    static protected Boolean dump_technical_details;

    static protected boolean getDumpTechnicalDetails(CallContext context) {
        if (dump_technical_details == null) {
            dump_technical_details = config.get(context, "DumpTechnicalDetails", false);
        }
        return dump_technical_details;
    }

    public DumpNode_Notifier (CallContext context, long level) {
        this(context, NotificationContext.get((Context) context).getNotifier(context), level, "", null, new StringBuffer(), true, true, "   ", getDumpTechnicalDetails(context));
    }
    
    public DumpNode_Notifier (CallContext context, Notifier notifier, long level) {
        this(context, notifier, level, "", null, new StringBuffer(), true, true, "   ", getDumpTechnicalDetails(context));
    }
    
    public DumpNode_Notifier (CallContext context, Notifier notifier, long level, String indent) {
        this(context, notifier, level, indent, null, new StringBuffer(), true, true, "   ", getDumpTechnicalDetails(context));
    }

    public DumpNode_Notifier (CallContext context, Notifier notifier, long level, String indent, DumpNode_Notifier parent, StringBuffer buffer) {
        this(context, notifier, level, indent, parent, buffer, true, true, "   ", getDumpTechnicalDetails(context));
    }

    public DumpNode_Notifier (CallContext context, long level, String indent, DumpNode_Notifier parent, boolean show_names, boolean name_value_same_line, String indent_increment, boolean technical_details) {
        this(context, NotificationContext.get((Context) context).getNotifier(context), level, indent, parent, new StringBuffer(), show_names, name_value_same_line, indent_increment, technical_details);
    }

    public DumpNode_Notifier (CallContext context, Notifier notifier, long level, String indent, DumpNode_Notifier parent, StringBuffer buffer, boolean show_names, boolean name_value_same_line, String indent_increment, boolean technical_details) {
        this.notifier             = notifier;
        this.first                = true;
        this.indent               = indent;
        this.local_indent         = "";
        this.parent               = parent;
        this.level                = level;
        this.buffer               = buffer;
        this.name_value_same_line = name_value_same_line;
        this.show_names           = show_names;
        this.indent_increment     = indent_increment;
        this.technical_details    = technical_details;
    }

    protected void dumpString(CallContext context, String text, boolean newline) {
        buffer.append(text);
        if (newline) {
            String fulltext = buffer.toString().replaceAll("\n([^\n])", "\n" + this.indent + this.local_indent + "$1");
            this.notifier.send(context, DigestMessage.create(context, MessageText.create(context, fulltext)), Notifier.DISCARDABLE, Notifier.TRANSIENT, this.level);
            buffer.setLength(0);
        }
    }

    public void dump(CallContext context, String value) {
        if (first == false || this.name_value_same_line == false) { this.dumpString(context, this.indent, false); } else { this.first = false; }
        this.dumpString(context, value, true);
    }


    public void dump(CallContext context, String name, Object value) {
        if (this.first == false || this.name_value_same_line == false) { this.dumpString(context, this.indent, false); } else { this.first = false; }
        if (name != null) {
            if (this.show_names) {
                if (this.name_value_same_line) {
                    this.dumpString(context, name + " = ", false);
                    this.local_indent = name.replaceAll("."," ") + indent_increment;
                } else {
                    this.dumpString(context, name + ":", true);
                    this.local_indent = indent_increment;
                }
            } else {
                this.local_indent = indent_increment;
            }
        } else {
            this.local_indent = indent_increment;
        }
        if (    value instanceof Dumpable
             && (value instanceof Throwable) == false
           ) {
            if (this.isCurrentlyDumped(context, value)) {
                this.dumpString(context, "-- recursion: dump discontinued --", true);
            } else {
                this.currently_dumped = value;
                DumpNode subdn = new DumpNode_Notifier(context, this.notifier, this.level, this.indent + this.local_indent, this, this.buffer, this.show_names, this.name_value_same_line, this.indent_increment, this.technical_details);
                ((Dumpable)value).dump(context, subdn);
                subdn.close(context);
                this.currently_dumped = null;
            }
        } else if (Dumper.isCommonType(context, value)) {
            DumpNode subdn = new DumpNode_Notifier(context, this.notifier, this.level, this.indent + this.local_indent, this, this.buffer, this.show_names, this.name_value_same_line, this.indent_increment, this.technical_details);
            Dumper.dumpCommonType(context, value, subdn);
            subdn.close(context);
        } else {
            this.dumpString(context, value == null ? "--null--" : value.toString(), true);
        }
        this.local_indent = "";
    }

    public DumpNode openDumpTechnicalDetails(CallContext context, String name) {
        return openDump(context, name, true);
    }

    public DumpNode openDump(CallContext context, String name) {
        return openDump(context, name, false);
    }

    public DumpNode openDump(CallContext context, String name, boolean is_technical_detail) {
        if (is_technical_detail && this.technical_details == false) {
            return null;
        }
        String new_indent = this.indent;
        if (this.show_names) {
            if (this.first == false || this.name_value_same_line == false) { this.dumpString(context, this.indent, false); } else { this.first = false; }
            if (this.name_value_same_line) {
                this.dumpString(context, name + " = ", false);
                new_indent += name.replaceAll("."," ") + indent_increment;
            } else {
                this.dumpString(context, name + ":", true);
                new_indent += indent_increment;
            }
        } else {
            new_indent += indent_increment;
        }
        return new DumpNode_Notifier(context, this.notifier, this.level, new_indent, this, this.buffer, this.show_names, this.name_value_same_line, this.indent_increment, this.technical_details);
    }

    public void close(CallContext context) {
        if (this.first && this.name_value_same_line) {
            this.dumpString(context, "", true);
            this.first = false;
        }
    }

    public boolean isCurrentlyDumped(CallContext context, Object value) {
        return    (this.currently_dumped != null && this.currently_dumped == value)
               || (this.parent != null && this.parent.isCurrentlyDumped(context, value));
    }
}
