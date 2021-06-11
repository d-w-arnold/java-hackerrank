package ProblemSolving.Implementation.Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        List<Integer> playerRankResults = new ArrayList<>();
        Set<Integer> setRanks;
        for (int playerScore : player) {
            setRanks = new HashSet<>();
            boolean foundRankPosition = false;
            for (int rank : ranked) {
                if (rank > playerScore) {
                    setRanks.add(rank);
                } else {
                    playerRankResults.add(setRanks.size() + 1);
                    foundRankPosition = true;
                    break;
                }
            }
            if (!foundRankPosition) playerRankResults.add(setRanks.size() + 1);
        }
        return playerRankResults;
    }
}
