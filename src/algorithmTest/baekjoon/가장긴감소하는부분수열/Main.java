package algorithmTest.baekjoon.가장긴감소하는부분수열;

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] seq = new int[n];
        int[] dp = new int[n];

        for(int i=0; i<n;i++){
            seq[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] =1;

        for(int i=1;i<n;i++){
            dp[i] =1;
            for(int j =0;j<i;j++){
                if(seq[j]>seq[i]&& dp[i] <= dp[j]){
                    dp[i] = dp[j]+1;
                }else if(seq[i] ==seq[j]){
                    dp[i] = dp[j];
                }
            }
        }


        int max = -1;
        for(int i=0; i<n;i++){
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
        br.close();
    }
}
