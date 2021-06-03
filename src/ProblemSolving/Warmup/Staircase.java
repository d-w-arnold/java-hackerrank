package ProblemSolving.Warmup;

import java.util.ArrayList;
import java.util.List;

/**
 * @author David W. Arnold
 * @version 03/06/2021
 */
public class Staircase
{
    /**
     * Staircase problem: https://www.hackerrank.com/challenges/staircase/problem
     *
     * @param n A single integer denoting the size of the staircase.
     */
    public static void staircase(int n)
    {
        List<String> stairs = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            stairs.add(padLeftSpaces(genStairsStep(i), n));
        }
        System.out.print(String.join("\n", stairs));
    }

    private static String genStairsStep(int n)
    {
        StringBuilder stairsStep = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stairsStep.append("#");
        }
        return stairsStep.toString();
    }

    private static String padLeftSpaces(String inputString, int length)
    {
        if (inputString.length() >= length) {
            return inputString;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length - inputString.length()) {
            sb.append(' ');
        }
        sb.append(inputString);
        return sb.toString();
    }
}
