package medium;

/**
 * leetCode 63 : 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 */
public class T63_uniquePathsWithObstacles_dp {
    public static void main(String[] args) {

    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
         int R = obstacleGrid.length;
         int C = obstacleGrid[0].length;
         if(R == 0 || C == 0)
             return 0;
         if(obstacleGrid[0][0] == 1)
             return 0;
         obstacleGrid[0][0] = 1;
        for (int i = 1; i < R; i++) {
            if(obstacleGrid[i - 1][0] == 1 && obstacleGrid[i][0] == 0){
                obstacleGrid[i][0] = 1;
            }else {
                obstacleGrid[i][0] = 0;
            }
        }
        for (int i = 1; i < C; i++) {
            if(obstacleGrid[0][i - 1] == 1 && obstacleGrid[0][i] == 0){
                obstacleGrid[0][i] = 1;
            }else{
                obstacleGrid[0][i] = 0;
            }
        }
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if(obstacleGrid[i][j] == 0){
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        return obstacleGrid[R - 1][C - 1];
    }
}
