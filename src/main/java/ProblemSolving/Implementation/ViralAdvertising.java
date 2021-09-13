package ProblemSolving.Implementation;

/**
 * @author David W. Arnold
 * @version 22/06/2021
 */
public class ViralAdvertising
{
    /**
     * Viral Advertising problem:
     *
     * @param n The day number to report.
     * @return The cumulative likes at that day.
     */
    public static int viralAdvertising(int n)
    {
        if (n > 0) {
            int cumulativeTotal = 0;
            int shared = 5;
            for (int i = 1; i <= n; i++) {
                int liked = shared / 2;
                cumulativeTotal += liked;
                shared = liked * 3;
            }
            return cumulativeTotal;
        }
        return -1;
    }
}
