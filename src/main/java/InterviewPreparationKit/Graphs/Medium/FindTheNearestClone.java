package InterviewPreparationKit.Graphs.Medium;

import java.util.*;

/**
 * @author David W. Arnold
 * @version 27/08/2021
 */
public class FindTheNearestClone
{
    /**
     * Find the nearest clone problem: https://www.hackerrank.com/challenges/find-the-nearest-clone/problem
     *
     * @param graphNodes An integer, the number of nodes.
     * @param graphFrom  An array of integers, the start nodes for each edge.
     * @param graphTo    An array of integers, the end nodes for each edge.
     * @param ids        An array of integers, the color id per node.
     * @param val        An integer, the id of the color to match.
     * @return An integer representing the length of the shortest path between two nodes of the same color, or -1 if it is not possible.
     */
    public static int findShortest(int graphNodes, int[] graphFrom, int[] graphTo, long[] ids, int val)
    {
        List<List<Integer>> map = new ArrayList<>();
        HashMap<Integer, Integer> distances = new HashMap<>();
        for (int i = 0; i < graphNodes; i++) {
            map.add(new LinkedList<>());
        }
        for (int i = 0; i < graphFrom.length; i++) {
            map.get(graphFrom[i] - 1).add(graphTo[i]);
            map.get(graphTo[i] - 1).add(graphFrom[i]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == val) {
                queue.add(i + 1);
                distances.put(i + 1, 0);
            }
        }
        if (queue.size() < 2) return -1;
        HashSet<Integer> seen = new HashSet<>();
        while (queue.size() > 0) {
            int entry = queue.poll();
            seen.add(entry);
            for (int a : map.get(entry - 1)) {
                if (distances.containsKey(a) && !seen.contains(a)) return distances.get(a) + distances.get(entry) + 1;
                else {
                    queue.add(a);
                    distances.put(a, distances.get(entry) + 1);
                }
            }
        }
        return -1;
    }
}
