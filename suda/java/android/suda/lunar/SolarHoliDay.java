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

public class SolarHoliDay {

    public static String getSolarHoliDay(int currentMonth, int currentDayForMonth) {
        String num_date = String.format("%02d", currentMonth + 1) + "" + String.format("%02d", currentDayForMonth);
        String[] solarHolidayArray = Constant.getSolarHoliday();
        for(int i = 0; i < solarHolidayArray.length; i++) {
            String[] solarHolidayDateStr = solarHolidayArray[i].split(" ");
            if (solarHolidayDateStr[0].equals(num_date)) {
                return solarHolidayDateStr[1];
            }
        }
        return "";
    }
}
