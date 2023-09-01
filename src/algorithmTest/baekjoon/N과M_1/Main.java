package algorithmTest.baekjoon.N과M_1;

import java.util.*;
import java.io.*;

public class Main {

    static boolean[] visited;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static int n,m;

    public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];
        arr = new int[m];

        dfs(0);

        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    public static void dfs(int size){
        if(size == m){
            for(int val : arr){
                sb.append(val).append(" ");
             }
            sb.append("\n");
            return;
        }

        for(int i =1; i<=n;i++){
            if(!visited[i]){
                visited[i] = true;
                arr[size] = i;
                dfs( size+ 1);
                visited[i] = false;
            }
        }
     }
}