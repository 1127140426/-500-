package medium2;

/**
 * leetCode 221 最大正方形
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 */
public class T221_maximalSquare_9_24 {
    public static void main(String[] args) {

    }
    public int maximalSquare(char[][] matrix) {
        int R = matrix.length;
        int C = R > 0 ? matrix[0].length : 0;
        int[][] dp = new int[R + 1][C + 1];
        int maxLen = 0;
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                if(matrix[i - 1][j - 1] == '1') {   //对应原数组的位置
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j],dp[i - 1][j - 1]),dp[i][j - 1]) + 1;
                    maxLen = Math.max(maxLen,dp[i][j]);
                }
            }
        }
        return maxLen * maxLen;
    }
}
