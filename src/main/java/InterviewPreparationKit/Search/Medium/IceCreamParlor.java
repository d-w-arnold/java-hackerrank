package InterviewPreparationKit.Search.Medium;

import java.util.*;

/**
 * @author David W. Arnold
 * @version 12/08/2021
 */
public class IceCreamParlor
{
    /**
     * Hash Tables: Ice Cream Parlor problem: https://www.hackerrank.com/challenges/ctci-ice-cream-parlor/problem
     *
     * @param cost  The prices for each flavor.
     * @param money The amount of money they have to spend.
     */
    public static void whatFlavors(List<Integer> cost, int money)
    {
        Map<Integer, List<Integer>> freqMap = new HashMap<>();
        int c, n;
        for (int i = 0; i < cost.size(); i++) {
            c = cost.get(i);
            n = money - c;
            if (freqMap.containsKey(n)) {
                System.out.println(freqMap.get(n).get(0) + " " + (i + 1));
                break;
            } else if (freqMap.containsKey(c)) freqMap.get(c).add(i + 1);
            else freqMap.put(c, new ArrayList<>(Collections.singletonList(i + 1)));
        }
    }
}
