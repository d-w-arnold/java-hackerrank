package InterviewPreparationKit.LinkedLists;

/**
 * @author David W. Arnold
 * @version 17/09/2021
 */
public class ReverseADoublyLinkedList
{
    /**
     * Reverse a doubly linked list problem: https://www.hackerrank.com/challenges/reverse-a-doubly-linked-list/problem
     *
     * @param llist A reference to the head of a DoublyLinkedList.
     * @return A reference to the head of the reversed list.
     */
    public static DoublyLinkedListNode reverse(DoublyLinkedListNode llist)
    {
        return new DoublyLinkedListNode(-2);
    }

    static class DoublyLinkedListNode
    {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData)
        {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList
    {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList()
        {
            this.head = null;
            this.tail = null;
        }

        public DoublyLinkedList(DoublyLinkedListNode d)
        {
            this.head = d;
            this.tail = d.next;
        }

        public void insertNode(int nodeData)
        {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }

        public boolean isIdentical(DoublyLinkedList listB)
        {
            DoublyLinkedListNode a = this.head, b = listB.head;
            while (a != null && b != null) {
                if (a.data != b.data) return false;
                a = a.next;
                b = b.next;
            }
            return (a == null && b == null);
        }
    }
}
