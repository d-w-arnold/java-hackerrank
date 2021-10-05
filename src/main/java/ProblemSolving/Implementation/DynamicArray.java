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
        List<List<Integer>> seqList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            seqList.add(new ArrayList<>());
        }
        int lastAnswer = 0;
        int seqNum;
        for (List<Integer> q : queries) {
            seqNum = (q.get(1) ^ lastAnswer) % n;
            if (q.get(0) == 1) seqList.get(seqNum).add(q.get(2));
            else if (q.get(0) == 2) {
                lastAnswer = seqList.get(seqNum).get(q.get(2));
                results.add(lastAnswer);
            } else return results;
        }
        return results;
    }
}
