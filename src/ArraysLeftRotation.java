import java.util.ArrayList;
import java.util.List;

/**
 * @author David W. Arnold
 * @version 24/05/2021
 */
public class ArraysLeftRotation
{
    /**
     * Arrays: Left Rotation problem: https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem
     *
     * @param a The array to be rotated.
     * @param d The number of rotations.
     * @return The rotated array.
     */
    public static List<Integer> arraysLeftRotation(List<Integer> a, int d)
    {
        int rotations;
        if (a.size() - d == 0) {
            return a;
        } else if (d > a.size()) {
            rotations = a.size() % d;
        } else {
            rotations = d;
        }
        List<Integer> rotatedList = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            int pos = (i + rotations) % a.size();
            rotatedList.add(a.get(pos));
        }
        return rotatedList;
    }
}
