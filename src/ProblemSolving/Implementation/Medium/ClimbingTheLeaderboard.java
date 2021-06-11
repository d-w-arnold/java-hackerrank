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
        List<Integer> playerRankResults = new ArrayList<>();
        Set<Integer> rankedSet = new HashSet<>();
        int j = 0;
        for (int i = player.size() - 1; i >= 0; ) {
            boolean lastPlace = true;
            int playerScore = player.get(i);
            for (; j < ranked.size(); j++) {
                int rankedScore = ranked.get(j);
                rankedSet.add(rankedScore);
                if (playerScore >= rankedScore) {
                    lastPlace = false;
                    playerRankResults.add(rankedSet.size());
                    i--;
                    playerScore = player.get(i);
                }
            }
            if (lastPlace) {
                playerRankResults.add(rankedSet.size() + 1);
                i--;
            }
        }
        playerRankResults.sort(Collections.reverseOrder());
        return playerRankResults;
    }
}
