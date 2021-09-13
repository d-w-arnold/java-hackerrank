package ProblemSolving.Implementation.Medium;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * @author David W. Arnold
 * @version 11/06/2021
 */
public class ClimbingTheLeaderboard
{
    /**
     * Climbing the Leaderboard problem: https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem
     *
     * @param ranked The leaderboard scores.
     * @param player The player's scores.
     * @return The player's rank after each new score.
     */
    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player)
    {
        List<Integer> rankedScores = new ArrayList<>(new LinkedHashSet<>(ranked));
        List<Integer> results = new ArrayList<>();
        int i = rankedScores.size() - 1;
        for (int playerScore : player) {
            boolean firstPlace = true;
            for (; i >= 0; i--) {
                if (rankedScores.get(i) > playerScore) {
                    // Not first place.
                    firstPlace = false;
                    if (i == rankedScores.size() - 1) {
                        // Last place.
                        results.add(rankedScores.size() + 1);
                    } else {
                        // Not last place.
                        results.add(i + 2);
                    }
                    break;
                }
            }
            if (firstPlace) {
                results.add(1);
            }
        }
        return results;
    }
}
