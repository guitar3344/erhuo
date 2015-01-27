package com.jita.erhuo.util;

import com.jita.erhuo.exceptions.DateFormatException;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by guitar on 15/1/26.
 */
public class DateUtil {

    /**
     *
     * @param d
     * @return 返回格式化的时间间隔，例如：1天前，2月前
     * @throws DateFormatException
     */
    public static String getFormatIntervalBeforeNow(Date d) throws DateFormatException {
        String formatInterval = "";
        long now = Calendar.getInstance().getTimeInMillis();
        if(now - d.getTime() < 0){
            throw new DateFormatException("param d is after now!");
        }
        long intervalSeconds = (now - d.getTime()) / 1000;
        if (intervalSeconds > 365 * 24 * 60 * 60) {
            formatInterval = (int) (intervalSeconds / (365 * 24 * 60 * 60)) + "年前";
        } else if (intervalSeconds > 30 * 24 * 60 * 60) {
            formatInterval = (int) (intervalSeconds / (30 * 24 * 60 * 60)) + "月前";
        } else if (intervalSeconds > 24 * 60 * 60) {
            formatInterval = (int) (intervalSeconds / (24 * 60 * 60)) + "天前";
        } else if (intervalSeconds > 60 * 60) {
            formatInterval = (int) (intervalSeconds / (60 * 60)) + "小时前";
        } else if (intervalSeconds > 60) {
            formatInterval = (int) (intervalSeconds / (60)) + "分前";
        } else if (intervalSeconds > 1) {
            formatInterval = intervalSeconds + "秒前";
        } else {
            formatInterval = "1秒前";
        }
        return formatInterval;
    }
}
