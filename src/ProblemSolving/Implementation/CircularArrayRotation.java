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
        k %= a.size();
        a = rotate(a, k);
        List<Integer> ans = new ArrayList<>();
        for (int q : queries) {
            ans.add(a.get(q));
        }
        return ans;
    }

    private static List<Integer> rotate(List<Integer> a, int k)
    {
        List<Integer> newA = new ArrayList<>();
        newA.addAll(a.subList(a.size() - k, a.size()));
        newA.addAll(a.subList(0, a.size() - k));
        return newA;
    }
}
