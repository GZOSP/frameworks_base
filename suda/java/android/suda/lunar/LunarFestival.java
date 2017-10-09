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

package android.suda.lunar;

import java.util.Calendar;

public class LunarFestival {

    public static String getLunarFestival(String chinadate, Lunar lunar) {
        String[] lunarFestivalArray = Constant.getLunarFestival();
        chinadate = chinadate.substring(chinadate.length() - 4, chinadate.length());
        for (int i = 0; i < lunarFestivalArray.length; i++) {
            String[] lunar_str = lunarFestivalArray[i].split(" ");
            if (lunar_str[0].equals(chinadate)) {
                if (i == 0) {
                    return lunar.isBigMonth(lunar_str[0]) ? "" : lunar_str[1] ;
                } else {
                    return lunar_str[1];
                }
            }
        }
        return "";
    }
}
