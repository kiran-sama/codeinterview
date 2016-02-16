package all;

/**
 * Created by ksama on 2/16/2016.
 */
public class NumberOfTrailingZeroes {
    public static int countFactZeros(int num) {
        int count = 0;
        if (num < 0) {
            return -1;
        }
        for (int i = 5; num / i > 0; i *= 5) {
            count += num / i;
        }
        return count;
    }

    public static void main(String args[]){
        for(int i=0;i<101;i++){
            System.out.println(i+"! ==> "+countFactZeros(i));
        }
    }
}
