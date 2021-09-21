package InterviewPreparationKit.RecursionAndBacktracking.Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author David W. Arnold
 * @version 21/09/2021
 */
public class DavisStaircase
{
    /**
     * Recursion: Davis' Staircase problem: https://www.hackerrank.com/challenges/ctci-recursive-staircase/problem
     *
     * @param n The number of stairs in the staircase.
     * @return The number of ways Davis can climb the staircase, modulo 10000000007.
     */
    public static int stepPerms(int n)
    {
        Map<Integer, Integer> cache = new HashMap<>();
        return stepPermsHelper(cache, n);
    }

    private static int stepPermsHelper(Map<Integer, Integer> cache, int n)
    {
        if (n == 1) return 1;
        else if (n == 2) return 2;
        else if (n == 3) return 4;
        else if (!cache.containsKey(n))
            cache.put(n, stepPermsHelper(cache, n - 1) + stepPermsHelper(cache, n - 2) + stepPermsHelper(cache, n - 3));
        return cache.get(n);
    }
}
