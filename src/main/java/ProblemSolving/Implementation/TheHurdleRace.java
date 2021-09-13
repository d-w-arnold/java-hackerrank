package ProblemSolving.Implementation;

import java.util.Collections;
import java.util.List;

/**
 * @author David W. Arnold
 * @version 22/06/2021
 */
public class TheHurdleRace
{
    /**
     * The Hurdle Race problem: https://www.hackerrank.com/challenges/the-hurdle-race/problem
     *
     * @param k      The height the character can jump naturally.
     * @param height The heights of each hurdle.
     * @return The minimum number of doses required, always 0 or more.
     */
    public static int hurdleRace(int k, List<Integer> height)
    {
        Collections.sort(height);
        int highestHurdle = height.get(height.size() - 1);
        if (highestHurdle > k) {
            return highestHurdle - k;
        } else {
            return 0;
        }
    }
}
