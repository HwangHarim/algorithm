package algorithmTest.inflearn.dfs.동전교환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class 동전문제_Solution {
    static class Main {
        static int answer = 1000000000;
        static int n;
        static int[] arr;
        static int m;
        public static void main(String[] args) throws Exception{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            n = Integer.parseInt(br.readLine());
            arr =new int[n];
            String input1= br.readLine();
            String[] input2 = input1.split(" ");
            Arrays.sort(input2, Collections.reverseOrder());
            for(int i=0; i<input2.length; i++){
                arr[i] = Integer.parseInt(input2[i]);
            };
            m= Integer.parseInt(br.readLine());
            dfs(0,0);
            System.out.println(answer);
        }

        public static void dfs(int L, int sum){
            if(sum>m)return;
            if(L>=answer) return;
            if(sum == m){
                answer = Math.min(answer, L);
            }else{
                for(int i=0; i<n;i++){
                    dfs(L+1, sum +arr[i]);
                }
            }
        }
    }
}