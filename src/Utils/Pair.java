package Utils;

/**
 * @author David W. Arnold
 * @version 08/06/2021
 */
public class Pair<T, U>
{
    private final T left;
    private final U right;

    public Pair(T left, U right)
    {
        this.left = left;
        this.right = right;
    }

    public T getLeft()
    {
        return this.left;
    }

    public U getRight()
    {
        return this.right;
    }
}
