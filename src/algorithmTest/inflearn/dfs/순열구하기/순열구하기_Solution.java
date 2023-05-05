package algorithmTest.inflearn.dfs.순열구하기;

import java.io.*;

public class 순열구하기_Solution {

    static class Main {

        static int n;
        static int m;
        static int[] arr;
        static int[] pm;

        static boolean[] visited;
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input1 = br.readLine();
            String input2 = br.readLine();
            String[] input = input1.split(" ");
            n = Integer.parseInt(input[0]);
            m = Integer.parseInt(input[1]);
            pm = new int[m];
            arr = new int[n];
            visited = new boolean[n];

            String[] inputArr = input2.split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputArr[i]);
            }
            dfs(0);
        }

        public static void dfs(int L) {
            if (L == m) {
                for (int x : pm) {
                    System.out.print(x + " ");
                }
                System.out.println();
            } else {
                for (int i = 0; i < n; i++) {
                    if(!visited[i]){
                        pm[L] = arr[i];
                        visited[i] = true;
                        dfs(L + 1);
                        visited[i] = false;
                    }
                }
            }
        }
    }
}