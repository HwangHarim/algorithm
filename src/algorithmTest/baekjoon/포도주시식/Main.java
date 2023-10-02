package algorithmTest.baekjoon.포도주시식;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] seq = new int[n+1];
        for(int i=1; i<=n;i++){
            int number = Integer.parseInt(br.readLine());
            seq[i] = number;
        }

        int[] dp = new int[n+1];
        dp[1] = seq[1];
        if(n>1) {
            dp[2] = seq[1] + seq[2];
        }
        for(int i=3;i<=n;i++){
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-2]+seq[i],dp[i-3]+seq[i-1]+seq[i])) ;
        }
        System.out.println(dp[n]);
        br.close();
    }
}