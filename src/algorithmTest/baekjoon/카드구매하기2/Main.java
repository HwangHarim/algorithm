package algorithmTest.baekjoon.카드구매하기2;

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] p = new int[N+1];
        int[] dp = new int[N+1];
        for(int i= 0; i<=N;i++){
            dp[i] = 1000001;
        }
        for(int i=1; i<=N;i++){
            p[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] =0;

        for(int i =1;i<=N;i++){
            for(int j =1;j<=i;j++){
                dp[i] = Math.min(dp[i], dp[i-j] + p[j]);
            }
        }

        sb.append(dp[N]);
        bw.write(sb.toString());


        br.close();
        bw.close();
    }
}