package com.sphenon.basics.goal;

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
import com.sphenon.basics.variatives.*;
import com.sphenon.basics.variatives.classes.*;

public class GoalStringPool extends StringPoolClass {
    static protected GoalStringPool singleton = null;

    static public GoalStringPool getSingleton (CallContext cc) {
        if (singleton == null) {
            singleton = new GoalStringPool(cc);
        }
        return singleton;
    }

    static public VariativeString get(CallContext cc, String id) {
        return VariativeStringClass.createVariativeStringClass(cc, id, getSingleton(cc));
    }

    static public String get(CallContext cc, String id, String isolang) {
        return getSingleton(cc).getString(cc, id, isolang);
    }

    protected GoalStringPool (CallContext cc) {
        super(cc);
        /*************************************************/
        /* THE FOLLOWING SECTION IS PARTIALLY GENERATED. */
        /* BE CAREFUL WHEN EDITING MANUALLY !            */
        /*                                               */
        /* See StringPool.java for explanation.          */
        /*************************************************/
        //BEGINNING-OF-STRINGS
        //P-0-com.sphenon.basics.goal
        //F-0-0-Goal.java
        addEntry(cc, "0.0.0", "en", "Invalid transition: trying to mark Goal as 'done' which is in state '%(state)' (Goal information is possibly misleading and not reliable anymore)");
        addEntry(cc, "0.0.0", "de", "Unzulässiger Übergang: es wird versucht ein Ziel als 'done' zu markieren, welches sich im Zustand '%(state)' befindet (Ziel Angaben sind möglicherweise irreführend und nicht mehr verläßlich)");
        addEntry(cc, "0.0.1", "en", "Invalid transition: trying to mark Goal as 'missed' which is in state '%(state)' (Goal information is possibly misleading and not reliable anymore)");
        addEntry(cc, "0.0.1", "de", "Unzulässiger Übergang: es wird versucht ein Ziel als 'missed' zu markieren, welches sich im Zustand '%(state)' befindet (Ziel Angaben sind möglicherweise irreführend und nicht mehr verläßlich)");
        addEntry(cc, "0.0.3", "en", "During creation of sub Goal: current is in state '%(state)', expected 'INPROCESS'");
        addEntry(cc, "0.0.3", "de", "Bei Erzeugung eines Sub-Ziele befindet sich das aktuelle im Zustand '%(state)', und nicht, wie erwartet, 'INPROCESS'");
        addEntry(cc, "0.0.4", "en", "During creation of next Goal: current is in state '%(state)', expected 'DONE' or 'MISSED'");
        addEntry(cc, "0.0.4", "en", "Bei Erzeugung eines nächsten Ziele befindet sich das aktuelle im Zustand '%(state)', und nicht, wie erwartet, 'DONE' oder 'MISSED'");
        //F-0-1-GoalContext.java
        addEntry(cc, "0.1.0", "en", "Cannot create GoalContext specific main goal twice");
        addEntry(cc, "0.1.0", "de", "ZielContext spezifisches Haupt-Ziel kann nicht zweifach erzeugt werden");
        addEntry(cc, "0.1.1", "en", "Cannot create SubGoal: there is no current goal created yet");
        addEntry(cc, "0.1.1", "de", "Sub-Ziel kann nicht erzeugt werden, da noch kein aktuelles Ziel erzeugt wurde");
        addEntry(cc, "0.1.2", "en", "Cannot create NextGoal: there is no current goal created yet");
        addEntry(cc, "0.1.2", "de", "Next-Ziel kann nicht erzeugt werden, da noch kein aktuelles Ziel erzeugt wurde");
        addEntry(cc, "0.1.3", "en", "Cannot mark current goal as 'done', since there is no such goal");
        addEntry(cc, "0.1.3", "de", "Aktuelles Ziel kann nicht als 'done' markiert werden, da ein solches nicht existiert");
        addEntry(cc, "0.1.4", "en", "Cannot mark current goal as 'missed', since there is no such goal");
        addEntry(cc, "0.1.4", "de", "Aktuelles Ziel kann nicht als 'missed' markiert werden, da ein solches nicht existiert");
        addEntry(cc, "0.1.5", "en", "Cannot complete SubGoals: there is no current goal created yet");
        addEntry(cc, "0.1.5", "de", "Sub-Ziele können nicht abgeschlossen werden, da noch gar kein aktuelles Ziel erstellt wurde");
        addEntry(cc, "0.1.6", "en", "Invalid transition: trying to complete SubGoals while current goal is not marked as 'done', but in state '%(state)'");
        addEntry(cc, "0.1.6", "de", "Unzulässiger Übergang: es wird versucht Sub-Ziele zu vervollständigen, während das aktuelle Ziel noch nicht als 'done' markiert ist, sondern als '%(state)'");
        addEntry(cc, "0.1.7", "en", "Cannot complete SubGoals, since current goal is already the local main Gaol");
        addEntry(cc, "0.1.7", "de", "Sub-Ziele können nicht abgeschlossen werden, da das aktuelle Ziel bereits das lokale Haupt-Ziel ist");
        //F-0-2-GoalLocationContext.java
        addEntry(cc, "0.2.0", "en", "Property '%(full_property_name)' contains invalid entry '%(entry)'");
        addEntry(cc, "0.2.0", "de", "Eigenschaft '%(full_property_name)' enthält unzulässigen Eintrag '%(entry)'");
        //END-OF-STRINGS
        /*************************************************/
    }
}
