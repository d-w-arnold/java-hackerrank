import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author David W. Arnold
 * @version 02/06/2021
 */
public class MarkAndToys
{
    /**
     * Mark and Toys problem: https://www.hackerrank.com/challenges/mark-and-toys/problem
     *
     * @param prices The toy prices.
     * @param k      Mark's budget.
     * @return The maximum number of toys
     */
    public static int maximumToys(List<Integer> prices, int k)
    {
        List<Integer> eligiblePrices = new ArrayList<>(prices);
        // Remove any toys which are too expensive
        eligiblePrices.removeIf(i -> i > k);
        // Java 7 Iterator:
//        Iterator<Integer> it = eligiblePrices.iterator();
//        while (it.hasNext()) {
//            int i = it.next();
//            if (i > k) {
//                it.remove();
//            }
//        }
        // Sort eligiblePrices
        Collections.sort(eligiblePrices);
        // Get maximum number of toys
        int count = 0;
        int runningTotal = 0;
        for (Integer eligiblePrice : eligiblePrices) {
            runningTotal += eligiblePrice;
            if (runningTotal > k) {
                return count;
            } else {
                count++;
            }
        }
        return count;
    }
}
