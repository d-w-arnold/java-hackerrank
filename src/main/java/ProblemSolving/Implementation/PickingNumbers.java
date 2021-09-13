package ProblemSolving.Implementation;

import java.util.Collections;
import java.util.List;

/**
 * @author David W. Arnold
 * @version 11/06/2021
 */
public class PickingNumbers
{
    /**
     * Picking Numbers problem: https://www.hackerrank.com/challenges/picking-numbers/problem
     *
     * @param a An array of integers.
     * @return The length of the longest subarray that meets the criterion.
     */
    public static int pickingNumbers(List<Integer> a)
    {
        Collections.sort(a);
        int maximumCount = 0;
        int tmpCount;
        for (int i = 0; i < a.size(); i++) {
            if (maximumCount > (a.size() - i)) return maximumCount;
            tmpCount = 1;
            for (int j = i + 1; j < a.size(); j++) {
                if (Math.abs(a.get(i) - a.get(j)) <= 1) {
                    tmpCount++;
                    if (j + 1 == a.size()) maximumCount = Math.max(tmpCount, maximumCount);
                } else {
                    maximumCount = Math.max(tmpCount, maximumCount);
                    break;
                }
            }
        }
        return maximumCount;
    }
}
