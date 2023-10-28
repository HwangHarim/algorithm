package algorithmTest.baekjoon.테트로미노;

import java.util.*;
import java.io.*;

class Main{
    static boolean[][] visited;
    static int[][] map;
    static int max = Integer.MIN_VALUE;
    static int[] dx = {1  , -1 ,0, 0};
    static int[] dy = {0 , 0, -1 , 1};
    static int y,x;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        visited=new boolean[y][x];
        map = new int[y][x];

        for(int i=0; i<y; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<x;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<y;i++){
            for(int j=0; j<x;j++){
                visited[i][j] = true;
                dfs(i,j,1,map[i][j]);
                visited[i][j] = false;
            }
        }
        System.out.println(max);
        br.close();

    }

    public static void dfs(int lx, int ly, int count, int sum){
        if(count == 4){
            max = Math.max(max, sum);
            return;
        }

        for(int i=0;i<4; i++){
            int nx = lx + dx[i];
            int ny = ly + dy[i];

            if(nx<0 || x<=nx || ny<0 || y<=ny) {
                continue;
            }
                if(!visited[ny][nx]){
                    if(count==2){
                        visited[ny][nx] = true;
                        dfs(lx, ly, count+1, sum + map[ny][nx]);
                        visited[ny][nx] = false;
                    }
                    visited[ny][nx] = true;
                    dfs(nx, ny, count+1, sum + map[ny][nx]);
                    visited[ny][nx]= false;
                }

        }
    }
}