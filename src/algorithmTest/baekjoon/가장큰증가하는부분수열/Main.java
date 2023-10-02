package algorithmTest.baekjoon.가장큰증가하는부분수열;

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
        dp[0] = seq[0];

        for(int i=1; i<n;i++){
            dp[i] = seq[i];
            for(int j =0; j<i;j++){
                if(seq[j]<seq[i]){
                    dp[i] = Math.max(dp[j]+seq[i], dp[i]);
                }
            }
        }

        int answer=-1;
        for(int i = 0;i<n;i++){
          if(dp[i]>answer){
              answer = dp[i];
          }
        }

        System.out.println(answer);

        br.close();
    }
}
