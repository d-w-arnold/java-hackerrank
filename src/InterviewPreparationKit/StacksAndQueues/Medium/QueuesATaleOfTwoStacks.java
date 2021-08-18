package InterviewPreparationKit.StacksAndQueues.Medium;

import java.util.ArrayList;

/**
 * @author David W. Arnold
 * @version 18/08/2021
 */
public class QueuesATaleOfTwoStacks<T>
{
    private final ArrayList<T> LEFT_STACK;
    private final ArrayList<T> RIGHT_STACK;
    private int lastMethodType;

    /**
     * Queues: A Tale of Two Stacks problem: https://www.hackerrank.com/challenges/ctci-queue-using-two-stacks/problem
     */
    public QueuesATaleOfTwoStacks()
    {
        this.LEFT_STACK = new ArrayList<>();
        this.RIGHT_STACK = new ArrayList<>();
        this.lastMethodType = -1;
    }

    /**
     * Enqueue an element into the end of the queue.
     *
     * @param item The item to be added to the end of the queue.
     */
    public void enqueue(T item)
    {
        if (lastMethodType == 2 || lastMethodType == 3) unShuffleStacks();
        LEFT_STACK.add(item);
        lastMethodType = 1;
    }

    /**
     * Dequeue the element at the front of the queue.
     */
    public void dequeue()
    {
        if (lastMethodType == 1) shuffleStacks();
        RIGHT_STACK.remove(RIGHT_STACK.size() - 1);
        lastMethodType = 2;
    }

    /**
     * Print the element at the front of the queue.
     */
    public T peek()
    {
        if (lastMethodType == 1) shuffleStacks();
        lastMethodType = 3;
        return RIGHT_STACK.get(RIGHT_STACK.size() - 1);
    }

    /**
     * Reverses order: LEFT_STACK -> RIGHT_STACK.
     * Sets up for either a dequeue() or peek() method.
     */
    private void shuffleStacks()
    {
        for (int i = LEFT_STACK.size() - 1; i >= 0; i--) {
            T item = LEFT_STACK.remove(i);
            RIGHT_STACK.add(item);
        }
    }

    /**
     * Reverses order: LEFT_STACK <- RIGHT_STACK.
     * Sets up for an enqueue() method.
     */
    private void unShuffleStacks()
    {
        for (int i = RIGHT_STACK.size() - 1; i >= 0; i--) {
            T item = RIGHT_STACK.remove(i);
            LEFT_STACK.add(item);
        }
    }
}
