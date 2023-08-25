package algorithmTest.baekjoon.유기농배추;

import java.util.*;
import java.io.*;

public class Main {

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st =  new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        int count =0;

        do {
            st =  new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            boolean[][] grep = new boolean[y][x];

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int inX = Integer.parseInt(st.nextToken());
                int inY = Integer.parseInt(st.nextToken());

                grep[inY][inX] = true;
            }
            int answer = 0;
            for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j++) {
                    if (grep[i][j]) {
                        dfs(j, i, grep);
                        answer++;
                    }
                }
            }
            bw.write(String.valueOf(answer));
            bw.newLine();
            count++;
        } while (count != t);



        br.close();
        bw.close();
    }
    public static void dfs(int indexX,int indexY, boolean[][] grep){
        grep[indexY][indexX] = false;
        for(int i = 0; i < 4; i++){
            int nx = indexX + dx[i];
            int ny = indexY + dy[i];

            if(ny<0 || grep.length <= ny ||nx<0 || grep[ny].length <= nx){
                continue;
            }

            if(grep[ny][nx]){

                dfs(nx, ny, grep);
            }
        }

    }
}
