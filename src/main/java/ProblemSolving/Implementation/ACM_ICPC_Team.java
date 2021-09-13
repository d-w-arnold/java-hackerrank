package ProblemSolving.Implementation;

import java.util.Arrays;
import java.util.List;

/**
 * @author David W. Arnold
 * @version 28/06/2021
 */
public class ACM_ICPC_Team
{
    /**
     * ACM ICPC Team problem: https://www.hackerrank.com/challenges/acm-icpc-team/problem
     *
     * @param topic A list of binary digit strings.
     * @return The maximum topics and the number of teams that know that many topics.
     */
    public static List<Integer> acmTeam(List<String> topic)
    {
        int max_covered = 0;
        int teams = 0;
        int matched_topics;
        for (int i = 0; i < topic.size(); i++) {
            for (int k = i + 1; k < topic.size(); k++) {
                matched_topics = 0;
                for (int j = 0; j < topic.get(0).length(); j++) {
                    if (topic.get(i).charAt(j) - '0' > 0 || topic.get(k).charAt(j) - '0' > 0) matched_topics++;
                }
                if (matched_topics == max_covered)
                    teams++;
                else if (matched_topics > max_covered) {
                    max_covered = matched_topics;
                    teams = 1;
                }
            }
        }
        return Arrays.asList(max_covered, teams);
    }
}
