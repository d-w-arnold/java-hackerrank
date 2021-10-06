package ProblemSolving.Stacks;

import java.util.*;

/**
 * @author David W. Arnold
 * @version 06/10/2021
 */
public class EqualStacks
{
    /**
     * Equal Stacks problem: https://www.hackerrank.com/challenges/equal-stacks/problem
     *
     * @param h1 The first array of heights.
     * @param h2 The second array of heights.
     * @param h3 The third array of heights.
     * @return The height of the stacks when they are equalized.
     */
    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3)
    {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        map.put(1, new HashSet<>());
        map.put(2, new HashSet<>());
        map.put(3, new HashSet<>());
        int index = 1, h1Sum = 0, h2Sum = 0, h3Sum = 0, h1Index, h2Index, h3Index, smallestList = -1;
        while (true) {
            h1Index = h1.size() - index;
            h2Index = h2.size() - index;
            h3Index = h3.size() - index;
            if (h1Index >= 0) {
                h1Sum += h1.get(h1Index);
                map.get(1).add(h1Sum);
            } else if (smallestList == -1) smallestList = 1;
            if (h2Index >= 0) {
                h2Sum += h2.get(h2Index);
                map.get(2).add(h2Sum);
            } else if (smallestList == -1) smallestList = 2;
            if (h3Index >= 0) {
                h3Sum += h3.get(h3Index);
                map.get(3).add(h3Sum);
            } else if (smallestList == -1) smallestList = 3;
            if (h1Index < 0 && h2Index < 0 && h3Index < 0) break;
            index++;
        }
        int ans = 0;
        outerLoop:
        for (int i : map.get(smallestList)) {
            for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
                if (entry.getKey() == smallestList) continue;
                if (!entry.getValue().contains(i)) continue outerLoop;
            }
            ans = Math.max(ans, i);
        }
        return ans;
    }
}
