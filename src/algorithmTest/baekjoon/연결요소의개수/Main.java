package algorithmTest.baekjoon.연결요소의개수;

import java.util.*;
import java.io.*;

class Main{
    static boolean[] visited;
    static boolean[][] greap;

    static int n;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];
        greap = new boolean[n+1][n+1];

        for(int i=0; i<m;i++){
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            greap[x][y] = true;
            greap[y][x] = true;
        }
        int answer =0;
        for(int i=1;i<=n;i++){
            if(!visited[i]){
                dfs(i);
                answer ++;
            }
        }
        bw.write(answer+"");
        bw.flush();
        br.close();
        bw.close();
    }

    private static void dfs(int index){
        visited[index] = true;

        for(int i =1; i <=n; i++){
            if(!visited[i] && greap[index][i]){
                dfs(i);
            }
        }
    }
}
