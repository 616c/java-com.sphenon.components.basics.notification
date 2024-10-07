package com.sphenon.basics.notification.classes;

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
import com.sphenon.basics.notification.*;
import com.sphenon.basics.customary.*;

import java.io.PrintStream;

public class ChannelPrintStream extends Channel
{
    protected AttachmentHandler attachment_handler;
    protected PrintStream out;

    static public String breakpoint;

    protected ChannelPrintStream (CallContext context, PrintStream out) {
        this.attachment_handler = null;
        this.out = out;
    }

    static public ChannelPrintStream createChannelPrintStream (CallContext cc, PrintStream out) {
        return new ChannelPrintStream(cc, out);
    }

    public void send(CallContext context, Message message) {
        String msg = NotifierClass.getContextDescription(context) + message.toString(context, this.attachment_handler);
        synchronized (this) {
            out.println(msg);
        }

        if (breakpoint == null && com.sphenon.basics.configuration.RootConfiguration.breakpoint != null) {
            breakpoint = com.sphenon.basics.configuration.RootConfiguration.breakpoint;
        }

        if (breakpoint != null && msg.matches(breakpoint)) {
            for (StackTraceElement SE : Thread.currentThread().getStackTrace()) {
                out.println(SE.toString());
            }
            long break_point = 42; // set breakpoint here
        }
    }

    public void setAttachmentHandler (CallContext context, AttachmentHandler attachment_handler) {
        this.attachment_handler = attachment_handler;
    }

    public AttachmentHandler getAttachmentHandler (CallContext context) {
        return this.attachment_handler;
    }
}
