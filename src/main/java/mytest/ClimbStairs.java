package my_test;

/**
 * 70. 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/solution/zhi-xin-hua-shi-pa-lou-ti-zhi-cong-bao-l-lo1t/
 */
public class ClimbStairs {

    /**
     * 暴力破解，dfs  深度优先搜索。   leetcode超时了
     * @param n
     * @return
     */
    public static int climbStairs_0(int n){
        if (n==0 || n==1){
            return 1;
        }
        return climbStairs_0(n-1)+climbStairs_0(n-2);
    }

    private static int[] memo = null;


    /**
     * 记忆化递归， 这个leetcode不适合java解法提交，
     * @param n
     * @return
     */
    public static int climbStairs_1(int n){
        if(memo == null){
            memo = new int[n+1];
            for(int i=0 ; i<(n+1); i++){
                memo[i] = -1;
            }
        }
        if(n == 0 || n == 1){
            memo[n] = 1;
            return 1;
        }
        if(memo[n] == -1){
            memo[n] = climbStairs_1(n-1) + climbStairs_1(n-2);
        }
        return memo[n];
    }

    public static int climbStairs_1_2(int n, int[] memo){

        if(n == 0 || n == 1){
            memo[n] = 1;
            return 1;
        }
        if(memo[n] == -1){
            memo[n] = climbStairs_1(n-1) + climbStairs_1(n-2);
        }
        return memo[n];
    }

    /**
     * 自底向上 动态规划
     * @param n
     * @return
     */
    public static int climbtairs_2(int n){
        int[] nums = new int[n+1];
        nums[0] = 1;
        nums[1] = 1;
        for(int i=2; i<=n; i++){
            nums[i] = nums[i-1] + nums[i-2];
        }
        return nums[n];
    }


    /**
     * 自底向上动态规则，只需要最近两个
     * @param n
     * @return
     */
    public static int climbStairs_3(int n){
        int first = 1;
        int second = 1;
        int rs = 0;
        if(n == 0 || n == 1){
            return 1;
        }
        for(int i=2; i<=n; i++){
            rs = first+second;
            first = second;
            second = rs;
        }
        return rs;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(climbStairs_1(n));
    }
}
