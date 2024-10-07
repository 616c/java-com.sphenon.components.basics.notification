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
import com.sphenon.basics.exception.*;
import com.sphenon.basics.customary.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.FileNotFoundException;

public class ChannelFile extends ChannelPrintStream
{
    protected ChannelFile (CallContext context, String file_name, boolean flush_immediately) {
        super(context, createPrintStream(context, file_name));
        this.flush_immediately = flush_immediately;
    }

    static protected PrintStream createPrintStream(CallContext context, String file_name) {
        try {
            FileOutputStream fos = new FileOutputStream(new File(file_name));
            PrintStream ps = new PrintStream(fos);

            return ps;
        } catch (FileNotFoundException fnfe) {
            CustomaryContext.create((Context)context).throwPreConditionViolation(context, fnfe, "Cannot write to standard output redirection file '%(filename)'", "filename", file_name);
            throw (ExceptionPreConditionViolation) null; // compiler insists
        }
    }    

    protected boolean flush_immediately;

    public void send(CallContext context, Message message) {
        super.send(context, message);
        if (flush_immediately) {
            out.flush();
        }
    }

    static public ChannelFile createChannelFile (CallContext cc, String file_name, boolean flush_immediately) {
        return new ChannelFile(cc, file_name, flush_immediately);
    }
}
