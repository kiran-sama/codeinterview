package arrays;

/**
 * Created by ksama on 1/22/16.
 */
public class LongestIncreasingPathInMatrix {
  public int longestIncreasingPath(int[][] matrix) {
    int length = matrix.length;
    int width = matrix[0].length;
    int result[][] = new int[length][width];
    int max = 0;
    for(int i=0;i<length;i++){
      for(int j=0;j<width;j++){
        int top = 1;
        int left = 1;
         if(j!=0){
          int diff = matrix[i][j]-matrix[i][j-1];
          int temp = diff * result[i][j-1];
          if(temp == 0)
            top = 1;
          else if(temp<0)
            top = -2;
          else
            top = result[i][j-1]<0?result[i][j-1]-1: result[i][j-1]+1;
        }
        if( i!=0){
          int diff = matrix[i][j]-matrix[i-1][j];
          int temp = diff * result[i-1][j];
          if(temp == 0)
            left = 1;
          else if(temp<0)
            left = -2;
          else
            left = result[i-1][j]<0?result[i-1][j]-1: result[i-1][j]+1;
        }
        if(Math.abs(top)>Math.abs(left)){
          result[i][j] = top;
        }
        max = Math.max(result[i][j],max);
      }
    }
    return max;
  }

}
