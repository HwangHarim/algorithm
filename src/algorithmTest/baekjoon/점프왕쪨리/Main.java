package algorithmTest.baekjoon.점프왕쪨리;

import java.util.*;
import java.io.*;

public class Main {

    static int mapSize;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx ={1,0};
    static int[] dy = {0,1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        mapSize = Integer.parseInt(br.readLine());

        map = new int[mapSize][mapSize];
        visited = new boolean[mapSize][mapSize];

        for(int i =0; i< mapSize;i++){
            String[] init = br.readLine().split(" ");
            for (int j = 0; j < mapSize; j++) {
                map[i][j] = Integer.parseInt(init[j]);
            }
        }

        dfs(0,0);

        if(visited[mapSize-1][mapSize-1]){
            bw.write("HaruHaru");
            bw.newLine();
        }else{
            bw.write("Hing");
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    public static void dfs(int x, int y){
        visited[y][x] = true;

        for(int i =0; i<2; i++){
            int nx = x + dx[i]*map[y][x];
            int ny = y + dy[i]*map[y][x];

            if(mapSize<= nx || mapSize <= ny){
                continue;
            }
            if(!visited[ny][nx]){
                dfs(nx, ny);
            }
        }
    }
}