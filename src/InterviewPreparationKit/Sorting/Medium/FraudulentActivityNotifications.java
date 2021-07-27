package InterviewPreparationKit.Sorting.Medium;

import java.util.ArrayList;
import java.util.Collections;
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
        int totalNotifications = 0;
        List<Integer> trailingExpenditures = new ArrayList<>();
        for (int i = 0; i < d; i++) {
            trailingExpenditures.add(expenditure.get(i));
        }
        for (int i = d; i < expenditure.size(); i++) {
            if (i > d) {
                trailingExpenditures.remove(0);
                trailingExpenditures.add(expenditure.get(i - 1));
            }
            if (expenditure.get(i) >= 2 * getMedian(trailingExpenditures)) totalNotifications++;
        }
        return totalNotifications;
    }

    private static double getMedian(List<Integer> list)
    {
        List<Integer> tmpList = new ArrayList<>(list);
        Collections.sort(tmpList);
        return tmpList.size() % 2 == 1 ?
                tmpList.get(tmpList.size() / 2) :
                (double) (tmpList.get(tmpList.size() / 2) + tmpList.get(tmpList.size() / 2 - 1)) / 2;
    }
}
