package algorithmTest.baekjoon.RGB거리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    static int[][] seq;
    static int[][] dp;

    public static void main(String[] args) throws Exception{
        solution();
    }

    public static void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        seq = new int[n][3];
        dp = new int[n][3];

        for(int i =0; i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                seq[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = seq[0][0];
        dp[0][1] = seq[0][1];
        dp[0][2] = seq[0][2];

        for(int i=1; i<n;i++){
            for(int j=0; j<3;j++){
                if(j ==0){
                    dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2]) +seq[i][0];
                }if(j ==1){
                    dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2]) +seq[i][1];
                }else{
                    dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1]) +seq[i][2];
                }
            }
        }
        int answer = 3001;
        for(int i =0;i<3;i++){
            answer = Math.min(dp[n-1][i],answer);
        }
        System.out.print(answer);
        br.close();
    }
}
