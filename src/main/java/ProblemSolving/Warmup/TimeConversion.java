package ProblemSolving.Warmup;

/**
 * @author David W. Arnold
 * @version 04/06/2021
 */
public class TimeConversion
{
    public static String timeConversion(String s)
    {
        String timeSep = ":";
        String amOrPm = s.substring(s.length() - 2);
        String time = s.substring(0, s.length() - 2);
        String[] hoursMinsSecs = time.split(timeSep);
        if (hoursMinsSecs[0].equals("12")) {
            if (amOrPm.equals("PM")) {
                return time;
            } else if (amOrPm.equals("AM")) {
                hoursMinsSecs[0] = "00";
            }
        } else if (amOrPm.equals("PM") && 1 <= Integer.parseInt(hoursMinsSecs[0]) && Integer.parseInt(hoursMinsSecs[0]) <= 11) {
            hoursMinsSecs[0] = Integer.toString(Integer.parseInt(hoursMinsSecs[0]) + 12);
        } else {
            return time;
        }
        time = String.join(timeSep, hoursMinsSecs);
        return time;
    }
}
