package InterviewPreparationKit.LinkedLists;

/**
 * @author David W. Arnold
 * @version 07/09/2021
 */
public class InsertANodeAtASpecificPosition
{
    /**
     * Insert a node at a specific position in a linked list problem: https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list/problem
     *
     * @param llist    A SinglyLinkedListNode pointer to the head of the list.
     * @param data     An integer value to insert as data in your new node.
     * @param position An integer position to insert the new node, zero based indexing.
     * @return A reference to the head of the revised list.
     */
    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position)
    {
        if (llist == null) return null;
        SinglyLinkedListNode tmp = new SinglyLinkedListNode(data);
        if (position == 0) {
            tmp.next = llist;
            return tmp;
        }
        SinglyLinkedListNode p = llist;
        for (int i = 0; i < position - 1; i++) {
            p = p.next;
        }
        SinglyLinkedListNode next = p.next;
        p.next = tmp;
        tmp.next = next;
        return llist;
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

    static class SinglyLinkedList
    {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList()
        {
            this.head = null;
            this.tail = null;
        }

        public SinglyLinkedList(SinglyLinkedListNode s)
        {
            this.head = s;
            this.tail = s.next;
        }

        public void insertNode(int nodeData)
        {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);
            if (this.head == null) this.head = node;
            else this.tail.next = node;
            this.tail = node;
        }

        public boolean isIdentical(SinglyLinkedList listB)
        {
            SinglyLinkedListNode a = this.head, b = listB.head;
            while (a != null && b != null) {
                if (a.data != b.data) return false;
                a = a.next;
                b = b.next;
            }
            return (a == null && b == null);
        }
    }
}
