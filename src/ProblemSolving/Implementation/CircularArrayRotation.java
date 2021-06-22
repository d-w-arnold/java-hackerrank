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
        rotate(a, k);
        List<Integer> ans = new ArrayList<>();
        for (int q : queries) {
            ans.add(a.get(q));
        }
        return ans;
    }

    private static void rotate(List<Integer> a, int k)
    {
        for (int i = 0; i < k; i++) {
            rotateByOne(a);
        }
    }

    private static void rotateByOne(List<Integer> a)
    {
        final List<Integer> originalA = new ArrayList<>(a);
        for (int i = 0; i < a.size() - 1; i++) {
            a.set(i + 1, originalA.get(i));
        }
        a.set(0, originalA.get(a.size() - 1));
    }
}
