package InterviewPreparationKit.LinkedLists;

/**
 * @author David W. Arnold
 * @version 17/09/2021
 */
public class DetectACycle
{
    /**
     * Linked Lists: Detect a Cycle problem: https://www.hackerrank.com/challenges/ctci-linked-list-cycle/problem
     *
     * @param head A pointer to a Node object that points to the head of a linked list.
     * @return True if there is a cycle, False if there is not.
     */
    public boolean hasCycle(Node head)
    {
        if (head == null) return false;
        Node slow = head;
        Node fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    static class Node
    {
        int data;
        Node next;
    }
}
