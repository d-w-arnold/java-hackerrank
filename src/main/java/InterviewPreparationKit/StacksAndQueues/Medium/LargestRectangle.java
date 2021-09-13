package InterviewPreparationKit.StacksAndQueues.Medium;

import java.util.List;

/**
 * @author David W. Arnold
 * @version 19/08/2021
 */
public class LargestRectangle
{
    /**
     * Largest Rectangle problem: https://www.hackerrank.com/challenges/largest-rectangle/problem
     *
     * @param h The building heights.
     * @return The area of the largest rectangle that can be formed within the bounds of consecutive buildings.
     */
    public static long largestRectangle(List<Integer> h)
    {
        int k;
        int largestRect = -1;
        int height;
        for (int i = 0; i < h.size(); i++) {
            k = 1;
            height = h.get(i);
            for (int j = i - 1; j >= 0; j--) {
                if (h.get(j) < height) break;
                k++;
            }
            for (int j = i + 1; j < h.size(); j++) {
                if (h.get(j) < height) break;
                k++;
            }
            largestRect = Math.max(largestRect, height * k);
        }
        return largestRect;
    }
}
