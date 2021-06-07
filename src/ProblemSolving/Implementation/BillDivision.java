package ProblemSolving.Implementation;

import java.util.List;

/**
 * @author David W. Arnold
 * @version 07/06/2021
 */
public class BillDivision
{
    /**
     * Bill Division problem: https://www.hackerrank.com/challenges/bon-appetit/problem
     *
     * @param bill An array of integers representing the cost of each item ordered.
     * @param k    An integer representing the zero-based index of the item Anna doesn't eat.
     * @param b    The amount of money that Anna contributed to the bill.
     */
    public static void bonAppetit(List<Integer> bill, int k, int b)
    {
        int totalExcludingItemNotEaten = 0;
        for (int i = 0; i < bill.size(); i++) {
            if (i != k) {
                totalExcludingItemNotEaten += bill.get(i);
            }
        }
        int diff = b - (totalExcludingItemNotEaten / 2);
        if (diff == 0) {
            System.out.println("Bon Appetit");
        } else {
            System.out.println(diff);
        }
    }
}
