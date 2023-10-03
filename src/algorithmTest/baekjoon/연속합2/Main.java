package algorithmTest.baekjoon.연속합2;

import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N][2]; 
        dp[0][0] = dp[0][1] = arr[0];

        int ans = arr[0];
        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.max(dp[i - 1][0] + arr[i], arr[i]);

            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + arr[i]);

            ans = Math.max(ans, Math.max(dp[i][0], dp[i][1]));
        }
        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}