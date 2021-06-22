package ProblemSolving.Implementation;

import java.util.List;

/**
 * @author David W. Arnold
 * @version 22/06/2021
 */
public class AngryProfessor
{
    /**
     * Angry Professor problem: https://www.hackerrank.com/challenges/angry-professor/problem
     *
     * @param k The threshold number of students.
     * @param a The arrival times of the students.
     * @return Either YES or NO.
     */
    public static String angryProfessor(int k, List<Integer> a)
    {
        int totalArrivedOnTime = 0;
        for (int arrivalTime : a) {
            if (arrivalTime <= 0) {
                totalArrivedOnTime++;
            }
        }
        if (totalArrivedOnTime >= k) {
            return "NO";
        } else {
            return "YES";
        }
    }
}
