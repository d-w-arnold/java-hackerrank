package ProblemSolving.Advanced.Medium;

import java.util.*;

/**
 * @author David W. Arnold
 * @version 06/10/2021
 */
public class FindMaximumIndexProduct
{
    /**
     * Find Maximum Index Product problem: https://www.hackerrank.com/challenges/find-maximum-index-product/problem
     *
     * @param arr An array of integers.
     * @return The maximum IndexProduct(i) among all i.
     */
    public static int solve(List<Integer> arr)
    {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.size(); i++) {
            if (map.containsKey(arr.get(i))) map.get(arr.get(i)).add(i);
            else map.put(arr.get(i), new ArrayList<>(Collections.singletonList(i)));
        }
        int left, right, maxAns = 0;
        for (int i = 1; i < arr.size() - 1; i++) {
            left = -1;
            right = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr.get(j) > arr.get(i)) left = j;
                if (left != -1) break;
            }
            for (int k = i + 1; k < arr.size(); k++) {
                if (arr.get(k) > arr.get(i)) right = k;
                if (right != -1) break;
            }
            maxAns = Math.max(maxAns, (left + 1) * (right + 1));
        }
        return maxAns;
    }
}
