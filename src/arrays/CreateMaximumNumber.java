package arrays;

/**
 * Created by ksama on 12/29/15.
 */
public class CreateMaximumNumber {
  public int[] maxNumber(int[] nums1, int[] nums2, int k) {
    int[] result = new int[k];
    maxNumberHelper(nums1, 0, nums2, 0, result,0,nums1.length+nums2.length-k);
    return result;
  }

  public void  maxNumberHelper(int[] nums1,int start1,int[] nums2,int start2,int[] result,int rStart,int maxSkip){
    if(rStart==result.length)
      return;
     Result r1 = getMax(nums1, start1, start1 + maxSkip);
     Result r2 = getMax(nums2, start2, start2 + maxSkip);
    if(r1 == null){
      result[rStart]= r2.max;
      maxSkip -= (r2.index-start2);
      start2 = r2.index+1;

      rStart++;
      maxNumberHelper(nums1, start1, nums2, start2, result, rStart, maxSkip);
      return;
    }

    if(r2==null) {
      result[rStart]= r1.max;
      maxSkip -= (r1.index-start1);
      start1 = r1.index+1;

      rStart++;
      maxNumberHelper(nums1, start1, nums2, start2, result, rStart, maxSkip);
      return;
    }

     if(r2.max>r1.max){
       result[rStart]= r2.max;
       maxSkip -= (r2.index-start2);
       start2 = r2.index+1;

     } else if(r2.max<r1.max){
       result[rStart]= r1.max;
       maxSkip -= (r1.index-start1);
       start1 = r1.index+1;

     } else{
        Result r1t = getMax(nums1,start1,r1.index-1);
        Result r2t = getMax(nums2,start2,r2.index-1);
       while(r1t!=null && r2t != null && r1t.max==r2t.max){
         r1t = getMax(nums1,start1,r1t.index-1);
         r2t = getMax(nums2,start2,r2t.index-1);
       }

       if(r1t ==null || r2t == null){
         if(r1.index-start1 > r2.index - start2){
           result[rStart]= r2.max;
           maxSkip -= (r2.index-start2);
           start2 = r2.index+1;

         } else{
           result[rStart]= r1.max;
           maxSkip -= (r1.index-start1);
           start1 = r1.index+1;

         }
       }
       else{
         if(r1t.max> r2t.max){
           result[rStart]= r2.max;
           maxSkip -= (r2.index-start2);
           start2 = r2.index+1;

         } else{
           result[rStart]= r1.max;
           maxSkip -= (r1.index-start1);
           start1 = r1.index+1;

         }
       }

     }
    rStart++;
    maxNumberHelper(nums1, start1, nums2, start2, result, rStart, maxSkip);
  }

  public Result getMax(int[] num,int start,int end){
    if(start>end)
      return null;
    int max = -1;
    int index = -1;
    for(int i= start;i<=end&&i<num.length;i++){
      if(num[i]>max) {
        max = num[i];
        index =i;
      }
      if(max == 9)
        break;
    }
    return new Result(max, index);

  }



  public class Result{
    int max;
    int index;

    public Result(int max, int index) {
      this.max = max;
      this.index = index;
    }
  }
  /*
  [2,5,6,4,4,0]
[7,3,8,0,6,5,7,6,2]
15
   */
  public static void main(String[] args){
    CreateMaximumNumber solution = new CreateMaximumNumber();
    int[] nums1 = {2,5,6,4,4,0};
    int[] nums2 = {7,3,8,0,6,5,7,6,2};
    int[] result =solution.maxNumber(nums1,nums2,15);
    for(int i=0;i<result.length;i++){
      System.out.print(result[i]+" ");
    }
  }
}
