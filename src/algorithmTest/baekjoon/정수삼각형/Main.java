package algorithmTest.baekjoon.정수삼각형;

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] seq = new int[n][n];
        int[][] dp = new int[n][n];

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<=i;j++){
                seq[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = seq[0][0];

        if(1<n){
            dp[1][0] = dp[0][0]+ seq[1][0];
            dp[1][1] = dp[0][0]+ seq[1][1];

            for(int i=2; i<n; i++){
                for(int j=0;j<=i;j++){
                    if(j !=0 && j !=i){
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1])+ seq[i][j];
                    }else if(j == 0){
                        dp[i][j] = dp[i-1][j] + seq[i][j];
                    }else{
                        dp[i][j] = dp[i-1][j-1] + seq[i][j];
                    }
                }
            }
        }



        int answer =0;

        for(int i=0; i<n;i++){
            answer = Math.max(answer, dp[n-1][i]);
        }

        System.out.println(answer);
        br.close();
    }
}
