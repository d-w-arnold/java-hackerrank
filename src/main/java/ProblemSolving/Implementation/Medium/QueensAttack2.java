package ProblemSolving.Implementation.Medium;

import java.util.List;

/**
 * @author David W. Arnold
 * @version 28/06/2021
 */
public class QueensAttack2
{
    /**
     * Queen's Attack II problem: https://www.hackerrank.com/challenges/queens-attack-2/problem
     *
     * @param n         The number of rows and columns in the board.
     * @param k         The number of obstacles on the board.
     * @param r_q       The row number of the queen's position.
     * @param c_q       The column number of the queen's position.
     * @param obstacles Each element is an array of 2 integers, the row and column of an obstacle.
     * @return The number of squares the queen can attack.
     */
    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles)
    {
        int squaresQueenCanAttack = 0;
        int r_RightObs = -1;
        int c_RightObs = -1;
        int r_BelowRightObs = -1;
        int c_BelowRightObs = -1;
        int r_BelowObs = -1;
        int c_BelowObs = -1;
        int r_BelowLeftObs = -1;
        int c_BelowLeftObs = -1;
        int r_LeftObs = -1;
        int c_LeftObs = -1;
        int r_AboveLeftObs = -1;
        int c_AboveLeftObs = -1;
        int r_AboveObs = -1;
        int c_AboveObs = -1;
        int r_AboveRightObs = -1;
        int c_AboveRightObs = -1;
        for (int i = 0; i < k; i++) { // Find the closest obstacles in each direction
            int r_obs = obstacles.get(i).get(0);
            int c_obs = obstacles.get(i).get(1);
            // Above
            if ((r_obs < r_AboveObs || r_AboveObs == -1) && r_obs > r_q && c_obs == c_q) {
                r_AboveObs = r_obs;
                c_AboveObs = c_obs;
            }
            // Below
            if ((r_obs > r_BelowObs || r_BelowObs == -1) && r_obs < r_q && c_obs == c_q) {
                r_BelowObs = r_obs;
                c_BelowObs = c_obs;
            }
            // Left
            if ((c_obs > c_LeftObs || r_LeftObs == -1) && c_obs < c_q && r_obs == r_q) {
                r_LeftObs = r_obs;
                c_LeftObs = c_obs;
            }
            // Right
            if ((c_obs < c_RightObs || r_RightObs == -1) && c_obs > c_q && r_obs == r_q) {
                r_RightObs = r_obs;
                c_RightObs = c_obs;
            }
            // Above Left
            if (c_q - c_obs == r_obs - r_q && c_obs < c_q && r_obs > r_q && ((r_obs < r_AboveLeftObs && c_obs > c_AboveLeftObs) || r_AboveLeftObs == -1)) {
                r_AboveLeftObs = r_obs;
                c_AboveLeftObs = c_obs;
            }
            // Above Right
            if (r_obs - r_q == c_obs - c_q && c_obs > c_q && r_obs > r_q && ((r_obs < r_AboveRightObs && c_obs < c_AboveRightObs) || r_AboveRightObs == -1)) {
                r_AboveRightObs = r_obs;
                c_AboveRightObs = c_obs;
            }
            // Below Left
            if (r_q - r_obs == c_q - c_obs && c_obs < c_q && r_obs < r_q && ((r_obs > r_BelowLeftObs && c_obs > c_BelowLeftObs) || r_BelowLeftObs == -1)) {
                r_BelowLeftObs = r_obs;
                c_BelowLeftObs = c_obs;
            }
            // Below Right
            if (r_q - r_obs == c_obs - c_q && c_obs > c_q && r_obs < r_q && ((r_obs > r_BelowRightObs && c_obs < c_BelowRightObs) || r_BelowRightObs == -1)) {
                r_BelowRightObs = r_obs;
                c_BelowRightObs = c_obs;
            }
        }
        squaresQueenCanAttack += (r_AboveObs != -1) ? (r_AboveObs - r_q - 1) : n - r_q; // Squares the queen can attack above
        squaresQueenCanAttack += (r_BelowObs != -1) ? (r_q - r_BelowObs - 1) : r_q - 1; // Squares the queen can attack below
        squaresQueenCanAttack += (c_LeftObs != -1) ? (c_q - c_LeftObs - 1) : c_q - 1; // Squares the queen can attack to the left
        squaresQueenCanAttack += (c_RightObs != -1) ? (c_RightObs - c_q - 1) : n - c_q; // Squares the queen can attack to the right
        squaresQueenCanAttack += (c_AboveLeftObs != -1) ? (c_q - c_AboveLeftObs - 1) : Math.min(c_q - 1, n - r_q); // Squares the queen can attack above and left
        squaresQueenCanAttack += (r_AboveRightObs != -1) ? (c_AboveRightObs - c_q - 1) : Math.min(n - c_q, n - r_q); // Squares the queen can attack above and right
        squaresQueenCanAttack += (r_BelowLeftObs != -1) ? (c_q - c_BelowLeftObs - 1) : Math.min(c_q - 1, r_q - 1); // Squares the queen can attack below and left
        squaresQueenCanAttack += (c_BelowRightObs != -1) ? (c_BelowRightObs - c_q - 1) : Math.min(n - c_q, r_q - 1); // Squares the queen can attack below and right
        return squaresQueenCanAttack;
    }
}
