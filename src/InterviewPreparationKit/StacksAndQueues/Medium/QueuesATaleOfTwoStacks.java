package InterviewPreparationKit.StacksAndQueues.Medium;

import java.util.Stack;

/**
 * @author David W. Arnold
 * @version 18/08/2021
 */
public class QueuesATaleOfTwoStacks<T>
{
    private final Stack<T> NORMAL;
    private final Stack<T> REVERSED;

    /**
     * Queues: A Tale of Two Stacks problem: https://www.hackerrank.com/challenges/ctci-queue-using-two-stacks/problem
     */
    public QueuesATaleOfTwoStacks()
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
