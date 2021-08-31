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
        Map<Long, List<Long>> colourCounts = new HashMap<>();
        for (int i = 0; i < graphNodes; i++) {
            long c = ids[i];
            if (colourCounts.containsKey(c)) colourCounts.get(c).add((long) (i + 1));
            else colourCounts.put(c, new ArrayList<>(Collections.singletonList((long) i + 1)));
        }
        if (colourCounts.containsKey((long) val) && colourCounts.get((long) val).size() == 1) return -1;
        Map<Long, List<Long>> paths = new HashMap<>();
        for (int i = 0; i < graphFrom.length; i++) {
            long from = graphFrom[i];
            long to = graphTo[i];
            if (paths.containsKey(from)) paths.get(from).add(to);
            else paths.put(from, new ArrayList<>(Collections.singletonList(to)));
            if (paths.containsKey(to)) paths.get(to).add(from);
            else paths.put(to, new ArrayList<>(Collections.singletonList(from)));
        }
        long mostPaths = -1;
        for (long i : colourCounts.get((long) val)) {
            mostPaths = mostPaths != -1 ? Math.max(mostPaths, paths.get(i).size()) : i;
        }
        Set<Long> colourNodes = new HashSet<>(colourCounts.get((long) val));
        colourNodes.remove(mostPaths);
        Map<String, Long> possiblePaths = new HashMap<>();
        Set<Long> visited = new HashSet<>(new ArrayList<>(Collections.singletonList(mostPaths)));
        Queue<Long[]> queue = new LinkedList<>();
        for (long l : paths.get(mostPaths)) {
            queue.add(new Long[]{l, 1L});
            visited.add(l);
        }
        while (!queue.isEmpty()) {
            Long[] entry = queue.remove();
            if (colourNodes.contains(entry[0])) possiblePaths.put(mostPaths + "-" + entry[0], entry[1]);
            for (long l : paths.get(entry[0])) {
                if (!visited.contains(l)) {
                    queue.add(new Long[]{l, entry[1] + 1});
                    visited.add(l);
                }
            }
        }
        long shortestPath = -1;
        for (Map.Entry<String, Long> entry : possiblePaths.entrySet()) {
            shortestPath = shortestPath != -1 ? Math.min(shortestPath, entry.getValue()) : entry.getValue();
        }
        return (int) shortestPath;
    }
}
