package ProblemSolving.Implementation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author David W. Arnold
 * @version 22/06/2021
 */
public class CircularArrayRotation
{
    /**
     * Circular Array Rotation problem: https://www.hackerrank.com/challenges/circular-array-rotation/problem
     *
     * @param a       The array to rotate.
     * @param k       The rotation count.
     * @param queries The indices to report.
     * @return The values in the rotated 'a' as requested in 'm'.
     */
    public static List<Integer> circularArrayRotation(List<Integer> a, int k, List<Integer> queries)
    {
        List<Integer> ans = new ArrayList<>();
        k %= a.size();
        for (int q : queries) {
            if (a.size() % k == 0) {
                ans.add(a.get(q));
            } else {
                ans.add(a.get(((a.size() - k) + q) % a.size()));
            }
        }
        return ans;
    }
}
