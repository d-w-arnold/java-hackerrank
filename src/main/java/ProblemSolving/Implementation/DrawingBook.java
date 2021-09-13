package ProblemSolving.Implementation;

/**
 * @author David W. Arnold
 * @version 07/06/2021
 */
public class DrawingBook
{
    /**
     * Drawing Book problem: https://www.hackerrank.com/challenges/drawing-book/problem
     *
     * @param n The number of pages in the book.
     * @param p The page number to turn to.
     * @return The minimum number of pages to turn.
     */
    public static int pageCount(int n, int p)
    {
        if (n > 1) {
            int minimumPagesTurned = 0;
            int tmpPagesTurned = 0;
            // Start turning from the front of the book.
            for (int i = 1; i < n; i++) {
                if (i % 2 == 0) {
                    tmpPagesTurned++;
                }
                if (i == p) {
                    minimumPagesTurned = tmpPagesTurned;
                    break;
                }
            }
            // Start turning from the end of the book
            tmpPagesTurned = 0;
            for (int i = n; i > 0; i--) {
                if (i == n && n % 2 == 1) {
                    continue;
                }
                if (i % 2 == 1) {
                    tmpPagesTurned++;
                }
                if (i == p && tmpPagesTurned < minimumPagesTurned) {
                    minimumPagesTurned = tmpPagesTurned;
                    break;
                }
                if (tmpPagesTurned > minimumPagesTurned) {
                    break;
                }
            }
            return minimumPagesTurned;
        }
        return 0;
    }
}
