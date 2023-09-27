package algorithmTest.baekjoon.가장긴증가하는부분수열4;

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        int[] arr = new int[N];
        int[] dp = new int[N];
        int lis =0;
        for(int i=0; i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i =0; i< N; i++){
            dp[i] =1;

            for(int j=0; j<i;j++){
                if(arr[j]<arr[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            lis = Math.max(lis, dp[i]);
        }

        int value = lis;
        Stack<Integer> stack = new Stack<>();

        for(int i =N-1; 0<=i;i--){
            if(value == dp[i]){
                stack.push(arr[i]);
                value--;
            }
        }

        while(!stack.empty()){
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(lis);
        System.out.println(sb);
        br.close();
    }
}