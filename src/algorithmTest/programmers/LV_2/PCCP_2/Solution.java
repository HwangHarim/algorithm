package algorithmTest.programmers.LV_2.PCCP_2;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {1, 0, -1, 0};
    static int x,y;

    static boolean[][] visited;
    static int[][] board;

    static int count =1;

    static int answer = Integer.MIN_VALUE;
    static  HashMap<Integer, Integer> boardMap = new HashMap<>();


    public static int solution(int[][] land) {
        y = land.length;
        x = land[0].length;

        visited = new boolean[y][x];
        board = new int [y][x];

        for(int i =0; i<y; i++){
            for(int j=0; j<x; j++){
                if(land[i][j] == 1){
                    visited[i][j] = true;
                }
            }
        }

        int index = 1;

        for(int i =0; i<y; i++){
            for(int j=0; j<x; j++){
                if(visited[i][j]){
                    dfs(1, j, i, index);
                    boardMap.put(index , count);
                    count = 1;
                    index++;
                }
            }
        }

        for(int i =0; i < x; i++){
            List<Integer> number = new ArrayList<>();
            for(int j=0; j < y; j++){
                if(!number.isEmpty() && board[j][i] != 0 && !number.contains(board[j][i])){
                    number.add(board[j][i]);
                } else if(board[j][i] != 0&& !number.contains(board[j][i])){
                    number.add(board[j][i]);
                }
            }
            int sum =0;
            for(int id : number){
                sum += boardMap.get(id);
            }
            answer = Math.max(answer, sum);
        }

        return answer;
    }

    public static void dfs(int level, int index_x, int index_y, int index){


        visited[index_y][index_x] = false;
        board[index_y][index_x] = index;

        for(int i =0; i<4; i++){
            int nx = index_x+dx[i];
            int ny = index_y+dy[i];

            if(nx < 0 || x <= nx|| ny < 0 || y <= ny){
                continue;
            }

            if(visited[ny][nx]){
                count++;
                dfs(level++, nx, ny, index);
            }
        }
    }

    public static void main(String[] args) {
       int[][] a = {{1, 0, 1, 0, 1, 1},{1, 0, 1, 0, 0, 0},{1, 0, 1, 0, 0, 1},{1, 0, 0, 1, 0, 0},{1, 0, 0, 1, 0, 1},{1, 0, 0, 0, 0, 0},{1, 1, 1, 1, 1, 1}};
        System.out.println(solution(a));
    }
}