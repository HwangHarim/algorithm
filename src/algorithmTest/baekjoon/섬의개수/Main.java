package algorithmTest.baekjoon.섬의개수;

import java.util.*;
import java.io.*;

public class Main {

    static int[] dx = {0,1,1,1,0,-1,-1,-1};
    static int[] dy = {1,1,0,-1,-1,-1, 0,1};
    static boolean[][] map;
    static boolean[][] visited;
    static final int MAX = 60;
    static int answer;


    static int w ,h;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            map = new boolean[h][w];
            visited = new boolean[h][w];

            for(int i=0; i<h; i++){
                String[] info = br.readLine().split(" ");
                for(int j =0; j<w;j++){
                    if(info[j].equals("1")){
                        map[i][j] = true;
                    }
                }
            }

            answer =0;

            for(int i=0; i<h; i++){
                for(int j =0; j<w;j++){
                    if(map[i][j]&&!visited[i][j]){
                        dfs(j,i);
                        answer++;
                    }
                }
            }

            bw.write(String.valueOf(answer));
            bw.newLine();
            answer = 0;
        }
        br.close();
        bw.close();
    }

    public static void dfs(int x, int y){
        visited[y][x] = true;

        for(int i = 0; i<8;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0||w<=nx||ny < 0 || h<=ny ){
                continue;
            }

            if(!visited[ny][nx]&& map[ny][nx]){
                dfs(nx,ny);
            }
        }
    }
}
