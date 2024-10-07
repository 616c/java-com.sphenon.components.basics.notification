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

/** {@EntitySecurityClass User}

    @doclet {@Category Definition} {@SecurityClass User} {@Maturity Final}

    The Notifier represents the "Developer Frontend for
    Notifications". In addition to Channels, which just send
    a message, Notifiers accept parameters to specify message meta
    properties like when and how to send the message at all.

    Notes on Operation Level Specifiers:
    
    - only valid if reliability is 'DISCARDABLE'
    
    - these codes are neither necessarily mutual exclusive, nor necessarily
    hierarchical inclusive; specifically: normal system operation has to rely
    solely on PRODUCTION(_LOG) messages, automated testing respectively on
    CHECKPOINT messages; => e.g. messages can be both PRODUCTION and
    CHECKPOINT.
    
    - typically, a production system sends PRODUCTION, MONITORING, and
    OBSERVATION messages, additionally, during test, support, and maintenance,
    CHECKPOINT, DIAGNOSTICS, and SELF_DIAGNOSTICS messages are sent, and
    finally, during development or intensive debugging, additional VERBOSE,
    MORE_VERBOSE and MOST_VERBOSE messages go through the ether.
*/
abstract public class Notifier
{
    // Reliablility Specifiers

    /**
       message needs not to be delivered at all 
       (reliablility specifier)
     */   
    static final public int DISCARDABLE       =      0; 

    /**
       send reliable, but do not necessarily wait
       for reception; specifically, do not block
       processing; report transfer errors,
       but not here
       (reliablility specifier)
     */
    static final public int RELIABLE          =      1; 
                                                        
    /**
       wait until message is received
       (reliablility specifier)
     */
    static final public int ACKNOWLEDGED      =      2; 

    /**
       send message within a transaction
       [not designed/implemented yet]
       (reliablility specifier)
     */
    static final public int TRANSACTIONAL     =      3; 
                                                        

    // Lifetime Specifiers

    /**
       type of receiver does not matter
       (lifetime specifier)
     */
    static final public int TRANSIENT         =      0; 

    /**
       message must be stored
       (lifetime specifier)
     */
    static final public int LOG               =      1; 


    // Operation Level Specifiers

    /**
       these messages are required for
       the system to function properly
       (note: this comprises all "red" state
       messages, i.e. error, critical error,
       fatal error, emergency and panic messages,
       since proper system operation in fact
       depends on them)
       (operation level specifier)
     */
    static final public long PRODUCTION       = 0x0001; 

    /**
       important informational state messages,
       not required for system operation,
       but to be noticed; this comprises "yellow"
       state messages (cautions, warnings, severe_warnings);
       (note: under normal circumstances, this is
       the recommended mode for production)
       (operation level specifier)
     */
    static final public long MONITORING       = 0x0002; 
                                                        
    /**
       can be used in production mode to
       carefully observe system operations
       e.g. in "preproduction" mode; comprises
       "green" state messages, i.e. ok, info,
       and notice messages
       (operation level specifier)
     */
    static final public long OBSERVATION      = 0x0004; 
                                                        
    /**
       these messages are sent and can be
       relied on for automated test evaluation
       (operation level specifier)
     */
    static final public long CHECKPOINT       = 0x0010; 
                                                        
    /**
       messages for diagnostic purposes,
       considering the respective subsystem
       as a black box (external view)
       (operation level specifier)
     */
    static final public long DIAGNOSTICS      = 0x0020; 
                                                        
                                                        
    /**
       messages for diagnostics of the
       respective subsystem itself;
       considering it as a white box
       (internal details)
       (operation level specifier)
     */
    static final public long SELF_DIAGNOSTICS = 0x0040; 
                                                        
    /**
       lots of further messages
       (operation level specifier)
     */
    static final public long VERBOSE          = 0x0100; 

    /**
       even more of them
       (operation level specifier)
     */
    static final public long MORE_VERBOSE     = 0x0200; 

    /**
       highest amount of messages;
       useful for harddisk stress testing
       (operation level specifier)
     */
    static final public long MOST_VERBOSE     = 0x0400; 
                                                        

    static public Notifier create (CallContext cc) {
        return NotifierClass.createNotifierClass(cc);
    }

    abstract public void send(CallContext cc, Message message, int reliability, long lifetime, long level);
}
