package algorithmTest.baekjoon.N과M_4;

import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];

        dfs(1, 0);

        bw.write(sb.toString());

        br.close();
        bw.close();

    }

    public static void dfs(int index, int deap) {
        if (deap == m) {
            for (int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append('\n');
            return;
        }

        for (int i = index; i <= n; i++) {
            arr[deap] = i;
            dfs(i, deap + 1);
        }
    }
}