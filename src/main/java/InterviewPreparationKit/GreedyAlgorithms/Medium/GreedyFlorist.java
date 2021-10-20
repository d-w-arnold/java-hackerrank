package InterviewPreparationKit.GreedyAlgorithms.Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author David W. Arnold
 * @version 11/08/2021
 */
public class GreedyFlorist
{
    /**
     * Greedy Florist problem: https://www.hackerrank.com/challenges/greedy-florist/problem
     *
     * @param k The number of friends.
     * @param c The original price of each flower.
     * @return The minimum cost to purchase all flowers.
     */
    public static int getMinimumCost(int k, int[] c)
    {
        List<Integer> newC = new ArrayList<>();
        for (int i : c) {
            newC.add(i);
        }
        Collections.sort(newC);
        int total = 0, numOfPurchases = 0, numOfGroupPurchases = -1;
        for (int i = newC.size() - 1; i >= 0; i--) {
            if (numOfPurchases % k == 0) numOfGroupPurchases++;
            numOfPurchases++;
            total += (numOfGroupPurchases + 1) * newC.get(i);
        }
        return total;
    }
}
