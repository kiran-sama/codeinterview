package string;

/**
 * Created by ksama on 12/27/15.
 */
public class RotateMatrix {

  public static int[][] rotateMatrix(int[][] original){
    int noOfRows = original.length;
    int noOfColumns = 0;
    if(original.length>0){
       noOfColumns = original[0].length;
    }
    int[][] result = new int[noOfColumns][noOfRows];
    for(int i=0;i<noOfRows;i++){
      for(int j=0;j<noOfColumns;j++){
        result[j][noOfRows-i-1] = original[i][j];
      }
    }
    return result;
  }

  public static void propogateZero(int[][] original){
    boolean[] zeroRows = new boolean[original.length];
    boolean[] zeroColumns = new boolean[original[0].length];

    for(int i=0;i<original.length;i++){
      for(int j=0;j<original[0].length;j++){
        if(original[i][j]==0){
          zeroColumns[j]=true;
          zeroRows[i] = true;
        }
      }
    }

    for(int i=0;i<original.length;i++){
      for(int j=0;j<original[0].length;j++){
          if(zeroColumns[j]||zeroRows[i])
            original[i][j] = 0;
      }
    }

  }

  public static void printMatrix(int[][] matrix){
    int noOfRows = matrix.length;
    int noOfColumns = 0;
    if(matrix.length>0){
      noOfColumns = matrix[0].length;
    }

    for(int i=0;i<noOfRows;i++){
      System.out.println();
      for(int j=0;j<noOfColumns;j++){
        System.out.print(matrix[i][j]+" ");
      }
    }
  }

  public static void main(String[] args){
    int[][] matrix = new int[][]{{1,2,0,4,5},{6,7,8,9,0}};
    printMatrix(matrix);
    printMatrix(rotateMatrix(matrix));
    propogateZero(matrix);
    printMatrix(matrix);
  }

}
