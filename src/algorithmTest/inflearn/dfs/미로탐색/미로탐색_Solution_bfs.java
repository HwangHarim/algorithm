package algorithmTest.inflearn.dfs.미로탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로탐색_Solution_bfs {

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

        public static void bfs(int x,  int y) {
            Queue<Point> q = new LinkedList<>();
            q.offer(new Point(x, y));
            board[x][y] = 1;
            while(!q.isEmpty()){
                Point tmp = q.poll();
                for(int i=0; i<4;i++){
                    int nx = tmp.x + dx[i];
                    int ny = tmp.y + dy[i];
                    if(nx>0 && nx<8 && ny>0 && ny<8 && board[nx][ny] == 0){
                        board[nx][ny] =1;
                        q.offer(new Point(nx,ny));
                        dis[nx][ny] = dis[tmp.x][tmp.y] +1;
                    }
                }
            }
        }

        public static void main(String[] args) throws Exception {
            Scanner kb = new Scanner(System.in);
            board = new int[8][8];
            dis = new int[8][8];
            for (int i = 1; i <= 7; i++) {
                for (int j = 1; j <= 7; j++) {
                    board[i][j] = kb.nextInt();
                }
            }
            bfs(0,0);

        }
    }

}