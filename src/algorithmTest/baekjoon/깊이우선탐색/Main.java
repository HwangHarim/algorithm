package algorithmTest.baekjoon.깊이우선탐색;

import java.util.*;
import java.io.*;

class Main{
    static boolean[] visited;
    static int[] answer;
    static ArrayList<Integer>[] board;
    static int order;
    static int v,e,r;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        board = new ArrayList[1000010];
        for(int i = 1; i <=v; i++){
            board[i] = new ArrayList<>();
        }

        visited = new boolean[1000010];
        answer = new int[1000010];
        order =1;


        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x].add(y);
            board[y].add(x);
        }

        for(int i=1;i<=v;i++){
            Collections.sort(board[i]);
        }

        dfs(r);

        for(int i =1; i<=v;i++){
            bw.write(String.valueOf(answer[i]));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private static void dfs(int index){
        visited[index] = true;
        answer[index] = order;
        order++;

        for(int i=0; i< board[index].size(); i++){
            int next = board[index].get(i);
            if(!visited[next]){
                dfs(next);
            }
        }
    }
}