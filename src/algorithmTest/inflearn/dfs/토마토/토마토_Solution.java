package algorithmTest.inflearn.dfs.토마토;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 토마토_Solution {
    static class Point{
        public int x, y;
        Point(int x, int y){
            this.x =x;
            this.y =y;
        }
    }

    static class Main {
        static int[][] board, dis;
        static int[] dx = {0,1,0,1};
        static int[] dy = {1,0,-1,0};
        static Queue<Point> q = new LinkedList<>();

        public static void bfs() {
            while(!q.isEmpty()){
               Point tmp = q.poll();
               for(int i=0;i<4;i++){
                   int nx = tmp.x + dx[i];
                   int ny = tmp.y + dy[i];
                   if(nx>=0&&nx<board.length&&ny>=0&&ny<board[0].length&&board[nx][ny] == 0){
                       board[nx][ny] =1;
                       q.offer(new Point(nx, ny));
                       dis[nx][ny] = dis[tmp.x][tmp.y] +1;
                   }
               }
            }
        }

        public static void main(String[] args) throws Exception {
            Scanner kb = new Scanner(System.in);
            int m= kb.nextInt();
            int n = kb.nextInt();
            board = new int[m][n];
            dis = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = kb.nextInt();
                    if(board[i][j] == 1){
                        q.offer(new Point(i,j));
                    }
                }
            }
            bfs();
            boolean flag = true;
            int answer = Integer.MIN_VALUE;
            for(int i=0; i < m;i++){
                for(int j=0; j<n;j++){
                    if(board[i][j] == 1){
                        flag = false;
                    }
                }
            }

            if(flag){
                for (int i = 0; i < m; i++) {
                    for(int j=0; j<n;j++){
                       answer = Math.max(answer,dis[i][j]);
                    }
                }
            }else{
                System.out.println(-1);
            }
        }
    }
}