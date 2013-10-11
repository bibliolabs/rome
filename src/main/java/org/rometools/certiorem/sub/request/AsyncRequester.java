/**
 *
 *  Copyright (C) The ROME Team  2011
 *
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.rometools.certiorem.sub.request;

import org.rometools.certiorem.sub.data.Subscription;

import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * A simple requester implementation that always makes requests as Async.
 * @author robert.cooper
 */
public class AsyncRequester extends AbstractRequester {
    @Override
    public void sendSubscribeRequest(final String hubUrl, final Subscription subscription, final String verifySync,
        final long leaseSeconds, final String secret, final String callbackUrl, final RequestCallback callback) {
        Logger.getLogger(AsyncRequester.class.getName()).log(Level.FINE, "Sending subscribe request to {0} for {1} to {2}", new Object[]{hubUrl, subscription.getSourceUrl(), callbackUrl});
        Runnable r = new Runnable() {
                @Override
                public void run() {
                    try {
                        sendRequest(hubUrl, "subscribe", subscription, verifySync, leaseSeconds, secret, callbackUrl,
                            callback);
                    } catch (Exception ex) {
                        Logger.getLogger(AsyncRequester.class.getName())
                              .log(Level.SEVERE, null, ex);
                        callback.onFailure(ex);
                    }
                }
            };
            new Thread(r).start();
    }

    @Override
    public void sendUnsubscribeRequest(final String hubUrl, final Subscription subscription, final String verifySync,
            final String secret,
        final String callbackUrl, final RequestCallback callback) {
        Logger.getLogger(AsyncRequester.class.getName()).log(Level.FINE, "Sending unsubscribe request to {0} for {1} to {2}", new Object[]{hubUrl, subscription.getSourceUrl(), callbackUrl});
         Runnable r = new Runnable() {
                @Override
                public void run() {
                    try {
                        sendRequest(hubUrl, "unsubscribe", subscription, verifySync, -1, secret, callbackUrl,
                            callback);
                    } catch (IOException ex) {
                        Logger.getLogger(AsyncRequester.class.getName())
                              .log(Level.SEVERE, null, ex);
                        callback.onFailure(ex);
                    }
                }
            };
            new Thread(r).start();
    }
}
