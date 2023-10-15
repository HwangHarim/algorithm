package algorithmTest.baekjoon.완전탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] board;
    static boolean[] visited;
    static int answer = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        board = new boolean[n+1][n+1];
        visited = new boolean[n+1];

        st = new StringTokenizer(br.readLine());
        int target1 = Integer.parseInt(st.nextToken());
        int target2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int m =  Integer.parseInt(st.nextToken());
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            board[x][y] = true;
            board[y][x] = true;
        }

        dfs(target1, target2, n,0);

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }

    public static void dfs(int target1, int target2, int n,int count){
        if(target1 == target2){
            answer = count;
            return;
        }
        visited[target1] = true;

        for(int i=1;i<=n;i++){
            if(!visited[i] && board[target1][i]){
                dfs(i, target2, n, count+1);
            }
        }
    }
}
