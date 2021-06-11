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
        List<Integer> results = new ArrayList<>();
        List<Integer> finalScores = new ArrayList<>(new LinkedHashSet<>(ranked));
        for (int playerScore : player) {
            boolean firstPlace = true;
            for (int i = finalScores.size() - 1; i >= 0; i--) {
                if (finalScores.get(i) > playerScore) {
                    // Not first place.
                    firstPlace = false;
                    if (i == finalScores.size() - 1) {
                        // Last place.
                        finalScores.add(playerScore);
                    } else {
                        // Not last place.
                        finalScores.add(i + 1, playerScore);
                    }
                    break;
                }
            }
            if (firstPlace) {
                finalScores.add(0, playerScore);
            }
            results.add(finalScores.indexOf(playerScore) + 1);
        }
        return results;
    }
}
