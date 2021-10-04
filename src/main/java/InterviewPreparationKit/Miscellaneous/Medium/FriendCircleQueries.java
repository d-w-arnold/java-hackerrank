package InterviewPreparationKit.Miscellaneous.Medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author David W. Arnold
 * @version 04/10/2021
 */
public class FriendCircleQueries
{
    /**
     * Friend Circle Queries problem: https://www.hackerrank.com/challenges/friend-circle-queries/problem
     *
     * @param queries An array of integer arrays, each with two elements indicating a new friendship.
     * @return Return an integer array of size q, whose value at index i is the size of the largest group present after processing the ith query.
     */
    public static int[] maxCircle(int[][] queries)
    {
        int[] ans = new int[queries.length];
        List<Set<Integer>> friendGroups = new ArrayList<>();
        int index = 0, handShakeLeft, handShakeRight, leftFound, rightFound, max;
        for (int[] handShake : queries) {
            handShakeLeft = handShake[0];
            handShakeRight = handShake[1];
            leftFound = -1;
            rightFound = -1;
            for (int i = 0; i < friendGroups.size(); i++) {
                Set<Integer> tmpFriendGroup = friendGroups.get(i);
                if (tmpFriendGroup.contains(handShakeLeft) && tmpFriendGroup.contains(handShakeRight)) {
                    leftFound = i;
                    rightFound = i;
                    break;
                } else if (tmpFriendGroup.contains(handShakeLeft)) leftFound = i;
                else if (tmpFriendGroup.contains(handShakeRight)) rightFound = i;
                if (leftFound != -1 && rightFound != -1) break;
            }
            if (leftFound == -1 && rightFound == -1)
                friendGroups.add(new HashSet<>(Arrays.stream(handShake).boxed().collect(Collectors.toList())));
            else if (leftFound == -1) friendGroups.get(rightFound).add(handShakeLeft);
            else if (rightFound == -1) friendGroups.get(leftFound).add(handShakeRight);
            else {
                friendGroups.get(leftFound).addAll(friendGroups.get(rightFound));
                friendGroups.remove(rightFound);
            }
            max = -1;
            for (var friendGroup : friendGroups) {
                max = Math.max(max, friendGroup.size());
            }
            ans[index] = max;
            index++;
        }
        return ans;
    }
}
