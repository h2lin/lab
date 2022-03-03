package lc.datastruct.dp;

import java.util.Arrays;

public class N0474 {
    /**
     * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
     *
     * 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
     *
     * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
     * 输出：4
     * 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
     * 其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
     * 示例 2：
     *
     * 输入：strs = ["10", "0", "1"], m = 1, n = 1
     * 输出：2
     * 解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
     *  
     *
     * 提示：
     *
     * 1 <= strs.length <= 600
     * 1 <= strs[i].length <= 100
     * strs[i] 仅由 '0' 和 '1' 组成
     * 1 <= m, n <= 100
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/ones-and-zeroes
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int findMaxForm(String[] strs, int m, int n) {
        // 1.含义：dp[i][j]：从编号0-k中随意选取元素，0的个数不大于i、1的个数不大于j时，最多能选取的元素数量

        // 2.公式：dp[i][j] = Math.max(dp[i][j], dp[i - num0[k-1]][j - num1[k-1]] + 1);

        // 3.初始化：
        int[][] dp = new int[m+1][n+1];
        int count0 = 0;
        int count1 = 0;
        dp[0][0] = 0;

        for (String s : strs) {
            // 0、1计数
            count0 = 0;
            count1 = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') {
                    count0 ++;
                } else {
                    count1 ++;
                }
            }

            // 4.递推。
            for (int i = m; i >= count0; i--) {
                for (int j = n; j >= count1; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - count0][j - count1] + 1);
                }
            }
        }

        return dp[m][n];
    }
}
