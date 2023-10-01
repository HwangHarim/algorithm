package algorithmTest.baekjoon.오르막수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int round = Integer.parseInt(br.readLine());
        for(int k =0; k<round;k++){

            int n = Integer.parseInt(br.readLine());
            int[][] point = new int[3][100001];
            int[][] dp = new int[3][100001];


            for(int i=1;i<3;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=1; j<=n; j++){
                    point[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[1][1] = point[1][1];
            dp[2][1] = point[2][1];

            for(int i=2; i<=n;i++){
                    dp[1][i] = Math.max(dp[1][i-1], dp[1][i-2]) + point[1][i];
                    dp[2][i] = Math.max(dp[2][i-1], dp[2][i-2]) + point[2][i];
            }
            System.out.println(Math.max(dp[1][n],dp[2][n]));
        }


        br.close();
    }
}