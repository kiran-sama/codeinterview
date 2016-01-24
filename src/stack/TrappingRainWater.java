package stack;

/**
 * Created by ksama on 1/10/16.
 */
public class TrappingRainWater {
  int trap(int A[], int n) {
    int left=0; int right=n-1;
    int res=0;
    int maxleft=0, maxright=0;
    while(left<=right){
      if(A[left]<=A[right]){
        if(A[left]>=maxleft) maxleft=A[left];
        else res+=maxleft-A[left];
        left++;
      }
      else{
        if(A[right]>=maxright) maxright= A[right];
        else res+=maxright-A[right];
        right--;
      }
    }
    return res;
  }

  public static void main(String[] args){
    int height[] = {0,1,0,8,0,0,0,7,0,0,2};
    System.out.println(new TrappingRainWater().trap(height, height.length));
  }
}
