package ProblemSolving.Queues.Medium;

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
        System.out.println("NULL");
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
