package algorithmTest.inflearn.dfs.미로탐색;

import java.util.Scanner;

public class 미로탐색_Solution_dfs {

    static class Main{
        static int[] xd ={-1,0,1,0};
        static int[] yd = {0,1,0,-1};
        static int answer=0;
        static int[][] board;

        public static void main(String[] args) throws Exception{
            Scanner kb = new Scanner(System.in);
            board=new int[8][8];
            for(int i=1; i<=7; i++){
                for(int j=1; j<=7; j++){
                    board[i][j]=kb.nextInt();
                }
            }
            board[1][1] = 1;
            dfs(1,1);
            System.out.println(answer);
        }

        public static void dfs(int x,int y){
            if(x==7&&y==7){
                answer++;
            }else{
                for(int i=0; i<4;i++){
                    int nx = x + xd[i];
                    int ny = y + yd[i];
                    if(ny>=1&& ny<=7 && nx>=1 && nx<=7 && board[nx][ny]==0){
                        board[nx][ny] = 1;
                        dfs(nx, ny);
                        board[nx][ny] = 0;
                    }
                }
            }
        }
    }
}
