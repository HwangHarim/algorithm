package algorithmTest.baekjoon.제곱의합;

import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2; i<=N; i++){
            dp[i] = i;
            for (int j = 1; j*j <= i; j++) {
                if(dp[i] > dp[i-j*j]+1) {
                    dp[i]= dp[i-j*j]+1;
                }
           }
        }

        System.out.println(dp[N]);

        br.close();
    }
}