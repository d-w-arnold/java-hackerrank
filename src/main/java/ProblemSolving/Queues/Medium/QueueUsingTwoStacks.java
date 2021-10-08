package ProblemSolving.Queues.Medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @author David W. Arnold
 * @version 08/10/2021
 */
public class QueueUsingTwoStacks
{
    /**
     * Queue using Two Stacks problem: https://www.hackerrank.com/challenges/queue-using-two-stacks/problem
     */
    public static void queueUsingTwoStacks()
    {
        Queue<Integer> queue = new Queue<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(reader.readLine());
            for (int i = 0; i < n; i++) {
                String[] strArray = reader.readLine().split(" ");
                int parseInt = Integer.parseInt(strArray[0]);
                if (parseInt == 1 && strArray.length == 2) queue.enqueue(Integer.parseInt(strArray[1]));
                else if (parseInt == 2) queue.dequeue();
                else if (parseInt == 3) System.out.println(queue.peek());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Queue<T>
    {
        private final Stack<T> NORMAL;
        private final Stack<T> REVERSED;

        /**
         * Queues: A Tale of Two Stacks problem: https://www.hackerrank.com/challenges/ctci-queue-using-two-stacks/problem
         */
        public Queue()
        {
            NORMAL = new Stack<>();
            REVERSED = new Stack<>();
        }

        /**
         * Enqueue an element into the end of the queue.
         *
         * @param item The item to be added to the end of the queue.
         */
        public void enqueue(T item)
        {
            NORMAL.push(item);
        }

        private void pour()
        {
            while (!NORMAL.isEmpty()) {
                REVERSED.push(NORMAL.pop());
            }
        }

        /**
         * Dequeue the element at the front of the queue.
         */
        public void dequeue()
        {
            if (REVERSED.isEmpty()) pour();
            REVERSED.pop();
        }

        /**
         * Print the element at the front of the queue.
         */
        public T peek()
        {
            if (REVERSED.isEmpty()) pour();
            return REVERSED.peek();
        }
    }
}
