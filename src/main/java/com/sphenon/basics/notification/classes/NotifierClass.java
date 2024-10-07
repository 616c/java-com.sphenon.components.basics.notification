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
import com.sphenon.basics.context.classes.*;
import com.sphenon.basics.message.*;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.configuration.*;
import com.sphenon.basics.customary.*;
import com.sphenon.basics.notification.*;
import com.sphenon.basics.monitoring.*;

import java.lang.reflect.Constructor;

public class NotifierClass extends Notifier
{
    static protected Configuration config;
    static { config = Configuration.create(RootContext.getInitialisationContext(), "com.sphenon.basics.notification.classes.NotifierClass"); };

    protected Channel transient_channel;
    protected Channel log_channel;
    protected Channel test_log_channel;
    protected long run_level;
    protected Notifier parent;

    protected NotifierClass (CallContext context) {
        this.transient_channel = Channel.create(context);
        this.log_channel = null;
        this.parent = null;

        String property_prefix = "com.sphenon.basics.notification";
        String property_name = "Level";
        String property = Configuration.get(context, property_prefix, property_name, (String) null);
        if (property != null) {
            this.run_level = NotificationLocationContext.parseProperty(context, property, property_name);
        } else {
            this.run_level = PRODUCTION | MONITORING | OBSERVATION | CHECKPOINT | DIAGNOSTICS | SELF_DIAGNOSTICS;
        }
    }

    static public NotifierClass createNotifierClass (CallContext context) {
        return new NotifierClass(context);
    }

    public void setLevel (CallContext context, long level) {
        this.run_level = level;
    }

    public void setTransientChannel (CallContext context, Channel channel) {
        if (channel == null) {
            ExceptionPreConditionViolation.createAndThrow(context, SystemStateMessage.create(context, MessageText.create(context, NotificationStringPool.get(context, "0.0.0" /* channel to set is invalid (null pointer) */)), ProblemState.ERROR));
        }
        this.transient_channel = channel;
    }

    public Channel getTransientChannel (CallContext context) {
        return this.transient_channel;
    }

    public void setLogChannel (CallContext context, Channel channel) {
        this.log_channel = channel;
    }

    public Channel getLogChannel (CallContext context) {
        return this.log_channel;
    }

    public void setTestLogChannel (CallContext context, Channel channel) {
        this.test_log_channel = channel;
    }

    public Channel getTestLogChannel (CallContext context) {
        return this.test_log_channel;
    }

    public void setParent (CallContext context, Notifier parent) {
        this.parent = parent;
    }

    public void send(CallContext context, Message message, int reliability, long lifetime, long msg_level) {
        // reliability, currently kindly ignored
        // DISCARDABLE
        // RELIABLE
        // ACKNOWLEDGED
        // TRANSACTIONAL
        if ((msg_level & (PRODUCTION | run_level)) != 0) {

            if (lifetime == TRANSIENT) {
                this.transient_channel.send(context, message);
            } else if (lifetime == LOG) {
                if (this.log_channel != null) {
                    this.log_channel.send(context, message);
                }
                this.transient_channel.send(context, message);
            } else {
                ExceptionPreConditionViolation.createAndThrow(context, SystemStateMessage.create(context, MessageText.create(context, NotificationStringPool.get(context, "0.0.1" /* invalid lifetime, expected 'TRANSIENT' or 'LOG', got '%(lifetime)' */), "lifetime", t.o(lifetime)), ProblemState.ERROR));
            }

        }
        if (this.test_log_channel != null && (msg_level & CHECKPOINT) != 0) {
            this.test_log_channel.send(context, message);
        }
        if (this.parent != null) {
            this.parent.send(context, message, reliability, lifetime, msg_level);
        }
    }


    static protected java.util.Vector<NotificationContextDescriptor> context_descriptors;

    static public synchronized void loadContextDescriptors(CallContext context) {
        if (context_descriptors == null) {
            context_descriptors = new java.util.Vector<NotificationContextDescriptor>();

            for (String cd: config.get(context, "ContextDescriptors", "").split(":")) {
                if (cd != null && cd.length() != 0) {
                    Class cd_class = null;
                    try {
                        cd_class = com.sphenon.basics.cache.ClassCache.getClassForName(context, cd);
                    } catch (ClassNotFoundException cnfe) {
                        CustomaryContext.create((Context)context).throwPreConditionViolation(context, cnfe, "Cannot find ContextDescriptor '%(contextdescriptor)'", "contextdescriptor", cd);
                        throw (ExceptionPreConditionViolation) null;
                    }

                    Constructor cons = null;
                    try {
                        cons = cd_class.getConstructor(com.sphenon.basics.context.CallContext.class);
                    } catch (NoSuchMethodException nsme) {
                        CustomaryContext.create((Context)context).throwPreConditionViolation(context, nsme, "Cannot instantiate ContextDescriptor '%(contextdescriptor)', no appropriate constructor", "contextdescriptor", cd);
                        throw (ExceptionPreConditionViolation) null;
                    }
                    NotificationContextDescriptor context_descriptor = null;
                    try {
                        context_descriptor =  (NotificationContextDescriptor) cons.newInstance(context);
                    } catch (InstantiationException e) {
                        CustomaryContext.create((Context)context).throwPreConditionViolation(context, e, "Cannot instantiate ContextDescriptor '%(contextdescriptor)', class is abstract", "contextdescriptor", cd);
                        throw (ExceptionPreConditionViolation) null;
                    } catch (IllegalAccessException e) {
                        CustomaryContext.create((Context)context).throwPreConditionViolation(context, e, "Cannot instantiate ContextDescriptor '%(contextdescriptor)', constructor is inaccessible", "contextdescriptor", cd);
                        throw (ExceptionPreConditionViolation) null;
                    } catch (IllegalArgumentException e) {
                        CustomaryContext.create((Context)context).throwPreConditionViolation(context, e, "Cannot instantiate ContextDescriptor '%(contextdescriptor)', signature mismatch or unwrapping or method invocation", "contextdescriptor", cd);
                        throw (ExceptionPreConditionViolation) null;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        if (e.getTargetException() instanceof java.lang.RuntimeException) {
                            throw (java.lang.RuntimeException) e.getTargetException();
                        }
                        if (e.getTargetException() instanceof java.lang.Error) {
                            throw (java.lang.Error) e.getTargetException();
                        }
                        CustomaryContext.create((Context)context).throwPreConditionViolation(context, e.getTargetException(), "Cannot instantiate ContextDescriptor '%(contextdescriptor)', constructor throwed an exception", "contextdescriptor", cd);
                        throw (ExceptionPreConditionViolation) null;
                    }
                    context_descriptors.add(context_descriptor);
                }
            }
        }
    }

    static public String getContextDescription(CallContext context) {
        String context_description = "";
        if (context_descriptors == null) {
            loadContextDescriptors(context);            
        }
        for (NotificationContextDescriptor context_descriptor: context_descriptors) {
            context_description += "{" + context_descriptor.getContextDescription(context) + "} ";
        }
        return context_description;
    }
}

