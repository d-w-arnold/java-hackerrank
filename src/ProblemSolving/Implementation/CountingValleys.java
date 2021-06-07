package ProblemSolving.Implementation;

/**
 * @author David W. Arnold
 * @version 07/06/2021
 */
public class CountingValleys
{
    /**
     * Counting Valleys problem: https://www.hackerrank.com/challenges/counting-valleys/problem
     *
     * @param steps The number of steps on the hike.
     * @param path  A string describing the path.
     * @return The number of valleys traversed.
     */
    public static int countingValleys(int steps, String path)
    {
        int altitude = 0;
        int valleys = 0;
        for (int i = 0; i < steps; i++) {
            char step = path.charAt(i);
            if (step == 'D') {
                if (altitude == 0) {
                    valleys += 1;
                }
                altitude -= 1;
            } else if (step == 'U') {
                altitude += 1;
            }
        }
        return valleys;
    }
}
