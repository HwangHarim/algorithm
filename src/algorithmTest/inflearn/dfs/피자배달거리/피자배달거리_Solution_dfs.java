package algorithmTest.inflearn.dfs.피자배달거리;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 피자배달거리_Solution_dfs {


    static class Main{
        static int[][] board;
        static List<int[]> home = new ArrayList<>();
        static List<int[]> pizza= new ArrayList<>();
        static int answer = Integer.MAX_VALUE;
        static int[] combis;


        static int n;
        static int m;

        public static void main(String[] args) {
            Scanner kb = new Scanner(System.in);
            n= kb.nextInt();
            m= kb.nextInt();
            combis= new int[m];
            board = new int[n][n];
            for (int i = 0; i <n; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = kb.nextInt();
                    if(board[i][j] ==1){
                        home.add(new int[] {i,j});
                    }
                    if(board[i][j] ==2) {
                        pizza.add(new int[]{i, j});
                    }
                }
            }
            dfs(0,0);
            System.out.println(answer);
        }

        public static void dfs(int level, int num){
            if(level == m){
                int sum =0;
                for (int[] person : home) {
                    int dis = Integer.MAX_VALUE;
                    for (int combi : combis) {
                        dis = Math.min(dis, Math.abs(person[0] - pizza.get(combi)[0]) +
                            Math.abs(person[1] - pizza.get(combi)[1]));
                    }
                    sum += dis;
                }
                answer = Math.min(answer,sum);
           }else{
               for(int i = num; i< pizza.size();i++) {
                   combis[level] = i;
                   dfs(level+1, i+1);
               }
           }
        }
    }
}
