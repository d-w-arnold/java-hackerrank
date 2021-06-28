package ProblemSolving.Implementation;

import java.util.*;

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
        List<Integer[]> pairs = new ArrayList<>();
        Map<Integer[], List<Integer>> memSubjects = new LinkedHashMap<>();
        for (int i = 1; i <= topic.size(); i++) {
            for (int j = i + 1; j <= topic.size(); j++) {
                Integer[] pair = new Integer[]{i, j};
                pairs.add(pair);
                memSubjects.put(pair, new ArrayList<>());
            }
        }
        for (int i = 0; i < topic.get(0).length(); i++) {
            for (Integer[] pair : pairs) {
                if (topic.get(pair[0] - 1).charAt(i) == '1' || topic.get(pair[1] - 1).charAt(i) == '1') {
                    memSubjects.get(pair).add(i + 1);
                }
            }
        }
        int maxNumOfTopicsKnown = 0;
        int numOfTeams = 0;
        for (Map.Entry<Integer[], List<Integer>> entry : memSubjects.entrySet()) {
            int numOfTopics = entry.getValue().size();
            if (numOfTopics > maxNumOfTopicsKnown) {
                maxNumOfTopicsKnown = numOfTopics;
                numOfTeams = 1;
            } else if (numOfTopics == maxNumOfTopicsKnown) {
                numOfTeams++;
            }
        }
        return Arrays.asList(maxNumOfTopicsKnown, numOfTeams);
    }
}
