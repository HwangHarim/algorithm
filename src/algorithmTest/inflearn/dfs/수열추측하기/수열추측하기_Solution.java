package algorithmTest.inflearn.dfs.수열추측하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 수열추측하기_Solution {

    static class Main {


        static int[][] dy = new int[35][35];
        static int[] d, p, ch;
        static int n, m;

        static boolean flag = false;

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] input1 = br.readLine().split(" ");
            n = Integer.parseInt(input1[0]);
            m = Integer.parseInt(input1[1]);
            d = new int[n];
            p = new int[n];
            ch = new int[n + 1];

            for (int i = 0; i < n; i++) {
                d[i] = combis(n - 1, i);
            }
            dfs(0,0);

        }

        public static int combis(int n, int r) {
            if (dy[n][r] > 0) {
                return dy[n][r];

            }
            if (n == r || r == 0) {
                return 1;
            } else {
                return dy[n][r] = combis(n - 1, r - 1) + combis(n - 1, r);
            }

        }

        public static void dfs(int L, int sum) {
            if(flag){
                return;
            }
            if(L==n){
                if(sum == m){
                    for(int x : p){
                        System.out.print( x + " ");
                    }
                    System.out.println();
                    flag = true;
                }
            }else{
                for(int i=1;i<=n;i++){
                    if(ch[i]==0){
                        ch[i] = 1;
                        p[L] = i;
                        dfs(L+1, sum+(p[L]*d[L]));
                        ch[i] =0;
                    }
                }
            }
        }
    }
}

