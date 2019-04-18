/**
 *
 */
package io.ikatoo.cryptoassets.uteis;

/**
 * The Class TimeUtils.
 *
 * @author ashraf
 */
public class TimeUtils {

    /**
     * Convert to millis time.
     *
     * @param time the time
     * @return the long
     */
    public static long convertToMillisTime(String time) {
        long timeMillis = 0;
        long hours = new Integer(time.substring(0, 2)).intValue();
        long minutes = new Integer(time.substring(3, 5)).intValue();
        long seconds = new Integer(time.substring(6, 8)).intValue();
        long millis = 0;
        if (time.length() == 12) {
            millis = new Integer(time.substring(9, 12)).intValue();
        }
        timeMillis = (hours * 60 + minutes) * 60 * 1000 + seconds * 1000 + millis;
        return timeMillis;
    }

    /**
     * Convert to readable time.
     *
     * @param millis the millis
     * @return the string
     */
    public static String convertToReadableTime(long millis) {
        long second = (millis / 1000) % 60;
        long minute = (millis / (1000 * 60)) % 60;
        long hour = (millis / (1000 * 60 * 60)) % 24;

        String time = String.format("%02d:%02d:%02d:%d", hour, minute, second, millis);
        return time;
    }

    public static int convertIntervalToMilliseconds(String interval) {
        int one_minute = 60 * 1000;
        int intervalNumber;
        switch (interval) {
            case "1m":
                intervalNumber = one_minute;
                break;
            case "3m":
                intervalNumber = 3 * one_minute;
                break;
            case "5m":
                intervalNumber = 5 * one_minute;
                break;
            case "15m":
                intervalNumber = 15 * one_minute;
                break;
            case "30m":
                intervalNumber = 1 * one_minute;
                break;
            case "1h":
                intervalNumber = 1 * one_minute;
                break;
            case "2h":
                intervalNumber = 1 * one_minute;
                break;
            case "4h":
                intervalNumber = 1 * one_minute;
                break;
            case "6h":
                intervalNumber = 1 * one_minute;
                break;
            case "8h":
                intervalNumber = 1 * one_minute;
                break;
            case "12h":
                intervalNumber = 1 * one_minute;
                break;
            case "1d":
                intervalNumber = 1 * one_minute;
                break;
            case "3d":
                intervalNumber = 1 * one_minute;
                break;
            case "1w":
                intervalNumber = 1 * one_minute;
                break;
            case "1M":
                intervalNumber = 1 * one_minute;
                break;
            default:
                intervalNumber = 1 * one_minute;
                break;
        }
        return intervalNumber;
    }

}
