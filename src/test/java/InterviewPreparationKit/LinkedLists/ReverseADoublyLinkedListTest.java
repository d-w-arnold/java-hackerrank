package InterviewPreparationKit.LinkedLists;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author David W. Arnold
 * @version 17/09/2021
 */
class ReverseADoublyLinkedListTest
{
    ReverseADoublyLinkedList.DoublyLinkedList expected;
    ReverseADoublyLinkedList.DoublyLinkedList actual;

    @BeforeEach
    void setUp()
    {
    }

    @AfterEach
    void tearDown()
    {
    }

    private ReverseADoublyLinkedList.DoublyLinkedList buildLinkedList(int[] array)
    {
        ReverseADoublyLinkedList.DoublyLinkedList linkedList = new ReverseADoublyLinkedList.DoublyLinkedList();
        for (int i : array) {
            linkedList.insertNode(i);
        }
        return linkedList;
    }

    @Test
    void reverse_1()
    {
        expected = buildLinkedList(new int[]{4, 3, 2, 1});
        actual = new ReverseADoublyLinkedList.DoublyLinkedList(ReverseADoublyLinkedList.reverse(
                buildLinkedList(new int[]{1, 2, 3, 4}).head)
        );
        assertTrue(expected.isIdentical(actual));
    }

    @Test
    void reverse_2()
    {
        expected = buildLinkedList(new int[]{4, 3, 2});
        actual = new ReverseADoublyLinkedList.DoublyLinkedList(ReverseADoublyLinkedList.reverse(
                buildLinkedList(new int[]{2, 3, 4}).head)
        );
        assertTrue(expected.isIdentical(actual));
    }

    @Test
    void reverse_3()
    {
        expected = buildLinkedList(new int[]{47, 35, 23, 20, 17});
        actual = new ReverseADoublyLinkedList.DoublyLinkedList(ReverseADoublyLinkedList.reverse(
                buildLinkedList(new int[]{17, 20, 23, 35, 47}).head)
        );
        assertTrue(expected.isIdentical(actual));
    }
}