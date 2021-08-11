package InterviewPreparationKit.GreedyAlgorithms.Medium;

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
        int total = 0;
        int numberOfPurchases = 0;
        int numberOfGroupPurchases = -1;
        for (int i = c.length - 1; i >= 0; i--) {
            if (numberOfPurchases % k == 0) numberOfGroupPurchases++;
            numberOfPurchases++;
            total += (numberOfGroupPurchases + 1) * c[i];
        }
        return total;
    }
}
