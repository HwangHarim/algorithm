package algorithmTest.programmers.LV_3.아이템줍기;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    static int[][] dp;
    static boolean[][] visited;
    static int[] dx ={0,1,0,-1};
    static int[] dy ={1,0,-1,0};
    static int answer =0;
    public static void main(String[] args) {
        int[][] r = {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}};
        int cx=1;
        int cy =3;
        int ix=7;
        int iy=8;
        System.out.println(Solution.solution(r,cx,cy,ix,iy));
    }


    //character->item(목표 포인트)
    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int cX = characterX*2;
        int cY = characterY*2;
        int iX = itemX*2;
        int iY = itemY*2;
        dp = new int[103][103];
        visited = new boolean[103][103];

        for(int[] rec : rectangle){
            shape(rec[0]*2,rec[2]*2,rec[1]*2,rec[3]*2);
        }

        bfs(cX,cY, iX, iY);
        return answer/2;
    }

    public static void shape(int lX, int rX, int lY, int rY){
        for(int i=lX;i<=rX;i++){
            for(int j=lY;j<=rY;j++){
                if(dp[i][j] == 2) continue;
                dp[i][j] =2;
                if(i==lX||i==rX||j==lY||j==rY){
                    dp[i][j] =1;
                }
            }
        }
    }

    public static void bfs(int characterX, int characterY, int itemX, int itemY){
        Queue<Point> q= new LinkedList<>();
        q.offer(new Point(characterX,characterY));
        while(!q.isEmpty()){
            Point tmp = q.poll();

            for(int i=0;i<4;i++){
                int nx = tmp.x+dx[i];
                int ny = tmp.y+dy[i];

                if(nx>0&&nx<103&&ny>0&&ny<103&&!visited[nx][ny]&&dp[nx][ny]==1){
                    dp[nx][ny] = dp[tmp.x][tmp.y]+1;
                    if(nx == itemX&& ny==itemY){
                        answer = (answer==0)?dp[nx][ny]:Math.min(answer,dp[nx][ny]);
                        continue;
                    }
                    visited[nx][ny] =true;
                    q.offer(new Point(nx, ny));
                }
            }
        }
    }
}

class Point{
    int x;
    int y;
    public Point(int x, int y){
        this.x =x;
        this.y=y;
    }
}