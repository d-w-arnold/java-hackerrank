package ProblemSolving.Implementation;

/**
 * @author David W. Arnold
 * @version 23/06/2021
 */
public class AppendAndDelete
{
    /**
     * Append and Delete problem: https://www.hackerrank.com/challenges/append-and-delete/problem
     *
     * @param s The initial string.
     * @param t The desired string.
     * @param k The exact number of operations that must be performed.
     * @return Either Yes or No.
     */
    public static String appendAndDelete(String s, String t, int k)
    {
        return "NULL";
    }

    private static String appendCharToEnd(String s, char c)
    {
        return s + c;
    }

    private static String deleteLastChar(String s)
    {
        return s.substring(0, s.length() - 1);
    }
}
