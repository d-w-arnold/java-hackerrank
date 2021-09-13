package ProblemSolving.Implementation;

/**
 * @author David W. Arnold
 * @version 07/06/2021
 */
public class ElectronicsShop
{
    /**
     * Electronics Shop problem: https://www.hackerrank.com/challenges/electronics-shop/problem
     *
     * @param keyboards The keyboard prices.
     * @param drives    The drive prices.
     * @param b         The budget.
     * @return The maximum that can be spent, or -1 if it is not possible to buy both items.
     */
    public static int getMoneySpent(int[] keyboards, int[] drives, int b)
    {
        int maxSpendable = -1;
        for (int k : keyboards) {
            for (int d : drives) {
                int tmpTotal = k + d;
                if (maxSpendable < tmpTotal && tmpTotal <= b) {
                    maxSpendable = tmpTotal;
                }
            }
        }
        return maxSpendable;
    }
}
