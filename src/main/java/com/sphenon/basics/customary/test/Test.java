package com.sphenon.basics.customary.test;

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

import com.sphenon.basics.notification.*;
import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.customary.*;


public class Test
{
    public void testNotification( long notification_level, Context context, CustomaryContext cc ) {

        if ((notification_level & Notifier.DIAGNOSTICS) != 0) {
            cc.sendTrace(context, Notifier.DIAGNOSTICS, "");
        }

        if ((notification_level & Notifier.OBSERVATION) != 0) {
            cc.sendOk(context, "");
        }

        if ((notification_level & Notifier.OBSERVATION) != 0) {
            cc.sendInfo(context, "");
        }

        if ((notification_level & Notifier.OBSERVATION) != 0) {
            cc.sendNotice(context, "");
        }

        if ((notification_level & Notifier.MONITORING) != 0) {
            cc.sendCaution(context, "");
        }

        if ((notification_level & Notifier.MONITORING) != 0) {
            cc.sendWarning(context, "");
        }

        if ((notification_level & Notifier.MONITORING) != 0) {
            cc.sendSevereWarning(context, "");
        }

        if ((notification_level & Notifier.PRODUCTION) != 0) {
            cc.sendError(context, "");
        }

        if ((notification_level & Notifier.PRODUCTION) != 0) {
            cc.sendCriticalError(context, "");
        }

        if ((notification_level & Notifier.PRODUCTION) != 0) {
            cc.sendFatalError(context, "");
        }

        if ((notification_level & Notifier.PRODUCTION) != 0) {
            cc.sendEmergency(context, "");
        }

        if ((notification_level & Notifier.PRODUCTION) != 0) {
            cc.sendPanic(context, "");
        }
    }
    

    public void testException( Context context, CustomaryContext cc ) {

        cc.throwEnvironmentError(context, "");
        // Doku in com.sphenon.basics.exception.ExceptionEnvironmentError.java

        cc.throwInstallationError(context, "");
        // Doku in com.sphenon.basics.exception.ExceptionInstallationError.java

        cc.throwConfigurationError(context, "");
        // Doku in com.sphenon.basics.exception.ExceptionConfigurationError.java

        cc.throwLimitation(context, "");
        // Doku in com.sphenon.basics.exception.ExceptionLimitation.java

        cc.throwVerificationFailure(context, "");
        // Doku in com.sphenon.basics.exception.ExceptionVerificationError.java

        cc.throwContractViolation(context, "");
        //  Doku in com.sphenon.basics.exception.ExceptionContractViolation.java

        cc.throwPreConditionViolation(context, "");
        // Doku in com.sphenon.basics.exception.ExceptionPreConditionViolation.java

        cc.throwProtocolViolation(context, "");
        // Doku in com.sphenon.basics.exception.ExceptionProtocolViolation.java 

        cc.throwPostConditionViolation(context, "");
        // Doku in com.sphenon.basics.exception.ExceptionPostConditionViolation.java

        cc.throwAssertionProvedFalse(context, "");
        // Doku in com.sphenon.basics.exception.ExceptionAssertionProvedFalse.java

        cc.throwInvalidState(context, "");
        //  Doku in com.sphenon.basics.exception.ExceptionInvalidState.java

        cc.throwImpossibleState(context, "");
        //  Doku in com.sphenon.basics.exception.ExceptionImpossibleState.java

        cc.throwExternalIntervention(context, "");
        //  Doku in com.sphenon.basics.exception.ExceptionExternalIntervention.java
    }
  
    public void test() {

        Context context = com.sphenon.basics.context.classes.RootContext.getRootContext ();
        CustomaryContext cusc = CustomaryContext.create( context );

        this.testNotification( Notifier.PRODUCTION, context, cusc );
        this.testException( context, cusc );
    }

    public static Notifier root_notifier;  
}











