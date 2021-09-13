package InterviewPreparationKit.LinkedLists;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author David W. Arnold
 * @version 13/09/2021
 */
class InsertingANodeIntoASortedDoublyLinkedListTest
{
    InsertingANodeIntoASortedDoublyLinkedList.DoublyLinkedList expected;
    InsertingANodeIntoASortedDoublyLinkedList.DoublyLinkedList actual;

    @BeforeEach
    void setUp()
    {
    }

    @AfterEach
    void tearDown()
    {
    }

    private InsertingANodeIntoASortedDoublyLinkedList.DoublyLinkedList buildLinkedList(int[] array)
    {
        Arrays.sort(array);
        InsertingANodeIntoASortedDoublyLinkedList.DoublyLinkedList linkedList = new InsertingANodeIntoASortedDoublyLinkedList.DoublyLinkedList();
        for (int i : array) {
            linkedList.insertNode(i);
        }
        return linkedList;
    }

    @Test
    void sortedInsert_1()
    {
        expected = buildLinkedList(new int[]{1, 2, 3, 4});
        actual = new InsertingANodeIntoASortedDoublyLinkedList.DoublyLinkedList(
                InsertingANodeIntoASortedDoublyLinkedList.sortedInsert(
                        buildLinkedList(new int[]{1, 2, 4}).head, 3
                )
        );
        assertTrue(expected.isIdentical(actual));
    }

    @Test
    void sortedInsert_2()
    {
        expected = buildLinkedList(new int[]{1, 3, 4, 5, 10});
        actual = new InsertingANodeIntoASortedDoublyLinkedList.DoublyLinkedList(
                InsertingANodeIntoASortedDoublyLinkedList.sortedInsert(
                        buildLinkedList(new int[]{1, 3, 4, 10}).head, 5
                )
        );
        assertTrue(expected.isIdentical(actual));
    }

    @Test
    void sortedInsert_3()
    {
        expected = buildLinkedList(new int[]{1, 2, 3, 4});
        actual = new InsertingANodeIntoASortedDoublyLinkedList.DoublyLinkedList(
                InsertingANodeIntoASortedDoublyLinkedList.sortedInsert(
                        buildLinkedList(new int[]{2, 3, 4}).head, 1
                )
        );
        assertTrue(expected.isIdentical(actual));
    }

    @Test
    void sortedInsert_4()
    {
        expected = buildLinkedList(new int[]{1, 2, 3, 4});
        actual = new InsertingANodeIntoASortedDoublyLinkedList.DoublyLinkedList(
                InsertingANodeIntoASortedDoublyLinkedList.sortedInsert(
                        buildLinkedList(new int[]{1, 2, 3}).head, 4
                )
        );
        assertTrue(expected.isIdentical(actual));
    }
}