package bitmanipulation;

/**
 * Created by ksama on 2/16/2016.
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return (n&n-1)==0;
    }
}
