package algorithmTest.baekjoon.동물원;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        long[][] dp = new long[n][3];
        long mod = 9901;
        dp[0][0] =1;
        dp[0][1] =1;
        dp[0][2] =1;

        for(int i =1; i<n;i++){
            for(int j=0;j<3;j++){
                if(j ==0){
                    dp[i][0] = dp[i-1][0]+dp[i-1][1]+dp[i-1][2];
                    dp[i][0] %=mod;
                }if(j ==1){
                    dp[i][1] = dp[i-1][0]+dp[i-1][2];
                    dp[i][1] %=mod;
                }else{
                    dp[i][2] = dp[i-1][0]+dp[i-1][1];
                    dp[i][2] %=mod;
                }
            }
        }

        long answer = dp[n-1][0]+dp[n-1][1]+dp[n-1][2];
        bw.write(String.valueOf(answer%mod));

        br.close();
        bw.close();
    }
}
