package InterviewPreparationKit.Graphs.Medium;

import java.util.*;

/**
 * @author David W. Arnold
 * @version 31/08/2021
 */
public class RoadsAndLibraries
{
    /**
     * Roads and Libraries problem: https://www.hackerrank.com/challenges/torque-and-development/problem
     *
     * @param n      An integer, the number of cities.
     * @param c_lib  An integer, the cost to build a library.
     * @param c_road An integer, the cost to repair a road.
     * @param cities Each cities[i] contains two integers that represent cities that can be connected by a new road.
     * @return The minimal cost.
     */
    public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities)
    {
        if (c_lib < c_road) return (long) c_lib * n;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (List<Integer> c : cities) {
            int from = c.get(0);
            int to = c.get(1);
            if (map.containsKey(from)) map.get(from).add(to);
            else map.put(from, new LinkedList<>(Collections.singletonList(to)));
            if (map.containsKey(to)) map.get(to).add(from);
            else map.put(to, new LinkedList<>(Collections.singletonList(from)));
        }
        long total = 0;
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue;
        int mostPaths;
        while (visited.size() < n && !map.isEmpty()) {
            total += c_lib;
            mostPaths = getMostPaths(map);
            visited.add(mostPaths);
            queue = new LinkedList<>(map.get(mostPaths));
            map.remove(mostPaths);
            while (!queue.isEmpty()) {
                int poll = queue.remove();
                if (visited.contains(poll)) continue;
                total += c_road;
                visited.add(poll);
                for (int i : map.get(poll)) {
                    if (!visited.contains(i)) queue.add(i);
                }
                map.remove(poll);
            }
        }
        if (visited.size() < n) total += (long) (n - visited.size()) * c_lib;
        return total;
    }

    private static int getMostPaths(Map<Integer, List<Integer>> map)
    {
        int mostPaths = -1;
        int mostPathsSize = -1;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (mostPaths == -1 || mostPathsSize < entry.getValue().size()) {
                mostPaths = entry.getKey();
                mostPathsSize = entry.getValue().size();
            }
        }
        return mostPaths;
    }
}
