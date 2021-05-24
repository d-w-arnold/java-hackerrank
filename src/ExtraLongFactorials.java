import java.math.BigInteger;

/**
 * @author David W. Arnold
 * @version 24/05/2021
 */
public class ExtraLongFactorials
{
    /**
     * Get n factorial (n!)
     *
     * @param n Input between 0-100
     */
    public static void extraLongFactorials(int n)
    {
        BigInteger bigInt = new BigInteger(String.valueOf(n));
        for (int i = n - 1; i > 0; i--) {
            bigInt = bigInt.multiply(new BigInteger(String.valueOf(i)));
        }
        System.out.println(bigInt);
    }
}
