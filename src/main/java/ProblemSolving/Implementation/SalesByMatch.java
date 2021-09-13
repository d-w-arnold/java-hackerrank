package ProblemSolving.Implementation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author David W. Arnold
 * @version 07/06/2021
 */
public class SalesByMatch
{
    /**
     * Sales by Match problem: https://www.hackerrank.com/challenges/sock-merchant/problem
     *
     * @param n  The number of socks in the pile.
     * @param ar The colors of each sock.
     * @return The number of pairs.
     */
    public static int sockMerchant(int n, List<Integer> ar)
    {
        int pairs = 0;
        Map<Integer, Integer> socks = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int a = ar.get(i);
            if (socks.containsKey(a)) {
                int value = socks.get(a);
                if (value % 2 == 1) {
                    pairs++;
                }
                socks.put(a, value + 1);
            } else {
                socks.put(a, 1);
            }
        }
        return pairs;
    }
}
