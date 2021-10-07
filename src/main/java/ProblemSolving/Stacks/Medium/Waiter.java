package ProblemSolving.Stacks.Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author David W. Arnold
 * @version 07/10/2021
 */
public class Waiter
{
    /**
     * Waiter problem: https://www.hackerrank.com/challenges/waiter/problem
     *
     * @param number The numbers on the plates.
     * @param q      The number of iterations.
     * @return The answers array.
     */
    public static List<Integer> waiter(List<Integer> number, int q)
    {
        LinkedList<Integer> answers = new LinkedList<>(), aStack = new LinkedList<>(), tmpAnswers;
        List<Integer> primes = getPrimes(number.size()), tmpNumbers;
        int prime, n;
        for (int i = 0; i < q; i++) {
            tmpAnswers = new LinkedList<>();
            tmpNumbers = i == 0 ? new ArrayList<>(number) : new ArrayList<>(aStack);
            aStack = new LinkedList<>();
            prime = primes.get(i);
            for (int j = tmpNumbers.size() - 1; j >= 0; j--) {
                n = tmpNumbers.get(j);
                if (n % prime == 0) tmpAnswers.addFirst(n);
                else aStack.add(n);
            }
            answers.addAll(tmpAnswers);
        }
        n = aStack.size();
        for (int i = 0; i < n; i++) {
            answers.add(aStack.removeLast());
        }
        return answers;
    }

    private static List<Integer> getPrimes(int n)
    {
        List<Integer> primes = new ArrayList<>(Collections.singletonList(2));
        int status = 1, num = 3;
        for (int i = 2; i <= n; ) {
            for (int j = 2; j <= Math.sqrt(num); j++) {
                if (num % j == 0) {
                    status = 0;
                    break;
                }
            }
            if (status != 0) {
                primes.add(num);
                i++;
            }
            status = 1;
            num++;
        }
        return primes;
    }
}
