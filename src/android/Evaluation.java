/*
       Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
*/

package org.apache.cordova.evaluation;

import org.json.JSONArray;
import org.json.JSONException;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;

public class Evaluation extends CordovaPlugin {

    private static final String LOG_TAG = "EvaluationPlugin";

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if ("run".equals(action)) {
            try {
              Uri uri = Uri.parse("market://details?id="+this.cordova.getActivity().getPackageName());
              Intent intent = new Intent(Intent.ACTION_VIEW,uri);
              intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                this.cordova.getActivity().startActivity(intent);

            } catch (Exception e) {
                Log.e(LOG_TAG, "Exception occurred: ".concat(e.getMessage()));
                return false;
            }
            callbackContext.success();
            return true;
        }
        Log.e(LOG_TAG, "Called invalid action: "+action);
        return false;
    }
}
