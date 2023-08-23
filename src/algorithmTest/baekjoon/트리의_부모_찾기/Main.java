package algorithmTest.baekjoon.트리의_부모_찾기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] board;
    static boolean[] visited;
    static int[] answers;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        board = new ArrayList[n+1];
        visited= new boolean[n+1];
        answers = new int[n+1];
        for(int i =0; i<=n; i++){
            board[i] = new ArrayList();
        }
        for(int i =1;i<n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x].add(y);
            board[y].add(x);
        }
        dfs(1);

        for(int answer : answers){
            if(answer == 0){
                continue;
            }
            bw.write(String.valueOf(answer));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    static void dfs(int index){
        visited[index] = true;

        for(int i =0; i<board[index].size(); i++){
            if(!visited[board[index].get(i)]){
                answers[board[index].get(i)] = index;
                dfs(board[index].get(i));
            }
        }
    }
}
