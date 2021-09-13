package ProblemSolving.Implementation;

/**
 * @author David W. Arnold
 * @version 07/06/2021
 */
public class CatAndAMouse
{
    /**
     * Cat and a Mouse problem: https://www.hackerrank.com/challenges/cats-and-a-mouse/problem
     *
     * @param x Cat A's position.
     * @param y Cat B's position.
     * @param z Mouse C's position.
     * @return Either 'Cat A', 'Cat B', or 'Mouse C'.
     */
    public static String catAndMouse(int x, int y, int z)
    {
        int xToZ = Math.abs(x - z);
        int yToZ = Math.abs(y - z);
        if (xToZ < yToZ) {
            return "Cat A";
        } else if (xToZ > yToZ) {
            return "Cat B";
        } else {
            return "Mouse C";
        }
    }
}
