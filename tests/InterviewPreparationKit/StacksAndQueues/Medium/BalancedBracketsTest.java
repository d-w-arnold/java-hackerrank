package InterviewPreparationKit.StacksAndQueues.Medium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 18/08/2021
 */
class BalancedBracketsTest
{

    @BeforeEach
    void setUp()
    {
    }

    @AfterEach
    void tearDown()
    {
    }

    @Test
    void isBalanced_1()
    {
        assertEquals("NO", BalancedBrackets.isBalanced("{[(])}"));
    }

    @Test
    void isBalanced_2()
    {
        assertEquals("YES", BalancedBrackets.isBalanced("{[()]}"));
    }

    @Test
    void isBalanced_3()
    {
        assertEquals("YES", BalancedBrackets.isBalanced("{{[[(())]]}}"));
    }
}