/*
 * Copyright (C) 2012 - 2015 The MoKee OpenSource Project
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

package android.suda.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.text.DecimalFormat;
import java.util.Locale;

/**
* @hide
*/

public class SudaUtils {

    private static String LIBNAME = "sudautils";

    static {
        System.loadLibrary(LIBNAME);
    }

    //2018年法定节假日
    private static int YEAR = 2018;
    //一月
    private static int[] JANH = {1};
    //二月
    private static int[] FEBH = {15, 16, 17, 18, 19, 20, 21};
    //四月
    private static int[] APRH = {5, 6, 7, 29, 30};
    //五月
    private static int[] MAYH = {1};
    //六月
    private static int[] JUNH = {16, 17, 18};
    //九月
    private static int[] SEPH = {22, 23, 24};
    //十月
    private static int[] OCTH = {1, 2, 3, 4, 5, 6, 7};

    public static native boolean isSupportLanguage(boolean excludeTW);

    public static boolean isOnline(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnected()) {
            return true;
        }
        return false;
    }

    public static boolean isApkInstalledAndEnabled(String packagename, Context context) {
        int state;
        try {
            context.getPackageManager().getPackageInfo(packagename, 0);
            state = context.getPackageManager().getApplicationEnabledSetting(packagename);
        } catch (NameNotFoundException e) {
            return false;
        }
        return state != PackageManager.COMPONENT_ENABLED_STATE_DISABLED && state != PackageManager.COMPONENT_ENABLED_STATE_DISABLED_USER ? true : false;
    }

    public static boolean isApkInstalled(String packagename, Context context) {
        try {
            context.getPackageManager().getPackageInfo(packagename, 0);
        } catch (NameNotFoundException e) {
            return false;
        }
        return true;
    }

    public static boolean isSystemApp(String packagename, Context context) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(packagename, 0);
        } catch (NameNotFoundException e) {
            return false;
        }
        return ((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0);
    }

    public static boolean isChineseHoliday(int y, int m, int d) {
        boolean bResult = false;
        if( y == YEAR-1 && m == 12 && d == 31 ) return true;
        if( y == YEAR ){
            switch(m) {
                case 1:
                  for(int tmp:JANH){
                      if(d == tmp) bResult=true;
                  }
                break;
                case 2:
                  for(int tmp:FEBH){
                      if(d == tmp) bResult=true;
                  }
                break;
                case 3:
                break;
                case 4:
                  for(int tmp:APRH){
                      if(d == tmp) bResult=true;
                  }
                break;
                case 5:
                  for(int tmp:MAYH){
                      if(d == tmp) bResult=true;
                  }
                break;
                case 6:
                  for(int tmp:JUNH){
                      if(d == tmp) bResult=true;
                  }
                break;
                case 7:
                break;
                case 8:
                break;
                case 9:
                  for(int tmp:SEPH){
                      if(d == tmp) bResult=true;
                  }
                break;
                case 10:
                  for(int tmp:OCTH){
                      if(d == tmp) bResult=true;
                  }
                break;
                case 11:
                break;
                case 12:
                break;
            }
        }
        return bResult;
    }

    public static String formatFileSize(long size) {
        DecimalFormat df = new DecimalFormat("#0.00");
        String fileSizeString = "";
        if (size < 1024) {
            fileSizeString = df.format((double) size) + "B";
        } else if (size < 1048576) {
            fileSizeString = df.format((double) size / 1024) + "K";
        } else if (size < 1073741824) {
            fileSizeString = df.format((double) size / 1048576) + "M";
        } else {
            fileSizeString = df.format((double) size / 1073741824) + "G";
        }
        return fileSizeString;
    }

}
