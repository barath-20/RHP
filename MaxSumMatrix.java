import java.util.*;
class Main{
    public static void main(String[] main){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] mat = new int[m][n];
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)    mat[i][j] = sc.nextInt();
        }
        int prevMax1 = 0, prevMax2 = 0;
        for(int j = 0;j<n;j++){
            dp[0][j] = mat[0][j];
            if(dp[0][j] >=prevMax1){
                prevMax2 = prevMax1;
                prevMax1 = dp[0][j];
            }
            else if(dp[0][j]>=prevMax2){
                prevMax2 = dp[0][j];
            }
        }
        for(int i=1;i<m;i++){
            int currMax1 = 0, currMax2 = 0; 
            for(int j=0;j<n;j++){
                int prev = (dp[i-1][j]==prevMax1)?prevMax2:prevMax1;
                dp[i][j] = prev + mat[i][j];
                if(dp[i][j]>=currMax1){
                    currMax2 = currMax1;
                    currMax1 = dp[i][j];
                }
                else if(dp[i][j]>=currMax2){
                    currMax2 = dp[i][j];
                }
            }
            prevMax1 = currMax1;
            prevMax2 = currMax2;
        }
        int res = 0;
        for(int j=0;j<n;j++){
            res = Math.max(res,dp[m-1][j]);
        }
        System.out.println(res);
    }
}