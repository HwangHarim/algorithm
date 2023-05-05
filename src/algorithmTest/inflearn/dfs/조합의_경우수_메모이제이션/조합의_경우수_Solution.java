package algorithmTest.inflearn.dfs.조합의_경우수_메모이제이션;

import java.io.*;

public class 조합의_경우수_Solution {

    static class Main {
        static int[][] combination= new int[35][35];

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int r = Integer.parseInt(input[1]);

            System.out.println(dfs(n, r));
        }

        public static int dfs(int n, int r) {
            if(combination[n][r]>0)return combination[n][r];
            if (r == 0 || n == r) {
                return 1;
            } else {
                return combination[n][r] = dfs(n - 1, r - 1) + dfs(n - 1, r);
            }
        }
    }
}