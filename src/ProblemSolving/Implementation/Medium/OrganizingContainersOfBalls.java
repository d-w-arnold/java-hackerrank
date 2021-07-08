package ProblemSolving.Implementation.Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author David W. Arnold
 * @version 08/07/2021
 */
public class OrganizingContainersOfBalls
{
    /**
     * Organizing Containers of Balls problem:
     *
     * @param container A two dimensional array of integers that represent the number of balls of each color in each container.
     * @return Either Possible or Impossible.
     */
    public static String organizingContainers(List<List<Integer>> container)
    {
        List<Integer> containerTotals = new ArrayList<>();
        List<Integer> indexTotals = new ArrayList<>(Collections.nCopies(container.get(0).size(), 0));
        for (List<Integer> c : container) {
            int tmpTotal = 0;
            for (int j = 0; j < c.size(); j++) {
                int tmp = c.get(j);
                tmpTotal += tmp;
                indexTotals.set(j, indexTotals.get(j) + tmp);
            }
            containerTotals.add(tmpTotal);
        }
        Collections.sort(containerTotals);
        Collections.sort(indexTotals);
        return containerTotals.equals(indexTotals) ? "Possible" : "Impossible";
    }
}
