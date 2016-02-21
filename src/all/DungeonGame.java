package all;

/**
 * Created by ksama on 2/19/2016.
 */
public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    dungeon[i][j] = -dungeon[i][j];
                }
                else if(i==0){
                    dungeon[i][j] = dungeon[i][j-1]-dungeon[i][j];
                }else if(j==0){
                    dungeon[i][j] = dungeon[i-1][j]-dungeon[i][j];
                }else{
                    dungeon[i][j] = Math.min(dungeon[i-1][j],dungeon[i][j-1])-dungeon[i][j];
                }
            }
        }
        return dungeon[m-1][n-1]>0?dungeon[m-1][n-1]+1:1;
    }
}
