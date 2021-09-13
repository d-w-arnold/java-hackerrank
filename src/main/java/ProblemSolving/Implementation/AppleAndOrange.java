package ProblemSolving.Implementation;

import java.util.List;

/**
 * @author David W. Arnold
 * @version 04/06/2021
 */
public class AppleAndOrange
{
    /**
     * Apple and Orange problem: https://www.hackerrank.com/challenges/apple-and-orange/problem
     *
     * @param s       Starting point of Sam's house location.
     * @param t       Ending location of Sam's house location.
     * @param a       Location of the Apple tree.
     * @param b       Location of the Orange tree.
     * @param apples  Distances at which each apple falls from the tree.
     * @param oranges Distances at which each orange falls from the tree.
     */
    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges)
    {
        int appleCount = countFruit(s, t, a, apples);
        int orangesCount = countFruit(s, t, b, oranges);
        System.out.printf("%d\n%d", appleCount, orangesCount);
    }

    private static int countFruit(int s, int t, int fruitTree, List<Integer> fruits)
    {
        int total = 0;
        for (int fruit : fruits) {
            int fruitLandingSpot = fruitTree + fruit;
            if (s <= fruitLandingSpot && fruitLandingSpot <= t) {
                total++;
            }
        }
        return total;
    }
}
