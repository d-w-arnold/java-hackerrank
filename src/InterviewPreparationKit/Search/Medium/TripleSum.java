package InterviewPreparationKit.Search.Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

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
        List<Integer> aList = new ArrayList<>();
        for (int i : a) {
            aList.add(i);
        }
        List<Integer> bList = new ArrayList<>();
        for (int i : b) {
            bList.add(i);
        }
        List<Integer> cList = new ArrayList<>();
        for (int i : c) {
            cList.add(i);
        }
        List<Integer> newA = new ArrayList<>(new HashSet<>(aList));
        List<Integer> newB = new ArrayList<>(new HashSet<>(bList));
        List<Integer> newC = new ArrayList<>(new HashSet<>(cList));
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
