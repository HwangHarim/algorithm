package algorithmTest.baekjoon.일이삼합_구하기;

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;



        for(int i=0; i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());

            for(int j=4; j<=number;j++){
                dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
            }

            sb.append(dp[number]).append('\n');
        }


        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
