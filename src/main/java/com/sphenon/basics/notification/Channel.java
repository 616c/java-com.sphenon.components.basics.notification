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
import com.sphenon.basics.configuration.*;

import com.sphenon.basics.notification.classes.*;

abstract public class Channel
{
    static final public Class _class = Channel.class;

    static protected Configuration config;
    static { config = Configuration.create(RootContext.getInitialisationContext(), _class); };

    static public Channel create (CallContext context) {
        String stdout_file = config.get(context, "DefaultChannelFile", (String) null);
        if (stdout_file != null) {
            System.err.println("notifications will be written by default to: " + stdout_file);
            boolean flush_immediately = config.get(context, "DefaultChannelFlushImmediately", false);
            return ChannelFile.createChannelFile(context, stdout_file, flush_immediately);
        } else {
            return ChannelStandardOutput.createChannelStandardOutput(context);
        }
    }

    abstract public void send(CallContext cc, Message message);

    abstract public void setAttachmentHandler (CallContext cc, AttachmentHandler attachment_handler);
}
