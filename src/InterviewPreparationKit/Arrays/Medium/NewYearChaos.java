package InterviewPreparationKit.Arrays.Medium;

import java.util.List;

/**
 * @author David W. Arnold
 * @version 29/06/2021
 */
public class NewYearChaos
{
    /**
     * New Year Chaos problem: https://www.hackerrank.com/challenges/new-year-chaos/problem
     *
     * @param q The positions of the people after all bribes.
     */
    public static void minimumBribes(List<Integer> q)
    {
        int totalBribes = 0;
        for (int i = q.size() - 1; i >= 0; i--) {
            if (q.get(i) - (i + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            }
            for (int j = Math.max(0, q.get(i) - 2); j < i; j++) {
                if (q.get(j) > q.get(i)) totalBribes++;
            }
        }
        System.out.println(totalBribes);
    }
}
