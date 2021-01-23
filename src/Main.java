import java.math.BigInteger;

public class Main
{

    public static void main(String[] args)
    {
        extraLongFactorials(100);
    }

    /**
     * @param n Input between 0-100
     */
    private static void extraLongFactorials(int n)
    {
        BigInteger bigInt = new BigInteger(String.valueOf(n));
        for (int i = n - 1; i > 0; i--) {
            bigInt = bigInt.multiply(new BigInteger(String.valueOf(i)));
        }
        System.out.println(bigInt.toString());
    }
}
