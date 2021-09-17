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

    @Test
    void findMergeNode_3()
    {
        list1 = buildLinkedList(new int[]{9});
        list2 = buildLinkedList(new int[]{2, 6, 6, 2, 5, 3, 2, 2, 9, 3, 10, 4, 1, 5, 9, 9, 5, 1, 8, 1, 6, 6, 9, 6, 8, 10, 10, 8, 3, 8, 1, 7, 6, 7, 8, 10, 9, 9, 1, 9, 3, 3, 4, 3, 7, 4, 1, 3, 4, 1, 5, 1, 8, 5, 6, 5, 6, 7, 5, 1, 5, 5, 7, 2, 3, 4, 3, 3, 5, 5, 1, 7, 9});
        assertEquals(9, FindMergePointOfTwoLists.findMergeNode(list1.head, list2.head));
    }

    @Test
    void findMergeNode_4()
    {
        list1 = buildLinkedList(new int[]{10, 5, 8, 2, 9, 2, 2, 5, 2, 10, 1, 10, 6, 7, 6, 10, 7, 2, 7, 5, 3, 9, 8, 5, 2, 2, 10, 2, 1, 8, 8, 2, 5, 6, 3, 3, 9, 5, 10, 2, 6, 10, 1, 1, 8, 7, 3, 6, 8, 9, 10, 1, 9, 8, 7, 2, 1, 8, 6, 3, 6, 3, 4, 2, 10, 7, 4, 8, 3, 5, 10, 10, 5, 10, 2, 2, 6});
        list2 = buildLinkedList(new int[]{8, 6, 4, 7, 6, 5, 6, 4, 6, 9, 2, 1, 1, 9, 4, 5, 2, 3, 3, 5, 3, 7, 2, 2, 6, 6, 1, 7, 7, 9, 3, 6, 4, 6, 3, 1, 10, 10, 6, 8, 8, 9, 8, 1, 9, 3, 5, 10, 6, 9, 7, 8, 5, 8, 1, 10, 3, 3, 8, 1, 1, 10, 7, 6, 8, 1, 8, 9, 10, 4, 6, 8, 2, 4, 8, 1, 8, 4, 10, 3, 4, 8, 2, 8, 5, 4, 9, 7, 7, 6, 10, 9, 8, 6, 10, 5, 10, 2, 2, 6});
        assertEquals(10, FindMergePointOfTwoLists.findMergeNode(list1.head, list2.head));
    }

    @Test
    void findMergeNode_5()
    {
        list1 = buildLinkedList(new int[]{6, 2, 5, 5, 7, 3, 4, 9, 8, 3, 1, 5, 8, 2, 10, 1, 10, 3, 10, 4, 7, 8, 3, 3, 6, 2, 3, 5, 9, 7, 1, 4, 1, 7, 10});
        list2 = buildLinkedList(new int[]{1, 6, 7, 8, 10, 9, 3, 8, 1, 4, 10, 10, 6, 10, 5, 2, 9, 7, 6, 6, 10, 1, 10, 8, 9, 2, 3, 9, 1, 5, 10, 1, 10, 6, 9, 1, 7, 3, 8, 7, 6, 10, 8, 3, 1, 2, 7, 9, 1, 2, 7, 10, 4, 6, 10, 3, 10, 2, 3, 10, 6, 2, 10, 7, 10, 10, 8, 6, 2, 7, 4, 9, 6, 1, 2, 8, 4, 8, 7, 6, 1, 3, 8, 5, 10, 7, 7, 1, 10, 4, 9, 8, 3, 1, 5, 8, 2, 10, 1, 10, 3, 10, 4, 7, 8, 3, 3, 6, 2, 3, 5, 9, 7, 1, 4, 1, 7, 10});
        assertEquals(4, FindMergePointOfTwoLists.findMergeNode(list1.head, list2.head));
    }

    @Test
    void findMergeNode_6()
    {
        list1 = buildLinkedList(new int[]{6, 3, 2, 4, 2, 1, 1, 7, 5, 8, 10, 3, 5, 2, 6, 5, 7, 5, 3, 3, 6, 7, 10, 2, 6, 8, 10, 7, 7, 8, 8, 4, 10, 9, 8, 3, 2, 10, 9, 6, 7, 10, 10, 4, 1, 8, 8, 10, 2, 10, 2, 9, 8, 3, 10, 3, 10, 9, 1, 8, 9, 9, 2, 10, 9, 1, 3, 10, 10, 3, 7, 9, 3, 9, 4, 5, 6, 1, 4, 9, 2, 7, 8, 9, 9, 7, 3, 10, 8});
        list2 = buildLinkedList(new int[]{8, 8, 6, 1, 7, 4, 1, 1, 6, 2, 4, 2, 10, 8, 2, 3, 4, 7, 5, 10, 6, 8, 6, 5, 8, 7, 3, 3, 6, 10, 8, 5, 7, 3, 7, 6, 8, 9, 6, 3, 1, 1, 7, 2, 10, 8, 5, 4, 7, 1, 5, 4, 9, 10, 8, 6, 8, 10, 8, 6, 2, 7, 10, 8, 9, 9, 8});
        assertEquals(8, FindMergePointOfTwoLists.findMergeNode(list1.head, list2.head));
    }

    @Test
    void findMergeNode_7()
    {
        list1 = buildLinkedList(new int[]{7, 1, 1, 9, 3, 9, 1, 3, 7, 5, 8, 5, 5, 2, 8, 5, 3, 7, 3, 1, 6, 2, 6, 7, 9, 7, 7, 9, 5, 1, 7, 4, 3, 8, 2, 6, 6, 2, 8, 4, 8, 7, 10});
        list2 = buildLinkedList(new int[]{8, 7, 9, 2, 5, 1, 4, 1, 3, 1, 9, 3, 10, 7, 1, 6, 8, 8, 9, 2, 7, 3, 7, 4, 6, 6, 10, 4, 2, 9, 8, 1, 8, 8, 5, 2, 9, 8, 2, 3, 1, 3, 5, 10, 1, 5, 5, 8, 4, 6, 2, 10, 8, 8, 6, 8, 5, 5, 2, 8, 5, 3, 7, 3, 1, 6, 2, 6, 7, 9, 7, 7, 9, 5, 1, 7, 4, 3, 8, 2, 6, 6, 2, 8, 4, 8, 7, 10});
        assertEquals(8, FindMergePointOfTwoLists.findMergeNode(list1.head, list2.head));
    }

    @Test
    void findMergeNode_8()
    {
        list1 = buildLinkedList(new int[]{2, 10});
        list2 = buildLinkedList(new int[]{7, 9, 5, 9, 1, 10, 7, 7, 6, 9, 7, 2, 3, 2, 6, 3, 1, 10, 2, 4, 9, 3, 3, 8, 4, 2, 1, 4, 3, 10, 5, 1, 1, 2, 1, 1, 3, 7, 9, 10, 5, 5, 3, 9, 9, 9, 1, 9, 8, 4, 4, 8, 6, 9, 6, 10, 10, 8, 5, 4, 8, 1, 6, 10, 2, 6, 2, 6, 4, 10, 6, 10, 4, 10, 8, 4, 10, 10, 3, 9, 4, 8, 7, 9, 6, 4, 10, 7, 1, 4, 2, 10, 7, 7, 9, 10, 4, 10, 6, 9, 10});
        assertEquals(10, FindMergePointOfTwoLists.findMergeNode(list1.head, list2.head));
    }

    @Test
    void findMergeNode_9()
    {
        list1 = buildLinkedList(new int[]{8, 5, 2, 7, 10, 2, 7, 2, 10, 2, 2, 8, 2, 7, 1, 4, 4, 2, 9, 5, 1, 5, 4, 2, 5, 7, 1, 2, 6, 2, 4, 5, 8, 7, 2, 7, 10, 10, 1, 10, 3, 2, 7, 4, 10, 10, 7, 3, 1, 6, 10, 3, 2, 3, 4, 6, 1, 5, 7, 6, 8, 2, 3, 7, 1, 4, 5, 10, 5, 7, 1, 7, 10, 10, 2, 10, 9, 1, 4});
        list2 = buildLinkedList(new int[]{8, 3, 1, 9, 5, 7, 7, 6, 3, 5, 8, 7, 2, 7, 10, 10, 1, 10, 3, 2, 7, 4, 10, 10, 7, 3, 1, 6, 10, 3, 2, 3, 4, 6, 1, 5, 7, 6, 8, 2, 3, 7, 1, 4, 5, 10, 5, 7, 1, 7, 10, 10, 2, 10, 9, 1, 4});
        assertEquals(5, FindMergePointOfTwoLists.findMergeNode(list1.head, list2.head));
    }

    @Test
    void findMergeNode_10()
    {
        list1 = buildLinkedList(new int[]{10, 7, 5, 8, 9, 10, 2, 8, 4, 9, 9, 2, 10, 8, 4, 9, 8, 6, 3, 8, 3, 7, 10, 1, 4, 6, 7, 1, 8, 2, 3, 9, 10, 10, 6, 8, 1, 10, 7, 7, 10, 5, 8, 9, 4, 3, 10, 3, 8, 4, 10, 2, 10, 10, 3, 3, 5, 1, 3, 5, 4, 8, 3, 5, 9, 1, 4, 9, 2, 1, 7, 1, 7, 5, 1, 3, 9, 10, 5, 9, 5, 5, 10, 5, 4});
        list2 = buildLinkedList(new int[]{7, 10, 5, 2, 4, 10, 9, 9, 5, 7, 9, 8, 7, 10, 8, 4, 2, 7, 10, 2, 9, 8, 8, 9, 4, 3, 10, 3, 8, 4, 10, 2, 10, 10, 3, 3, 5, 1, 3, 5, 4, 8, 3, 5, 9, 1, 4, 9, 2, 1, 7, 1, 7, 5, 1, 3, 9, 10, 5, 9, 5, 5, 10, 5, 4});
        assertEquals(8, FindMergePointOfTwoLists.findMergeNode(list1.head, list2.head));
    }

    @Test
    void findMergeNode_11()
    {
        list1 = buildLinkedList(new int[]{8, 8, 9, 8, 4, 4, 1, 3, 6, 5, 4, 1, 7, 4, 9, 1, 2, 9, 10, 8, 8, 10, 3, 1});
        list2 = buildLinkedList(new int[]{2, 5, 6, 2, 10, 10, 1, 7, 9, 8, 3, 4, 1, 5, 9, 5, 8, 10, 3, 1, 10, 3, 2, 9, 3, 1, 8, 2, 6, 9, 7, 9, 5, 4, 2, 4, 3, 3, 2, 3, 10, 4, 7, 10, 8, 7, 7, 5, 8, 9, 7, 8, 4, 10, 8, 6, 1, 5, 9, 6, 5, 7, 4, 9, 10, 6, 3, 1});
        assertEquals(3, FindMergePointOfTwoLists.findMergeNode(list1.head, list2.head));
    }

    @Test
    void findMergeNode_12()
    {
        list1 = buildLinkedList(new int[]{10, 6});
        list2 = buildLinkedList(new int[]{1, 9, 3, 3, 7, 1, 1, 3, 9, 1, 10, 8, 4, 9, 5, 1, 1, 9, 1, 8, 4, 7, 4, 4, 8, 1, 8, 2, 10, 3, 6, 10, 1, 10, 2, 7, 10, 4, 2, 10, 5, 1, 7, 8, 1, 1, 1, 4, 2, 1, 1, 5, 10, 6, 10, 7, 6, 7, 8, 7, 9, 5, 7, 2, 4, 10, 10, 6, 4, 1, 5, 8, 3, 2, 7, 6});
        assertEquals(6, FindMergePointOfTwoLists.findMergeNode(list1.head, list2.head));
    }

    @Test
    void findMergeNode_13()
    {
        list1 = buildLinkedList(new int[]{7, 9, 5, 10, 1, 1, 9, 7, 1, 5, 2, 7, 3, 9, 8, 9, 7, 9, 5, 8, 8, 10, 3, 9, 6, 10, 1, 9, 9, 6, 3, 7, 6, 7, 6, 7, 8, 4, 3, 8, 9, 6, 6, 3});
        list2 = buildLinkedList(new int[]{3, 1, 2, 3, 5, 10, 1, 6, 2, 1, 2, 4, 3, 10, 4, 1, 2, 10, 6, 1, 6, 2, 8, 9, 7, 8, 4, 3, 8, 9, 6, 6, 3});
        assertEquals(7, FindMergePointOfTwoLists.findMergeNode(list1.head, list2.head));
    }

    @Test
    void findMergeNode_14()
    {
        list1 = buildLinkedList(new int[]{7, 2, 2, 1, 7, 7, 4, 9, 1, 8, 10, 1, 6, 3, 3, 9, 6, 8, 8, 9, 8, 2, 9, 5, 4, 6, 9, 1, 4, 4, 9, 3, 5, 10, 3, 2, 8, 6, 2, 9, 6, 1, 1, 1, 3, 4, 1, 1, 3, 10, 1, 10, 1, 9, 6, 4, 4, 4, 6, 10, 10, 4, 2, 4, 6, 6, 7, 3, 4, 8, 3, 9, 10, 4, 1, 5});
        list2 = buildLinkedList(new int[]{1, 5, 1, 10, 5, 2, 3, 6, 7, 8, 1, 3, 6, 10, 2, 1, 3, 7, 6, 9, 4, 1, 2, 3, 3, 2, 5, 8, 4, 9, 8, 6, 3, 10, 5, 9, 1, 9, 4, 10, 9, 5, 4, 4, 4, 5, 4, 9, 3, 2, 7, 8, 4, 10, 3, 8, 1, 7, 6, 4, 5, 5, 9, 9, 5, 5, 7, 7, 6, 3, 6, 4, 7, 1, 9, 2, 7, 4, 10, 10, 7, 8, 7, 10, 7, 9, 8, 7, 5, 5, 2, 1, 9, 2, 1, 3, 9, 8, 10, 4, 9, 1, 8, 10, 1, 6, 3, 3, 9, 6, 8, 8, 9, 8, 2, 9, 5, 4, 6, 9, 1, 4, 4, 9, 3, 5, 10, 3, 2, 8, 6, 2, 9, 6, 1, 1, 1, 3, 4, 1, 1, 3, 10, 1, 10, 1, 9, 6, 4, 4, 4, 6, 10, 10, 4, 2, 4, 6, 6, 7, 3, 4, 8, 3, 9, 10, 4, 1, 5});
        assertEquals(4, FindMergePointOfTwoLists.findMergeNode(list1.head, list2.head));
    }
}