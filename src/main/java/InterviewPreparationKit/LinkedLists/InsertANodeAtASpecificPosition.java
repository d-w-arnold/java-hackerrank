package InterviewPreparationKit.LinkedLists;

/**
 * @author David W. Arnold
 * @version 07/09/2021
 */
public class InsertANodeAtASpecificPosition
{
    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position)
    {
        return new SinglyLinkedListNode(-2);
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

        @Override
        public boolean equals(Object o)
        {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SinglyLinkedListNode singlyLinkedListNode = (SinglyLinkedListNode) o;
            return data == singlyLinkedListNode.data && equals(next, singlyLinkedListNode.next);
        }

        private boolean equals(SinglyLinkedListNode s, SinglyLinkedListNode singlyLinkedList)
        {
            return s.data == singlyLinkedList.data && equals(s.next, singlyLinkedList.next);
        }

        @Override
        public int hashCode()
        {
            return 31 * data;
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

        public void insertNode(int nodeData)
        {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);
            if (this.head == null) this.head = node;
            else this.tail.next = node;
            this.tail = node;
        }
    }
}
