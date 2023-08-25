package algorithmTest.baekjoon.침투;

import java.util.*;
import java.io.*;

public class Main {

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] map;
    static boolean[][] visited;
    static boolean  answer = false;
    static int ySize, xSize;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st =  new StringTokenizer(br.readLine());
        ySize = Integer.parseInt(st.nextToken());
        xSize = Integer.parseInt(st.nextToken());

        map = new int[ySize][xSize];
        visited = new boolean[ySize][xSize];

        for(int i =0; i<ySize;i++){
            st =  new StringTokenizer(br.readLine());
            String[] numbers = st.nextToken().split("");
            for(int j =0; j<xSize;j++){
                map[i][j] = Integer.parseInt(numbers[j]);
            }
        }


            for(int j=0; j<xSize;j++){
                if(map[0][j] == 0){
                    dfs(j,0);
                }
            }


        if(answer) {
            bw.write("YES");
        } else{
            bw.write("NO");
        }

        for(int i=0; i<ySize; i++){
            System.out.println(Arrays.toString(visited[i]));
        }
        br.close();
        bw.close();
    }

    public static void dfs(int x, int y){

        visited[y][x] = true;

        if(y == ySize-1){
            answer = true;
            return;
        }

        for(int i = 0; i < 3; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(ny<0 || map.length <= ny ||nx<0 || map[ny].length <= nx){
                continue;
            }

            if(!visited[ny][nx] && map[ny][nx] == 0){
                dfs(nx, ny);
            }
        }
    }
}