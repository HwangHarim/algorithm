package algorithmTest.baekjoon.미로탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] dx ={-1,0,1,0};
    static int[] dy ={0,-1,0,1};
    static boolean[][] visited;
    static int[][] map;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for(int i = 1; i<=N;i++){
            String[] init = br.readLine().split("");
            for(int j = 1;j<=M; j++){
                map[i][j] = Integer.parseInt(init[j-1]);
            }
        }

        dfs(1,1,1);

        System.out.println(answer);
        br.close();
    }

    static void dfs(int x, int y, int count){

        if(x ==M && y==N){
            answer = Math.min(answer, count);
            return;
        }

        if(answer <= count){
            return;
        }

        visited[y][x] = true;

        for(int i=0; i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(0 >= nx || M<nx || 0>= ny || N < ny){
                continue;
            }

            if(map[ny][nx] ==1 && !visited[ny][nx]){
                dfs(nx, ny, count+1);
                visited[ny][nx] = false;
            }
        }

    }
}