package algorithmTest.inflearn.dfs.섬나라아일랜드;

import static algorithmTest.inflearn.dfs.섬나라아일랜드.섬나라아일랜드_Solution_BFS.Main.q;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 섬나라아일랜드_Solution_BFS {

    static class Point{
        int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static class Main{
        static int[][] board, dis;
        static int[] dx = {0,1,1,1,0,-1,-1,-1};
        static int[] dy = {1,1,0,-1,-1,-1,0,1};
        static Queue<Point> q = new LinkedList<>();
        static int answer;

        public static void main(String[] args) {
            Scanner kb = new Scanner(System.in);
            int m= kb.nextInt();;
            board = new int[m][m];
            dis = new int[m][m];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    board[i][j] = kb.nextInt();
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    if(board[i][j] == 1){
                        board[i][j] =0;
                        bfs(i,j);
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }
        public static void bfs(int x, int y){
            q.offer(new Point(x,y));
            while(!q.isEmpty()){
                Point tmp = q.poll();
                for(int i =0; i<8;i++){
                    int nx = tmp.x+dx[i];
                    int ny = tmp.y+dy[i];
                    if(nx>=0 && nx< board.length&&ny>=0&&ny <board.length && board[nx][ny] == 1){
                        board[nx][ny] =0;
                        q.offer(new Point(nx, ny));
                    }
                }
            }
        }
    }


}
