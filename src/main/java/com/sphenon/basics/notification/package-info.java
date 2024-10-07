/** {@EntitySecurityClass User}

  Clear, understandable logging categorization.

  Instead of using just 3-5 log levels like info/warning, there
  is a categorisation scheme with precise definitions, which make it
  easy and unambigous to judge what to apply in which situation. This
  scheme is decribed in {@link com.sphenon.basics.notification.Notifier}.

  To not to have to write these classifications with each and every
  log message, a handy wrapper helps to cover the most frequently used
  cases {@link com.sphenon.basics.notification.NotificationContext}.

  In addition to that, all arguments in log messages are explicitly
  named so that they can be automatically evaluated, if needed,
  see {@link com.sphenon.basics.message.MessageText}.

  Moreover, messages themselves are classified, too, see {@link Message}.

  Some of the messages are accompanied by a
  {@link com.sphenon.basics.monitoring.ProblemState}, whereby
  the meaning of each level is also defined precisely.

  Surely this scheme requires some learning to get used to apply these
  classifications, the above mentioned wrapper eases this a bit, but
  the scheme is only leveraged if each developer understands it's
  meaning and uses the appropriate message if needed.

 */
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
