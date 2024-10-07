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
import com.sphenon.basics.message.*;
import com.sphenon.basics.notification.classes.*;

public enum NotifierLevel {
    PRODUCTION       (0x0001),
    MONITORING       (0x0002),
    OBSERVATION      (0x0004),
    CHECKPOINT       (0x0010),
    DIAGNOSTICS      (0x0020),
    SELF_DIAGNOSTICS (0x0040),
    VERBOSE          (0x0100),
    MORE_VERBOSE     (0x0200),
    MOST_VERBOSE     (0x0400);

    NotifierLevel (long level) {
        this.level = level;
    }

    protected long level;

    public long getLevel(CallContext context) {
        return this.level;
    }
}
