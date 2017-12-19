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

public class SolarHoliDay {

    public static String getSolarHoliDay(int currentYear, int currentMonth, int currentDayForMonth) {
        String num_date = String.format("%02d", currentMonth + 1) + "" + String.format("%02d", currentDayForMonth);
        String[] solarHolidayArray = Constant.getSolarHoliday();
        for(int i = 0; i < solarHolidayArray.length; i++) {
            String[] solarHolidayDateStr = solarHolidayArray[i].split(" ");
            if (solarHolidayDateStr[0].equals(num_date)) {
                return solarHolidayDateStr[1];
            }
        }
        return getSpecialDay(currentYear, currentMonth, currentDayForMonth);
    }

    public static String getSpecialDay(int year, int month, int day) {
        String[] specDays = Constant.getSpecday();
        for (String specDay : specDays) {
            int monthIndex = Integer.parseInt(specDay.split(",")[0]) - 1;
            if (month != monthIndex) {
                continue;
            }
            int weekIndex = Integer.parseInt(specDay.split(",")[1]);
            int dayIndex = Integer.parseInt(specDay.split(",")[2]);
            String dayName = specDay.split(",")[3];
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
            int mark = dayIndex - dayOfWeek;
            if (mark >= 0) {
                weekIndex--;
            }
            int addDay = mark + 7 * (weekIndex);
            calendar.add(Calendar.DATE, addDay);
            if (calendar.get(Calendar.DATE) == day) {
                return dayName;
            }

        }
        return "";
    }
}
