package ProblemSolving.Warmup;

/**
 * @author David W. Arnold
 * @version 04/06/2021
 */
public class TimeConversion
{
    /**
     * Time Conversion problem: https://www.hackerrank.com/challenges/one-month-preparation-kit-time-conversion/problem
     *
     * @param s A time in 12-hour format.
     * @return The time in 24-hour format.
     */
    public static String timeConversion(String s)
    {
        String timeSep = ":";
        String amOrPm = s.substring(s.length() - 2);
        String time = s.substring(0, s.length() - 2);
        String[] hourMinSec = time.split(timeSep);
        if (hourMinSec[0].equals("12")) {
            if (amOrPm.equals("PM")) return time;
            else if (amOrPm.equals("AM")) hourMinSec[0] = "00";
        } else if (amOrPm.equals("PM") && 1 <= Integer.parseInt(hourMinSec[0]) && Integer.parseInt(hourMinSec[0]) <= 11)
            hourMinSec[0] = Integer.toString(Integer.parseInt(hourMinSec[0]) + 12);
        else return time;
        return String.join(timeSep, hourMinSec);
    }
}
