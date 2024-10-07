package com.sphenon.basics.notification.test;

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
import com.sphenon.basics.notification.classes.*;
import com.sphenon.basics.customary.*;
import com.sphenon.basics.performance.*;

import java.util.Date;

public class Test {

    public static NotifierClass root_notifier;

    public static void f(Context context) {

        System.out.println( "f, getting notification context..." );

        NotificationContext nc = NotificationContext.get(context);

        System.out.println( "f, sending notification messages..." );

        long t0 = (new Date()).getTime();
        for (int i=0; i<1000; i++) {
            nc.send(context, Message.create(context, MessageText.create(context, "")), Notifier.RELIABLE, Notifier.TRANSIENT, Notifier.CHECKPOINT);
        }
        long t1 = (new Date()).getTime();
        for (int i=0; i<1000; i++) {
            nc.send(context, Message.create(context, MessageText.create(context, "Guten Tag!")), Notifier.RELIABLE, Notifier.TRANSIENT, Notifier.CHECKPOINT);
        }
        long t2 = (new Date()).getTime();
        for (int i=0; i<1000; i++) {
            nc.send(context, Message.create(context, MessageText.create(context, "Guten Tag!Guten Tag!Guten Tag!Guten Tag!Guten Tag!Guten Tag!Guten Tag!Guten Tag!Guten Tag!Guten Tag!")), Notifier.RELIABLE, Notifier.TRANSIENT, Notifier.CHECKPOINT);
        }
        long t3 = (new Date()).getTime();
        for (int i=0; i<1000; i++) {
            System.out.println("");
        }
        long t4 = (new Date()).getTime();
        for (int i=0; i<1000; i++) {
            System.out.println("Guten Tag!");
        }
        long t5 = (new Date()).getTime();
        for (int i=0; i<1000; i++) {
            System.out.println("Guten Tag!Guten Tag!Guten Tag!Guten Tag!Guten Tag!Guten Tag!Guten Tag!Guten Tag!Guten Tag!Guten Tag!");
        }
        long t6 = (new Date()).getTime();
        for (int i=0; i<1000; i++) {
            f0(context);
        }
        long t7 = (new Date()).getTime();
        for (int i=0; i<1000; i++) {
            g0(context);
        }
        long t8 = (new Date()).getTime();
        for (int i=0; i<1000; i++) {
            h0(context);
        }
        long t9 = (new Date()).getTime();
        for (int i=0; i<1000; i++) {
            i0(context);
        }
        long t10 = (new Date()).getTime();

        System.out.println("f, empty messages  took: " + (t1 - t0) + " msec");
        System.out.println("f, short messages  took: " + (t2 - t1) + " msec");
        System.out.println("f, long  messages  took: " + (t3 - t2) + " msec");
        System.out.println("f, empty println   took: " + (t4 - t3) + " msec");
        System.out.println("f, short println   took: " + (t5 - t4) + " msec");
        System.out.println("f, long  println   took: " + (t6 - t5) + " msec");
        System.out.println("f, 10 nested calls took: " + (t7 - t6) + " msec");
        System.out.println("   + println       took: " + (t8 - t7) + " msec");
        System.out.println("   + notify        took: " + (t9 - t8) + " msec");
        System.out.println("   + 10 Contexts   took: " + (t10- t9) + " msec");

        nc.send(context, Message.create(context, MessageText.create(context, "You should be able to read this.")), Notifier.RELIABLE, Notifier.TRANSIENT, Notifier.CHECKPOINT);
        root_notifier.setLevel(context, Notifier.PRODUCTION | Notifier.OBSERVATION);

        nc.send(context, Message.create(context, MessageText.create(context, "But you should not be able to read this.")), Notifier.RELIABLE, Notifier.TRANSIENT, Notifier.CHECKPOINT);

        root_notifier.setLevel(context, Notifier.PRODUCTION | Notifier.MONITORING | Notifier.OBSERVATION | Notifier.CHECKPOINT | Notifier.DIAGNOSTICS | Notifier.SELF_DIAGNOSTICS);

        CustomaryContext cusc = CustomaryContext.create(context);

        cusc.sendTrace(context, "Hi, there.");

        cusc.sendDigest(context, "Hi, %(where).", "where", "there");

        try {
            cusc.throwImpossibleState(context, "Toll, wa?");
        } catch (Throwable t) {
            System.out.println("Ups, exception caught");
            System.out.println("Exception: " + t);
        }
    }

    public static void f0(Context context) { f1(context); }
    public static void f1(Context context) { f2(context); }
    public static void f2(Context context) { f3(context); }
    public static void f3(Context context) { f4(context); }
    public static void f4(Context context) { f5(context); }
    public static void f5(Context context) { f6(context); }
    public static void f6(Context context) { f7(context); }
    public static void f7(Context context) { f8(context); }
    public static void f8(Context context) { f9(context); }
    public static void f9(Context context) {  }

    public static void g0(Context context) { g1(context); }
    public static void g1(Context context) { g2(context); }
    public static void g2(Context context) { g3(context); }
    public static void g3(Context context) { g4(context); }
    public static void g4(Context context) { g5(context); }
    public static void g5(Context context) { g6(context); }
    public static void g6(Context context) { g7(context); }
    public static void g7(Context context) { g8(context); }
    public static void g8(Context context) { g9(context); }
    public static void g9(Context context) { System.out.println("Hi!."); }

    public static void h0(Context context) { h1(context); }
    public static void h1(Context context) { h2(context); }
    public static void h2(Context context) { h3(context); }
    public static void h3(Context context) { h4(context); }
    public static void h4(Context context) { h5(context); }
    public static void h5(Context context) { h6(context); }
    public static void h6(Context context) { h7(context); }
    public static void h7(Context context) { h8(context); }
    public static void h8(Context context) { h9(context); }
    public static void h9(Context context) { CustomaryContext cusc = CustomaryContext.create(context); cusc.sendTrace(context, "Hi!."); }

    public static void i0(Context context) { i1(context); }
    public static void i1(Context context) { i2(context); }
    public static void i2(Context context) { i3(context); }
    public static void i3(Context context) { i4(context); }
    public static void i4(Context context) { i5(context); }
    public static void i5(Context context) { i6(context); }
    public static void i6(Context context) { i7(context); }
    public static void i7(Context context) { i8(context); }
    public static void i8(Context context) { i9(context); }
    public static void i9(Context context) { CustomaryContext cusc = CustomaryContext.create(context); cusc.sendTrace(context, "Hi!."); }

    public static void doComputation() { double a = 1.0; for (long l=0; l<1000000; l++) { a += 0.5; } }

    public static void testStopWatch (CallContext context) {
        StopWatch sw = StopWatch.optionallyCreate (context, "com.sphenon.basics.performance.test", "StopwatchTest", Notifier.SELF_DIAGNOSTICS);
        sw.start(context);
        doComputation();
        sw.pause(context);
        doComputation();
        sw.cont(context);
        doComputation();
        sw.show(context);
        doComputation();
        sw.stop(context);
        doComputation();
    }

    public static void main(String[] args) {
        try {

            System.out.println( "main..." );

            System.out.println( "main, creating root context..." );

            Context context = com.sphenon.basics.context.classes.RootContext.getRootContext ();
            NotificationContext nc = NotificationContext.create(context);
        
            System.out.println( "main, creating notifier..." );

            root_notifier = NotifierClass.createNotifierClass(context);
            NotificationContext.setDefaultNotifier(context, root_notifier);

            System.out.println( "main, calling f()..." );

            f(context);
        
            System.out.println( "main, getLevel('Test'): " + NotificationLocationContext.getLevel(context, "com.sphenon.basics.notification.test.Test"));

            System.out.println( "main, getLevel('Tast'): " + NotificationLocationContext.getLevel(context, "com.sphenon.basics.notification.test.Tast"));

            System.out.println( "main, getLevel('Tost'): " + NotificationLocationContext.getLevel(context, "com.sphenon.basics.notification.test.Tost"));

            testStopWatch(context);

            System.out.println( "main done." );
        } catch (Throwable t) {
            System.err.println("EXCEPTION CAUGHT:");
            System.err.println(t.getMessage());
            t.printStackTrace();
        }
    }
}
