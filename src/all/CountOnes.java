package all;

/**
 * Created by ksama on 1/26/16.
 */
public class CountOnes {
  public int countDigitOne(int n) {
    int left = n;
    int one = 0;
    int right = 0;
    int d = 1;
    int countOnes = 0;
    while(left>0){
      d *= 10;
      left = n/d;
      one = (n%d)/(d/10);
      right = (n%d)%(d/10);
      if(one == 0){
        countOnes += left*(d/10);
      }else if(one ==1){
        countOnes += left*(d/10);
        countOnes += right+1;
      }else{
        countOnes += (left+1)*(d/10);
      }
    }
    return countOnes;

  }

  public static void main(String[] args){
    System.out.println(new CountOnes().countDigitOne(1410065408));
  }
}
