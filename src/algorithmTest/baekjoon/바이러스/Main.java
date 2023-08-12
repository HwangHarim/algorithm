package algorithmTest.baekjoon.바이러스;

import java.util.*;
import java.io.*;

public class Main {

    static boolean[] visited;
    static boolean[][] board;
    static int answer=0;
    static int edge, size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        size = Integer.parseInt(br.readLine());
        edge = Integer.parseInt(br.readLine());
        visited = new boolean[size+1];
        board = new boolean[size+1][size+1];

        for (int i = 0; i <edge; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x][y] = true;
            board[y][x] = true;
        }
        dfs(1);

        bw.write(String.valueOf(answer-1));
        br.close();
        bw.close();
    }

    public static void dfs(int level) {
       visited[level] =true;
       answer++;
       for(int i=0; i<edge; i++){
           if(board[level][i] && !visited[i]){
               dfs(i);
           }
       }
    }
}