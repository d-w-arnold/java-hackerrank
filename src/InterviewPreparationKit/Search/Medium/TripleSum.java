package InterviewPreparationKit.Search.Medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author David W. Arnold
 * @version 13/08/2021
 */
public class TripleSum
{
    /**
     * Triple Sum problem: https://www.hackerrank.com/challenges/triple-sum/problem
     *
     * @param a An array of integers.
     * @param b An array of integers.
     * @param c An array of integers.
     * @return The number of distinct triplets that can be formed from the given arrays.
     */
    public static long triplets(int[] a, int[] b, int[] c)
    {
        List<Integer> newA = new ArrayList<>(new HashSet<>(Arrays.stream(a).boxed().collect(Collectors.toList())));
        List<Integer> newB = new ArrayList<>(new HashSet<>(Arrays.stream(b).boxed().collect(Collectors.toList())));
        List<Integer> newC = new ArrayList<>(new HashSet<>(Arrays.stream(c).boxed().collect(Collectors.toList())));
        Collections.sort(newA);
        Collections.sort(newB);
        Collections.sort(newC);
        int ai = 0, bi = 0, ci = 0, ans = 0;
        while (bi < newB.size()) {
            while (ai < newA.size() && newA.get(ai) <= newB.get(bi)) {
                ai += 1;
            }
            while (ci < newC.size() && newC.get(ci) <= newB.get(bi)) {
                ci += 1;
            }
            ans += ai * ci;
            bi += 1;
        }
        return ans;
    }
}
