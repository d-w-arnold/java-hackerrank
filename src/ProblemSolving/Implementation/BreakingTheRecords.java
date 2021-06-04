package ProblemSolving.Implementation;

import java.util.Arrays;
import java.util.List;

/**
 * @author David W. Arnold
 * @version 04/06/2021
 */
public class BreakingTheRecords
{
    /**
     * @param scores Points scored per game.
     * @return An array with the numbers of times she broke her records. Index 0 is for breaking most points records, and index 1 is for breaking least points records.
     */
    public static List<Integer> breakingRecords(List<Integer> scores)
    {
        int minimum = scores.get(0);
        int maximum = scores.get(0);
        int minTotal = 0;
        int maxTotal = 0;
        for (int i = 1; i < scores.size(); i++) {
            int score = scores.get(i);
            if (score > maximum) {
                maximum = score;
                maxTotal++;
            }
            if (score < minimum) {
                minimum = score;
                minTotal++;
            }
        }
        return Arrays.asList(maxTotal, minTotal);
    }
}
