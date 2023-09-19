package algorithmTest.baekjoon.일로만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(bf.readLine());
        System.out.println(calculator(number));
    }
    public static int calculator(int number){
        int dp[] = new int[number+1];
        dp[1] =0;
        for(int i=2;i<=number;i++){
            dp[i] = dp[i-1]+1;
            if(i%2 == 0) dp[i] = Math.min(dp[i],dp[i/2]+1);
            if(i%3 == 0) dp[i] = Math.min(dp[i], dp[i/3]+1);
        }
        return dp[number];
    }
    //점화식에는 Top-down(재귀를 이용하여 계산하는 방식)/ Bottom-up(반복문을 이용해서 계하는 방식)
}