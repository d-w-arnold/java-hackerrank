package ProblemSolving.Warmup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author David W. Arnold
 * @version 04/06/2021
 */
public class BirthdayCakeCandles
{
    /**
     * Birthday Cake Candles problem: https://www.hackerrank.com/challenges/birthday-cake-candles/problem
     *
     * @param candles The candle heights.
     * @return The number of candles that are tallest.
     */
    public static int birthdayCakeCandles(List<Integer> candles)
    {
        int maximum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        boolean firstInt = true;
        for (int c : candles) {
            if (firstInt || c > maximum) {
                maximum = c;
                firstInt = false;
            }
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        return map.get(maximum);
    }
}
