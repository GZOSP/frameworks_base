/*
 * Copyright (C) 2015 The SudaMod Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.suda.location;

import android.text.TextUtils;

/**
* @hide
*/

public final class PhoneLocation {

    private static String[] familyArray = {
        "751", "752", "753", 
        "754", "755", "756",
        "757", "758", "759",
        "760", "761", "762",
        "763", "764", "765",
        "766", "767", "768",
        "769"
    };

    private static String LIBPATH = "suda-phoneloc-jni";

    static {
        System.loadLibrary(LIBPATH);
    }

    private static native String getPhoneLocationJni(String number);

    private synchronized static String doGetLocationFromPhone(String number) {
        if (TextUtils.isEmpty(number)) return null;
        return getPhoneLocationJni(number);
    }

    private static String getPosFromPhone(String number, int i) {
        String s = doGetLocationFromPhone(number);
        String[] ss = null;
        if (null != s) {
            ss = s.split(",");
            if (ss.length == 2) return ss[i];
        }
        return "";
    }

    public static String getFamily(String number) {
        for(String temp : familyArray) {
            if (temp.equals(number)) {
                return "亲情号码";
            }
        }
        return null;
    }

    public static String getCodeFromPhone(String number) {
        return getPosFromPhone(number, 0);
    }

    public static String getCityFromPhone(String number) {
        if (TextUtils.isEmpty(number)) {
            return "";
        }
        String phoneLocation = getPosFromPhone(number.replaceAll("(?:-| )", ""), 1);
        return !TextUtils.isEmpty(getFamily(number)) ? getFamily(number) : phoneLocation;
    }
}
