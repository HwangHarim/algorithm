package algorithmTest.baekjoon.NX2_타일2;

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int number = Integer.parseInt(br.readLine());

        int[] dp = new int[number+1];
        dp[1] = 1%10007;
        if(number>=2){
            dp[2] = 3%10007;
            for(int i =3; i<=number;i++){
                dp[i] = (dp[i-1]+2*dp[i-2])%10007;

            }
        }
        bw.write(String.valueOf(dp[number]));

        br.close();
        bw.close();

    }

}
