/* Copyright (C) 2010-2011, Mamadou Diop.
 *  Copyright (C) 2011, Doubango Telecom.
 *
 * Contact: Mamadou Diop <diopmamadou(at)doubango(dot)org>
 *
 * This file is part of imsdroid Project (http://code.google.com/p/imsdroid)
 *
 * imsdroid is free software: you can redistribute it and/or modify it under the terms of
 * the GNU General Public License as published by the Free Software Foundation, either version 3
 * of the License, or (at your option) any later version.
 *
 * imsdroid is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package com.wangzijie.nutrition_user.utils;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;

import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.NtpV3Packet;
import org.apache.commons.net.ntp.TimeInfo;
import org.apache.commons.net.ntp.TimeStamp;

import java.net.InetAddress;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  @author     WangZequan
 *  @time       2018/7/10  11:14
 *  @describe
 */
@SuppressLint("SimpleDateFormat")
public class DateTimeUtils {
    static final SimpleDateFormat sDateTimeFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm");
    static final SimpleDateFormat sTimeFormat = new SimpleDateFormat("HH:mm");
    static final SimpleDateFormat sSimpleDateFormat = new SimpleDateFormat("MM-dd");
    static final SimpleDateFormat sSimpleDateWeekFormat = new SimpleDateFormat("E");
    static final SimpleDateFormat sDefaultDateFormat = new SimpleDateFormat("yyyy-MM-dd");


    static String sTodayName;
    static String sYesterdayName;
    private static ExecutorService timeThreadPool = Executors.newFixedThreadPool(1);
    ;

    public static boolean isYesterDay(Date date, Date today) {
        return (today.getDay() - date.getDay() == 1) && today.getMonth() == date.getMonth()
                && today.getYear() == date.getYear();
    }

    public static boolean isSameDay(Date d1, Date d2) {
        return d1.getDay() == d2.getDay() && d1.getMonth() == d2.getMonth() && d1.getYear() == d2.getYear();
    }

    public static boolean isSameYear(Date d1, Date d2) {
        return d1.getYear() == d2.getYear();
    }

    public static boolean isSameWeek(Date d1, Date d2) {

        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(d1);
        cal2.setTime(d2);
        if (cal1.get(Calendar.WEEK_OF_YEAR) == cal2.get(Calendar.WEEK_OF_YEAR))
            return true;
        else
            return false;
    }

    public static String getTodayName() {
        if (sTodayName == null) {
            sTodayName = "今日";
        }
        return sTodayName;
    }

    public static String getYesterdayName() {
        if (sYesterdayName == null) {
            sYesterdayName = "昨天";
        }
        return sYesterdayName;
    }

    @SuppressWarnings("deprecation")
    public static String getFriendlyDateString(final Date date) {
        final Date today = new Date();
        if (DateTimeUtils.isSameDay(date, today)) {
            return String.format("%s", sTimeFormat.format(date));
        } else if (DateTimeUtils.isSameYear(date, today)) {
            if (isYesterDay(date, today)) {
                return String.format("%s %s", getYesterdayName(), sTimeFormat.format(date));
            } else if (DateTimeUtils.isSameWeek(date, today)) {
                return String.format("%s %s", sSimpleDateWeekFormat.format(date), sTimeFormat.format(date));
            } else {
                return String.format("%s %s", sSimpleDateFormat.format(date), sTimeFormat.format(date));
            }
        } else {
            return sDateTimeFormat.format(date);
        }
    }


    public static String getTime(long millisecond) {
        Date date = new Date(millisecond);
        String time = "";
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            df.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
            time = df.format(date);
        }
        return time;
    }

    public static String getTime(long millisecond, String format) {
        Date date = new Date(millisecond);
        String time = "";
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(format);
            df.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
            time = df.format(date);
        }
        return time;
    }

    /**
     * 将一种格式的日期转换成另一种格式
     *
     * @param dateString     日期字符
     * @param originalFormat 之前的格式
     * @param afterFormat    转换后的格式
     * @return
     */
    public static String getTime(String dateString, String originalFormat, String afterFormat) {
        Date date = null;
        SimpleDateFormat df1 = new SimpleDateFormat(originalFormat);
        SimpleDateFormat df2 = new SimpleDateFormat(afterFormat);
        df1.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
        df2.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
        if (dateString.isEmpty()) {
            dateString = now();
            df1 = sDefaultDateFormat;
        }
        try {
            date = df1.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return df2.format(date);
    }

    public static String getTime(Date date, String format) {
        String time = "";
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(format);
            df.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
            time = df.format(date);
        }
        return time;
    }

    public static String getTime(Date date) {
        String time = "";
        if (date != null) {
            sDefaultDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
            time = sDefaultDateFormat.format(date);
        }
        return time;
    }

    public static long getTime(String time) {
        Date date = parseDate(time, sDefaultDateFormat);
        sDefaultDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
        time = sDefaultDateFormat.format(date);
        return date.getTime();
    }


    public static long[] formatDuring(long mss) {
        long[] times = null;
        if (mss > 0) {
            long days = mss / (1000 * 60 * 60 * 24);
            long hours = (mss % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
            long minutes = (mss % (1000 * 60 * 60)) / (1000 * 60);
            long seconds = (mss % (1000 * 60)) / 1000;
            times = new long[]{days, hours, minutes, seconds};
        }
        return times;
    }


    public static long getCurrentTimeU() {
        return System.currentTimeMillis() * 1000;
    }

    public static String now() {
        Calendar cal = Calendar.getInstance();
        return sDefaultDateFormat.format(cal.getTime());
    }

    public static Date parseDate(String date, DateFormat format) {
        if (!TextUtils.isEmpty(date)) {
            try {
                return format == null ? sDefaultDateFormat.parse(date) : format.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return new Date();
    }

    public static String getFriendlyDate(final Date date) {
        String sDate = null;
        final Date today = new Date();
        if (DateTimeUtils.isSameDay(date, today)) {
            sDate = getTodayName();
        } else {
            sDate = getTime(date, "MM月dd日");
        }
        return sDate;
    }

    public static void getNTPTime(final TimeCallBack callBack) {
        getTime(true, callBack);
    }

    public static void getTime(final boolean isRetry, final TimeCallBack callBack) {
        timeThreadPool.execute(() -> {
            long startTime = System.currentTimeMillis();
            Date date;
            NTPUDPClient client = new NTPUDPClient();
            //设置超时时间
            client.setDefaultTimeout(500);
            try {
                client.open();
                InetAddress hostAddr = null;
                if (isRetry) {
                    hostAddr = InetAddress.getByName("182.92.12.11");
                } else {
                    hostAddr = InetAddress.getByName("202.112.29.82");
                }
                TimeInfo info = null;
                info = client.getTime(hostAddr);
                NtpV3Packet message = info.getMessage();
                TimeStamp rcvNtpTime = message.getReceiveTimeStamp();
                client.close();
                date = new Date(rcvNtpTime.getTime());
                String time = "";
                if (date != null) {
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                    df.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
                    time = df.format(date);
                }
                long consuming = System.currentTimeMillis() - startTime;
                Log.d("NTP", "获取网络时间的耗时（毫秒）:" + consuming);
                callBack.succeed(time);
            } catch (Exception e) {
                if (isRetry) {
                    getTime(false, callBack);
                } else {
                    client.close();
                    date = new Date(System.currentTimeMillis());
                    String time = "";
                    if (date != null) {
                        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                        df.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
                        time = df.format(date);
                    }
                    Log.d("NTP", "获取网络时间失败" + e.toString());
                    callBack.succeed(time);
                }
            }
        });
    }




    public interface TimeCallBack {

        void succeed(String time);
    }


}


//	public static String now(String dateFormat) {
//		Calendar cal = Calendar.getInstance();
//		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
//		return sdf.format(cal.getTime());
//	}
//	public static Date parseDate(String date) {
//		return parseDate(date, null);
//	}
//	@SuppressWarnings("deprecation")
//	public static String[] getFriendlyDateArray(final Date date) {
//		String[] args = null;
//		final Date today = new Date();
//		if (DateTimeUtils.isSameDay(date, today)) {
//			args = new String[] { getTodayName(), getTime(date.getTime(), "HH:mm") };
//		} else if ((today.getDay() - date.getDay()) == 1) {
//			args = new String[] { getYesterdayName(), getTime(date.getTime(), "HH:mm") };
//		} else {
//			args = new String[] { getTime(date.getTime(), "yyyy.MM.dd"), getTime(date.getTime(), "HH:mm") };
//		}
//		return args;
//	}
//
//
//	public static String getTime(final Date date, final String format) {
//		String time = null;
//		if (date != null) {
//			SimpleDateFormat df = new SimpleDateFormat(format);
//			df.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
//			time = df.format(date);
//		}
//		return time;
//	}
//	public static long[] formatDuring(Date begin, Date end) {
//		return formatDuring(end.getTime() - begin.getTime());
//	}
//
//
//	public static long[] formatDuring(long begin, long end) {
//		return formatDuring(end - begin);
//	}