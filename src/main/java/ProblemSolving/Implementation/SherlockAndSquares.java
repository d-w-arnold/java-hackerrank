package ProblemSolving.Implementation;

/**
 * @author David W. Arnold
 * @version 24/06/2021
 */
public class SherlockAndSquares
{
    /**
     * Sherlock and Squares problem: https://www.hackerrank.com/challenges/sherlock-and-squares/problem
     *
     * @param a The lower range boundary.
     * @param b The upper range boundary.
     * @return The number of square integers in the range.
     */
    public static int squares(int a, int b)
    {
        int total = (getSqrtBase(b) - (getSqrtBase(a) + 1)) + 1;
        return isSquare(a) ? total + 1 : total;
    }

    private static boolean isSquare(int i)
    {
        return Math.sqrt(i) % 1 == 0;
    }

    private static int getSqrtBase(int a)
    {
        return (int) Math.sqrt(a);
    }
}
