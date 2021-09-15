package InterviewPreparationKit.LinkedLists;

/**
 * @author David W. Arnold
 * @version 15/09/2021
 */
public class FindMergePointOfTwoLists
{
    /**
     * Find Merge Point of Two Lists problem: https://www.hackerrank.com/challenges/find-the-merge-point-of-two-joined-linked-lists/problem
     *
     * @param head1 A reference to the head of the first list.
     * @param head2 A reference to the head of the second list.
     * @return The data value of the node where the lists merge.
     */
    public static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2)
    {
        return -2;
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

        public void insertNode(int nodeData)
        {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }
}
