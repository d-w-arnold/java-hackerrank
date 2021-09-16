package InterviewPreparationKit.LinkedLists;

import java.util.ArrayList;
import java.util.List;

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
            curr1 = head1;
            curr2 = head2;
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            int ans = -1;
            while (true) {
                assert curr1 != null;
                list1.add(curr1.data);
                list2.add(curr2.data);
                if (ans == -1) {
                    if (list1.size() > 1 && list2.size() > 1 && list1.size() == list2.size()
                            && curr1.data == curr2.data) ans = curr1.data;
                    if (curr1.next == null && curr2.next == null) break;
                    curr1 = curr1.next == null ? head2 : curr1.next;
                    curr2 = curr2.next == null ? head1 : curr2.next;
                } else {
                    if (curr1.data != curr2.data) ans = -1;
                    else if (curr1.next == null && curr2.next == null) break;
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
