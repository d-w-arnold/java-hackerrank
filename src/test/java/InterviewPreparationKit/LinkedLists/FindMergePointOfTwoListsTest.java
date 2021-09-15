package InterviewPreparationKit.LinkedLists;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 15/09/2021
 */
class FindMergePointOfTwoListsTest
{
    FindMergePointOfTwoLists.SinglyLinkedList list1;
    FindMergePointOfTwoLists.SinglyLinkedList list2;

    @BeforeEach
    void setUp()
    {
    }

    @AfterEach
    void tearDown()
    {
    }

    private FindMergePointOfTwoLists.SinglyLinkedList buildLinkedList(int[] array)
    {
        FindMergePointOfTwoLists.SinglyLinkedList linkedList = new FindMergePointOfTwoLists.SinglyLinkedList();
        for (int i : array) {
            linkedList.insertNode(i);
        }
        return linkedList;
    }

    @Test
    void findMergeNode_1()
    {
        list1 = buildLinkedList(new int[]{1, 2, 3});
        list2 = buildLinkedList(new int[]{1, 2, 3});
        assertEquals(2, FindMergePointOfTwoLists.findMergeNode(list1.head, list2.head));
    }

    @Test
    void findMergeNode_2()
    {
        list1 = buildLinkedList(new int[]{1, 2, 3});
        list2 = buildLinkedList(new int[]{1, 3});
        assertEquals(3, FindMergePointOfTwoLists.findMergeNode(list1.head, list2.head));
    }
}