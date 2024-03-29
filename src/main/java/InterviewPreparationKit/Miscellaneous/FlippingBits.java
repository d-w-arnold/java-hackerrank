package InterviewPreparationKit.Miscellaneous;

/**
 * @author David W. Arnold
 * @version 24/09/2021
 */
public class FlippingBits
{
    /**
     * Flipping bits problem:
     *
     * @param n An integer.
     * @return The unsigned decimal integer result.
     */
    public static long flippingBits(long n)
    {
        return n ^ (Integer.MAX_VALUE * 2L + 1);
    }
}
