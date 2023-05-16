package algorithmTest.inflearn.dfs.섬나라아일랜드;

import java.util.Scanner;

public class 섬나라아일랜드_Solution_DFS {

    static int[][] board, dis;
    static int[] dx = {0,1,1,1,0,-1,-1,-1};
    static int[] dy = {1,1,0,-1,-1,-1,0,1};
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
                    dfs(i,j);
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    public static void dfs(int x, int y){
            for(int i=0; i<8;i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < board.length && ny >= 0 && ny < board.length
                    && board[nx][ny] == 1) {
                    board[nx][ny] = 0;
                    dfs(nx, ny);
                }
            }
    }
}