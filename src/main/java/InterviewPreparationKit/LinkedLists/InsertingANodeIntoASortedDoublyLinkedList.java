package InterviewPreparationKit.LinkedLists;

/**
 * @author David W. Arnold
 * @version 13/09/2021
 */
public class InsertingANodeIntoASortedDoublyLinkedList
{
    /**
     * Inserting a Node Into a Sorted Doubly Linked List problem: https://www.hackerrank.com/challenges/insert-a-node-into-a-sorted-doubly-linked-list/problem
     *
     * @param llist A reference to the head of a doubly-linked list.
     * @param data  An integer denoting the value of the data field for the DoublyLinkedListNode you must insert into the list.
     * @return A reference to the head of the list.
     */
    public static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode llist, int data)
    {
        DoublyLinkedListNode node = new DoublyLinkedListNode(data);
        if (llist == null) return node;
        else if (data <= llist.data) {
            llist.prev = node;
            node.next = llist;
            return node;
        } else {
            DoublyLinkedListNode ptr = sortedInsert(llist.next, data);
            ptr.prev = llist;
            llist.next = ptr;
            return llist;
        }
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
            if (this.head == null) this.head = node;
            else {
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
