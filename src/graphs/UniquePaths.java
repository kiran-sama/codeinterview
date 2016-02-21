package graphs;

/**
 * Created by ksama on 2/18/2016.
 */
public class UniquePaths {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] cache = new int[m][n];
        return uniquePathsWithObstacles(obstacleGrid,0,0,cache);
    }

    private int uniquePathsWithObstacles(int[][] obstacleGrid,int i,int j,int[][] cache){
        if(cache[i][j]!=-1){
            return cache[i][j];
        }
        int sum = 0;
        if(i<obstacleGrid.length-1 && obstacleGrid[i+1][j]!=1){
            sum+=uniquePathsWithObstacles(obstacleGrid,i+1,j,cache);
        }
        if(j<obstacleGrid[0].length-1 && obstacleGrid[i][j+1]!=1){
            sum+=uniquePathsWithObstacles(obstacleGrid,i,j+1,cache);
        }
        cache[i][j]=sum;
        return sum;
    }

    public static void main(String[] args){

    }
}
