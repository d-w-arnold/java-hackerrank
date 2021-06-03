import java.util.List;

/**
 * @author David W. Arnold
 * @version 24/05/2021
 */
public class JumpingOnTheClouds
{
    /**
     * Jumping on the Clouds problem: https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem
     *
     * @param c The list of binary numbers denoting good and bad clouds.
     * @return The smallest number of hops.
     */
    public static int jumpingOnClouds(List<Integer> c)
    {
        int goodCloud = 0;
        int badCloud = 1;
        int[] validMoves = {1, 2};
        int index = 0;
        int hops = 0;
        while (index != (c.size() - 1)) {
            for (int i = validMoves.length - 1; i >= 0; i--) {
                int move = validMoves[i];
                if ((index + move) < c.size() && c.get(index + move) != badCloud && c.get(index + move) == goodCloud) {
                    index += move;
                    hops++;
                    break;
                }
            }
        }
        return hops;
    }
}
