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
        SinglyLinkedListNode curr1;
        SinglyLinkedListNode curr2;
        if (head1.next != null && head2.next != null) {
            int ans = -1;
            curr1 = head1.next;
            curr2 = head2.next;
            boolean c1Conn = false;
            boolean c2Conn = false;
            while (true) {
                if (ans == -1) {
                    assert curr1 != null;
                    assert curr2 != null;
                    if (c1Conn == c2Conn && curr1.data == curr2.data) {
                        ans = curr1.data;
                        continue;
                    }
                    if (curr1.next == null && curr2.next == null) break;
                    if (curr1.next == null && !c1Conn) {
                        curr1 = head2;
                        c1Conn = true;
                    } else curr1 = curr1.next;
                    if (curr2.next == null && !c2Conn) {
                        curr2 = head1;
                        c2Conn = true;
                    } else curr2 = curr2.next;
                } else {
                    if (curr1.data != curr2.data) {
                        ans = -1;
                        continue;
                    } else if (curr1.next == null && curr2.next == null) break;
                    else if (curr1.next == null || curr2.next == null) {
                        ans = -1;
                        break;
                    }
                    curr1 = curr1.next;
                    curr2 = curr2.next;
                }
            }
            return ans;
        } else if (head1.next == null) {
            curr2 = head2;
            while (curr2 != null) {
                if (curr2.data == head1.data) return curr2.data;
                curr2 = curr2.next;
            }
        } else {
            curr1 = head1;
            while (curr1 != null) {
                if (curr1.data == head2.data) return curr1.data;
                curr1 = curr1.next;
            }
        }
        return -1;
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
