package InterviewPreparationKit.GreedyAlgorithms;

import java.util.Comparator;
import java.util.List;

/**
 * @author David W. Arnold
 * @version 10/08/2021
 */
public class LuckBalance
{
    /**
     * Luck Balance problem: https://www.hackerrank.com/challenges/luck-balance/problem
     *
     * @param k        The number of important contests Lena can lose.
     * @param contests A 2D array of integers where each contests[i] contains two integers that represent the luck balance and importance of the ith contest.
     * @return The maximum luck balance achievable.
     */
    public static int luckBalance(int k, List<List<Integer>> contests)
    {
        int totalLuck = 0, luck;
        contests.sort(((Comparator<List<Integer>>) (o1, o2) -> o1.get(1).equals(o2.get(1)) ? o1.get(0).compareTo(o2.get(0)) : o1.get(1) < o2.get(1) ? -1 : 1).reversed());
        for (List<Integer> entry : contests) {
            luck = entry.get(0);
            if (entry.get(1) == 0) totalLuck += luck;
            else if (k > 0) {
                totalLuck += luck;
                k -= 1;
            } else totalLuck -= luck;
        }
        return totalLuck;
    }
}
