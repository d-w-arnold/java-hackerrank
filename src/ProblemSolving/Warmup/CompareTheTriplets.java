package ProblemSolving.Warmup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author David W. Arnold
 * @version 03/06/2021
 */
public class CompareTheTriplets
{
    /**
     * Compare the Triplets problem: https://www.hackerrank.com/challenges/compare-the-triplets/problem
     *
     * @param a Alice's challenge rating.
     * @param b Bob's challenge rating.
     * @return Alice's score is in the first position, and Bob's score is in the second.
     */
    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b)
    {
        int aliceIndex = 0;
        int bobIndex = 1;
        List<Integer> scores = new ArrayList<>(Arrays.asList(0, 0));
        for (int i = 0; i < a.size(); i++) {
            int aliceScore = a.get(i);
            int bobScore = b.get(i);
            if (aliceScore > bobScore) {
                scores.set(aliceIndex, scores.get(aliceIndex) + 1);
            } else if (aliceScore < bobScore) {
                scores.set(bobIndex, scores.get(bobIndex) + 1);
            }
        }
        return scores;
    }
}
