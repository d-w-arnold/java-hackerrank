package InterviewPreparationKit.Sorting.Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author David W. Arnold
 * @version 27/07/2021
 */
public class FraudulentActivityNotifications
{
    /**
     * Fraudulent Activity Notifications problem: https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem
     *
     * @param expenditure Daily expenditures.
     * @param d           Days for median spending.
     * @return The number of notices sent.
     */
    public static int activityNotifications(List<Integer> expenditure, int d)
    {
        int[] freq = new int[201];
        int totalNotifications = 0;
        for (int i = 0; i < d; i++) {
            freq[expenditure.get(i)] += 1;
        }
        for (int i = d; i < expenditure.size(); i++) {
            int v = expenditure.get(i);
            if (v >= getLimit(freq, d)) totalNotifications += 1;
            freq[v] += 1;
            freq[expenditure.get(i - d)] -= 1;
        }
        return totalNotifications;
    }

    private static int getLimit(int[] f, int d)
    {
        int count = 0;
        List<Integer> m = new ArrayList<>();
        for (int i = 0; i < f.length; i++) {
            count += f[i];
            if (m.isEmpty() && (d / 2) <= count) m.add(i);
            if ((d / 2 + 1) <= count) {
                m.add(i);
                break;
            }
        }
        return d % 2 == 1 ? m.get(m.size() - 1) * 2 : (int) m.stream().mapToDouble(a -> a).sum();
    }
}
