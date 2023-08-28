package algorithmTest.baekjoon.바닥장식;

import java.util.*;
import java.io.*;

public class Main {

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    static boolean[][] grepOne;
    static boolean[][] grepTwo;
    static int answer=0;
    static int x,y;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        grepOne = new boolean[y][x];
        grepTwo = new boolean[y][x];

        for(int i=0;i<y; i++){
            String[] init = br.readLine().split("");
            for(int j =0; j<x;j++){
                if(init[j].equals("-")){
                    grepOne[i][j] = true;
                }
                if(init[j].equals("|")){
                    grepTwo[i][j] = true;
                }
            }
        }

        for(int i=0;i<y;i++){
            for(int j=0; j<x;j++){
             if(grepOne[i][j]){
                 dfsOne(j,i);
                 answer++;
             }
             if(grepTwo[i][j]){
                 dfsTwo(j,i);
                 answer++;
             }
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }

    public static void dfsOne(int w, int h){

        for(int i = 0; i < 4; i++){
            int nx = w + dx[i];

            if(nx<0 || x<= nx){
                continue;
            }

            if(grepOne[h][nx]){
                grepOne[h][nx] = false;
                dfsOne(nx, h);
            }
        }
    }

    public static void dfsTwo(int w, int h){

        for(int i = 0; i < 4; i++){
            int ny = h + dy[i];

            if(ny<0 || y<=ny){
                continue;
            }

            if(grepTwo[ny][w]){
                grepTwo[ny][w] = false;
                dfsTwo(w, ny);
            }
        }
    }
}
