package algorithmTest.baekjoon.깊이우선탐색2;

import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] board;
    static int[] answer;
    static int rank = 1;

    static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];
        board = new ArrayList[n+1];
        answer = new int[n+1];
        for(int i=0; i<=n; i++){
            board[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            board[x].add(y);
            board[y].add(x);
        }

        for(int i =1;i<=n;i++){
            Collections.sort(board[i], Collections.reverseOrder());
        }

        dfs(r);

        for(int i=1;i<= n;i++){
            bw.write(String.valueOf(answer[i]));
            bw.newLine();
        }
        br.close();
        bw.close();
    }

    public static void dfs(int index){
        visited[index] = true;
        answer[index] = rank;
        rank++;

        for(int i =0; i < board[index].size(); i++){
            if(!visited[board[index].get(i)]){
                dfs(board[index].get(i));
            }
        }
    }
}
