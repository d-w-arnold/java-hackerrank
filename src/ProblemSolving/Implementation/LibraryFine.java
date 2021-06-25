package ProblemSolving.Implementation;

/**
 * @author David W. Arnold
 * @version 24/06/2021
 */
public class LibraryFine
{
    /**
     * Library Fine problem: https://www.hackerrank.com/challenges/library-fine/problem
     *
     * @param d1 Returned date day.
     * @param m1 Returned date month.
     * @param y1 Returned date year.
     * @param d2 Due date day.
     * @param m2 Due date month.
     * @param y2 Due date year.
     * @return The amount of the fine or 0 if there is none.
     */
    public static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2)
    {
        if (y1 < y2 || y1 == y2 && m1 < m2 || y1 == y2 && m1 == m2 && d1 <= d2) { // On or before due date
            return 0;
        } else if (d1 > d2 && m1 == m2 && y1 == y2) { // Late by day or more
            return 15 * (d1 - d2);
        } else if (m1 > m2 && y1 == y2) { // Late by month or more
            return 500 * (m1 - m2);
        } else { // Late by year or more
            return 10000;
        }
    }
}
