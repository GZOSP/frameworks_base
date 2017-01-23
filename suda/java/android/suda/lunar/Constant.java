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

package android.suda.lunar;

import android.content.res.Resources;

import java.util.Locale;

/**
 * Created by Suda on 2015/10/18.
 */
public class Constant {

    public static final String STATUS_LEAP_CN = "闰";
    public static final String STATUS_LEAP_HK_TW = "閏";
    public static final String STATUS_YEAR_CN= "年";
    public static final String STATUS_MONTH_CN= "月";
    public static final String STATUS_DAY_CN= "日";
    public static final String STATUS_CHUSHI_CN = "初十";
    public static final String STATUS_ERSHI_CN = "二十";
    public static final String STATUS_SANSHI_CN = "三十";
    public static final String STATUS_FORMAT_1_CN = "yyyy年MM月dd日";
    public static final String STATUS_FORMAT_2_CN = "1900年1月31日";
    public static final String[] GAN_CN = {"甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸"};
    public static final String[] ZHI_CN = {"子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥"};
    public static final String[] CHINESE_NUMBER_CN = {"一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二"};
    public static final String[] CHINESE_TEN_CN = {"初", "十", "廿", "卅"};
    public static final String[] SOLAR_TERM_CN = {"", "小寒", "大寒", "立春", "雨水", "惊蛰", "春分", "清明", "谷雨", "立夏", "小满", "芒种", "夏至", "小暑", "大暑", "立秋", "处暑", "白露", "秋分", "寒露", "霜降", "立冬", "小雪", "大雪", "冬至"};
    public static final String[] LUNAR_MONTH_NAME_CN = {"正", "二", "三", "四", "五", "六", "七", "八", "九", "十", "冬", "腊"};

    public static final String[] ANIMALS_CN = {"鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊", "猴", "鸡", "狗", "猪"};
    public static final String[] ANIMALS_HK_TW = {"鼠", "牛", "虎", "兔", "龍", "蛇", "馬", "羊", "猴", "雞", "狗", "豬"};
 
    public static final String[] LUNAR_FESTIVAL_CN = {"腊月廿九 除夕", "腊月三十 除夕", "正月初一 春节", "正月十五 元宵节", "五月初五 端午节", "七月初七 七夕节", "七月十五 中元节", "八月十五 中秋节", "九月初九 重阳节", "腊月初八 腊八节", "腊月廿三 小年"};
    public static final String[] LUNAR_FESTIVAL_HK_TW = {"臘月廿九 除夕", "臘月三十 除夕", "正月初一 春節", "正月十五 元宵節", "五月初五 端午節", "七月初七 七夕節", "七月十五 中元節", "八月十五 中秋節", "九月初九 重陽節", "腊月初八 臘八節", "臘月廿三 小年"};

    public static final String[] HOLIDAY_CN = {"0101 元旦", "0214 情人节", "0308 妇女节", "0312 植树节",
                    "0315 消费日", "0401 愚人节", "0413 泼水节", "0501 劳动节", "0504 青年节", "0601 儿童节",
                    "0701 建党日", "0801 建军节", "0903 抗战胜利", "0910 教师节", "1001 国庆节", "1031 万圣节",
                    "1111 光棍节", "1224 平安夜", "1225 圣诞节"};

    public static final String[] HOLIDAY_HK = {"0101 元旦", "0214 情人節", "0308 婦女節", "0401 愚人節",
                    "0501 勞動節", "0701 特區紀念", "0910 教師節", "1001 國慶節", "1031 萬聖節", "1224 平安夜",
                    "1225 聖誕節"};

    public static final String[] HOLIDAY_TW = {"0101 元旦", "0214 情人節", "0228 和平紀念", "0308 婦女節",
                    "0312 國父逝世", "0314 反侵略日", "0329 先烈紀念", "0401 愚人節", "0404 兒童節", "0501 勞動節",
                    "0715 解放紀念", "0808 父親節", "0903 軍人節", "0928 孔子誕辰", "1010 國慶節", "1024 聯合國日", "1025 臺灣光復",
                    "1112 國父誕辰", "1031 萬聖節", "1224 平安夜", "1225 聖誕節"};

    public static String[] getAnimals() {
        Locale locale = Resources.getSystem().getConfiguration().locale;
        if (locale.getCountry().equals("CN")) {
            return ANIMALS_CN;
        }
        return ANIMALS_HK_TW;
    }

    public static String[] getLunarFestival() {
        Locale locale = Resources.getSystem().getConfiguration().locale;
        if (locale.getCountry().equals("CN")) {
            return LUNAR_FESTIVAL_CN;
        }
        return LUNAR_FESTIVAL_HK_TW;
    }

    public static String[] getSolarHoliday() {
        Locale locale = Resources.getSystem().getConfiguration().locale;
        if (locale.getCountry().equals("CN")) {
            return HOLIDAY_CN;		
        } else if (locale.getCountry().equals("HK")) {
            return HOLIDAY_HK;
        } else if (locale.getCountry().equals("TW")) {
            return HOLIDAY_TW;	
        }
        return HOLIDAY_CN;
    }

    public static String getLeap(){
        Locale locale = Resources.getSystem().getConfiguration().locale;
        if (locale.getCountry().equals("CN")) {
            return STATUS_LEAP_CN;
        }
        return STATUS_LEAP_HK_TW;
    }

}
