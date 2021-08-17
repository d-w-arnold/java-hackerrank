package InterviewPreparationKit.Search.Medium;

import java.util.*;

/**
 * @author David W. Arnold
 * @version 17/08/2021
 */
public class MinimumTimeRequired
{
    /**
     * Minimum Time Required problem: https://www.hackerrank.com/challenges/minimum-time-required/problem
     *
     * @param machines An array of integers representing days to produce one item per machine.
     * @param goal     An integer, the number of items required to complete the order.
     * @return An integer representing the minimum number of days required to complete the order.
     */
    public static long minTime(long[] machines, long goal)
    {
        Map<Long, Long> map = new HashMap<>();
        for (long l : machines) {
            map.put(l, map.containsKey(l) ? map.get(l) + 1 : 1);
        }
        List<Long> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        int total = 0;
        int day = 0;
        while (total < goal) {
            day++;
            for (long l : list) {
                if (day % l == 0) {
                    total += map.get(l);
                } else if (l > day) {
                    break;
                }
            }
        }
        return day;
    }
}
