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
     * Breaking the Records problem: https://www.hackerrank.com/challenges/three-month-preparation-kit-breaking-best-and-worst-records/problem
     *
     * @param scores Points scored per game.
     * @return An array with the numbers of times she broke her records. Index 0 is for breaking most points records, and index 1 is for breaking least points records.
     */
    public static List<Integer> breakingRecords(List<Integer> scores)
    {
        int minimum = scores.get(0), maximum = scores.get(0), minTotal = 0, maxTotal = 0;
        for (int score : scores) {
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
