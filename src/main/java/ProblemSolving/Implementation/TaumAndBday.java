package ProblemSolving.Implementation;

/**
 * @author David W. Arnold
 * @version 08/07/2021
 */
public class TaumAndBday
{
    /**
     * Taum and B'day problem: https://www.hackerrank.com/challenges/taum-and-bday/problem
     *
     * @param b  The number of black gifts.
     * @param w  The number of white gifts.
     * @param bc The cost of a black gift.
     * @param wc The cost of a white gift.
     * @param z  The cost to convert one color gift to the other color.
     * @return the minimum cost to purchase the gifts.
     */
    public static long taumBday(int b, int w, int bc, int wc, int z)
    {
        if (z < Math.abs(bc - wc)) { // 'z' can be used to purchase either black or white cheaper than they're cost
            if (bc > wc) { // 'z' can be used to purchase cheaper black, but buying white then converting to black
                return (long) b * wc + (long) b * z + (long) w * wc;
            } else { // 'z' can be used to purchase cheaper white, but buying black then converting to white
                return (long) b * bc + (long) w * z + (long) w * bc;
            }
        } else {
            return (long) b * bc + (long) w * wc;
        }
    }
}
