package ProblemSolving.Implementation.Medium;

import java.util.*;

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
        List<Integer> results = new ArrayList<>();
        List<Integer> finalScores = new ArrayList<>(ranked);
        for (int playerScore : player) {
            finalScores.add(playerScore);
            finalScores.sort(Collections.reverseOrder());
            Set<Integer> set = new LinkedHashSet<>(finalScores);
            finalScores.clear();
            finalScores.addAll(set);
            results.add(finalScores.indexOf(playerScore) + 1);
        }
        return results;
    }
}
