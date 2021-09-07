package InterviewPreparationKit.LinkedLists;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 07/09/2021
 */
class InsertANodeAtASpecificPositionTest
{

    @BeforeEach
    void setUp()
    {
    }

    @AfterEach
    void tearDown()
    {
    }

    private InsertANodeAtASpecificPosition.SinglyLinkedList buildLinkedList(int[] array)
    {
        InsertANodeAtASpecificPosition.SinglyLinkedList linkedList = new InsertANodeAtASpecificPosition.SinglyLinkedList();
        for (int i : array) {
            linkedList.insertNode(i);
        }
        return linkedList;
    }

    @Test
    void insertNodeAtPosition_1()
    {
        assertEquals(
                buildLinkedList(new int[]{1, 2, 4, 3}).head,
                InsertANodeAtASpecificPosition.insertNodeAtPosition(
                        buildLinkedList(new int[]{1, 2, 3}).head,
                        4,
                        2
                )
        );
    }

    @Test
    void insertNodeAtPosition_2()
    {
        assertEquals(
                buildLinkedList(new int[]{16, 13, 1, 7}).head,
                InsertANodeAtASpecificPosition.insertNodeAtPosition(
                        buildLinkedList(new int[]{16, 13, 7}).head,
                        1,
                        2
                )
        );
    }

    @Test
    void insertNodeAtPosition_3()
    {
        assertEquals(
                buildLinkedList(new int[]{11, 9, 19, 20, 10, 4}).head,
                InsertANodeAtASpecificPosition.insertNodeAtPosition(
                        buildLinkedList(new int[]{11, 9, 19, 10, 4}).head,
                        20,
                        3
                )
        );
    }

    @Test
    void insertNodeAtPosition_4()
    {
        assertEquals(
                buildLinkedList(new int[]{1, 2, 3, 4, 5, 7, 6}).head,
                InsertANodeAtASpecificPosition.insertNodeAtPosition(
                        buildLinkedList(new int[]{1, 2, 3, 4, 5, 6}).head,
                        7,
                        5
                )
        );
    }
}