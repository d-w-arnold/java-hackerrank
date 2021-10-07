package ProblemSolving.Stacks.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @author David W. Arnold
 * @version 07/10/2021
 */
public class SimpleTextEditor
{
    /**
     * Simple Text Editor problem:
     */
    public static void simpleTextEditor()
    {
        String s = "";
        String[] input;
        Stack<String> oldS = new Stack<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(reader.readLine());
            for (int i = 1; i <= n; i++) {
                input = reader.readLine().split(" ");
                switch (Integer.parseInt(input[0])) {
                    case 1:
                        oldS.add(s);
                        s += input[1];
                        break;
                    case 2:
                        oldS.add(s);
                        s = s.substring(0, s.length() - Integer.parseInt(input[1]));
                        break;
                    case 3:
                        System.out.println(s.charAt(Integer.parseInt(input[1]) - 1));
                        break;
                    case 4:
                        if (!oldS.isEmpty()) s = oldS.pop();
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
