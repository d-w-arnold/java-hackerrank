package ProblemSolving.Implementation;

/**
 * @author David W. Arnold
 * @version 22/06/2021
 */
public class BeautifulDaysAtTheMovies
{
    /**
     * Beautiful Days at the Movies problem: https://www.hackerrank.com/challenges/beautiful-days-at-the-movies/problem
     *
     * @param i The starting day number.
     * @param j The ending day number.
     * @param k The divisor.
     * @return The number of beautiful days in the range.
     */
    public static int beautifulDays(int i, int j, int k)
    {
        int totalBeautifulDays = 0;
        for (int l = i; l <= j; l++) {
            if (isBeautifulDay(l, getReverse(l), k)) totalBeautifulDays++;
        }
        return totalBeautifulDays;
    }

    private static int getReverse(int n)
    {
        StringBuilder nStr = new StringBuilder(Integer.toString(n));
        nStr.reverse();
        return Integer.parseInt(nStr.toString());
    }

    private static boolean isBeautifulDay(int n, int nReverse, int k)
    {
        return (Math.abs(n - nReverse) % k) == 0;
    }
}
