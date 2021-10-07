package ProblemSolving.DisjointSet.Medium;

import java.util.*;

/**
 * @author David W. Arnold
 * @version 07/10/2021
 */
public class ComponentsInAGraph
{
    /**
     * Components in a graph problem: https://www.hackerrank.com/challenges/components-in-graph/problem
     *
     * @param gb A 2-d array of integers that represent node ends of graph edges.
     * @return An array with 2 integers, the smallest and largest component sizes.
     */
    public static List<Integer> componentsInGraph(List<List<Integer>> gb)
    {
        List<Set<Integer>> components = new ArrayList<>();
        int index, indexA, indexB;
        for (List<Integer> pair : gb) {
            if (!components.isEmpty()) {
                index = 0;
                indexA = -1;
                indexB = -1;
                for (Set<Integer> component : components) {
                    if (indexA != -1 && indexB != -1) break;
                    if (indexA == -1 && component.contains(pair.get(0))) indexA = index;
                    if (indexB == -1 && component.contains(pair.get(1))) indexB = index;
                    index++;
                }
                if (indexA != indexB && indexA != -1 && indexB != -1) {
                    components.get(indexA).addAll(components.get(indexB));
                    components.remove(indexB);
                } else if (indexA != -1) components.get(indexA).addAll(pair);
                else if (indexB != -1) components.get(indexB).addAll(pair);
                else components.add(new HashSet<>(pair));
            } else components.add(new HashSet<>(pair));
        }
        int minSize = Integer.MAX_VALUE, maxSize = 0;
        for (Set<Integer> component : components) {
            minSize = Math.min(minSize, component.size());
            maxSize = Math.max(maxSize, component.size());
        }
        return Arrays.asList(minSize, maxSize);
    }
}
