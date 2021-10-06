package ProblemSolving.LinkedLists.Medium;

/**
 * @author David W. Arnold
 * @version 06/10/2021
 */
public class CycleDetection
{
    /**
     * Cycle Detection problem: https://www.hackerrank.com/challenges/detect-whether-a-linked-list-contains-a-cycle/problem
     *
     * @param head A reference to the head of the list.
     * @return True if there is a cycle or False if there is not.
     */
    public static boolean hasCycle(SinglyLinkedListNode head)
    {
        return false;
    }

    static class SinglyLinkedListNode
    {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData)
        {
            this.data = nodeData;
            this.next = null;
        }
    }
}
