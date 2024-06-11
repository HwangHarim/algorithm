package algorithmTest.leetCode.dfs;

class Solution {
    static boolean[][] visited;
    static int x,y;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public static int numIslands(char[][] grid) {
        y = grid.length;
        x = grid[0].length;
        int answer =0;
        visited= new boolean[y][x];

        for(int i =0; i< y; i++){
            for(int j =0; j<x; j++){
                if(grid[i][j]=='1'){
                    visited[i][j] = true;
                }
            }
        }

        for(int i =0; i< y; i++){
            for(int j =0; j<x; j++){
                if(visited[i][j]){
                    dfs(j,i);
                    answer++;
                }
            }
        }
        return answer;
    }

    public static  void dfs(int id_x, int id_y){
        visited[id_y][id_x] = false;

        for(int i =0; i<4; i++){
            int nx = id_x + dx[i];
            int ny = id_y + dy[i];

            if(nx<0||x<=nx||ny<0||y<=ny){
                continue;
            }

            if(visited[ny][nx]){
                dfs(nx, ny);
            }
        }
    }
}