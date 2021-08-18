package InterviewPreparationKit.StacksAndQueues.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author David W. Arnold
 * @version 18/08/2021
 */
public class BalancedBrackets
{
    /**
     * Balanced Brackets problem: https://www.hackerrank.com/challenges/balanced-brackets/problem
     *
     * @param s A string of brackets.
     * @return Either YES or NO.
     */
    public static String isBalanced(String s)
    {
        Map<Character, Character> mappings = new HashMap<>();
        mappings.put('(', ')');
        mappings.put('{', '}');
        mappings.put('[', ']');
        List<Character> stack = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.add(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty() || mappings.get(stack.get(stack.size() - 1)) != c) return "NO";
                stack.remove(stack.size() - 1);
            }
        }
        return "YES";
    }
}
