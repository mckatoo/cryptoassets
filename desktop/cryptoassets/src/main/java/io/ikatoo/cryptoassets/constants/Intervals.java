/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.ikatoo.cryptoassets.constants;

/**
 *
 * @author mckatoo
 */
public class Intervals {
    public static final String ONE_MINUTE = "1m";
    public static final String THREE_MINUTES = "3m";
    public static final String FIVE_MINUTES = "5m";
    public static final String FIFTEEN_MINUTES = "15m";
    public static final String THIRTY_MINUTES = "30m";
    public static final String ONE_HOUR = "1h";
    public static final String TWO_HOURS = "2h";
    public static final String FOUR_HOURS = "4h";
    public static final String SIX_HOURS = "6h";
    public static final String EIGHT_HOURS = "8h";
    public static final String TWELVE_HOURS = "12h";
    public static final String ONE_DAY = "1d";
    public static final String THREE_DAY = "3d";
    public static final String ONE_WEEK = "1w";
    public static final String ONE_MONTH = "1M";
    
    public static String[] Intervals(){
        String[] intervals = new String[15];
        intervals[0] = ONE_MINUTE;
        intervals[1] = THREE_MINUTES;
        intervals[2] = FIVE_MINUTES;
        intervals[3] = FIFTEEN_MINUTES;
        intervals[4] = THIRTY_MINUTES;
        intervals[5] = ONE_HOUR;
        intervals[6] = TWO_HOURS;
        intervals[7] = FOUR_HOURS;
        intervals[8] = SIX_HOURS;
        intervals[9] = EIGHT_HOURS;
        intervals[10] = TWELVE_HOURS;
        intervals[11] = ONE_DAY;
        intervals[12] = THREE_DAY;
        intervals[13] = ONE_WEEK;
        intervals[14] = ONE_MONTH;
        
        return intervals;
    }
}
