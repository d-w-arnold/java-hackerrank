package ProblemSolving.Implementation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author David W. Arnold
 * @version 05/10/2021
 */
public class DynamicArray
{
    /**
     * Dynamic Array problem: https://www.hackerrank.com/challenges/dynamic-array/problem
     *
     * @param n       The number of empty arrays to initialize in arr.
     * @param queries Query strings that contain 3 space-separated integers.
     * @return The results of each type 2 query in the order they are presented.
     */
    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries)
    {
        List<Integer> results = new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            lists.add(new ArrayList<>());
        }
        int lastAns = 0;
        for (List<Integer> q : queries) {
            if (q.get(0) == 1) lists.get((q.get(1) ^ lastAns) % n).add(q.get(2));
            else {
                List<Integer> l = lists.get((q.get(1) ^ lastAns) % n);
                lastAns = l.get(q.get(2) % l.size());
                results.add(lastAns);
            }
        }
        return results;
    }
}
