package InterviewPreparationKit.Miscellaneous;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David W. Arnold
 * @version 24/09/2021
 */
class FlippingBitsTest
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
    void flippingBits_1()
    {
        assertEquals(4294967286L, FlippingBits.flippingBits(9));
    }

    @Test
    void flippingBits_2()
    {
        assertEquals(2147483648L, FlippingBits.flippingBits(2147483647));
    }

    @Test
    void flippingBits_3()
    {
        assertEquals(4294967294L, FlippingBits.flippingBits(1));
    }

    @Test
    void flippingBits_4()
    {
        assertEquals(4294967295L, FlippingBits.flippingBits(0));
    }

    @Test
    void flippingBits_5()
    {
        assertEquals(4294967291L, FlippingBits.flippingBits(4));
    }

    @Test
    void flippingBits_6()
    {
        assertEquals(4294843839L, FlippingBits.flippingBits(123456));
    }

    @Test
    void flippingBits_7()
    {
        assertEquals(4294843839L, FlippingBits.flippingBits(123456));
    }

    @Test
    void flippingBits_8()
    {
        assertEquals(3492223820L, FlippingBits.flippingBits(802743475));
    }

    @Test
    void flippingBits_9()
    {
        assertEquals(4259365872L, FlippingBits.flippingBits(35601423));
    }
}