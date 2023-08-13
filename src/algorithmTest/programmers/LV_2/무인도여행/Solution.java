package algorithmTest.programmers.LV_2.무인도여행;

import java.util.*;

class Solution {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int x,y;
    static int[][] numberMaps;
    static int numberCount;
    static boolean[][] visited;
    static List<Integer> answer;

    static class Point{
        int x,y;
        public Point(int x, int y){
            this.x =x;
            this.y =y;
        }

        public int getX(){
            return x;
        }

        public int getY(){
            return y;
        }
    }

    public static  List<Integer> solution(String[] maps) {

        x = maps[0].length();
        y = maps.length;
        numberCount = 0;
        numberMaps = new int[y][x];
        answer = new ArrayList<>();
        visited = new boolean[y][x];

        for(int i=0;i<y;i++){
            String[] xLength = maps[i].split("");
            for(int j = 0;j<x;j++){
                if(xLength[j].equals("X")){
                    visited[i][j] = true;
                }else{
                    numberCount++;
                    numberMaps[i][j] = Integer.parseInt(xLength[j]);
                }
            }
        }

        if(numberCount == 0){
            answer.add(-1);
            return answer;
        }

        for(int i=0;i<y;i++){
            for(int j = 0;j<x;j++){
                if(!visited[i][j]){
                    bfs(new Point(j,i));
                }
            }
        }

        Collections.sort(answer);
        return answer;
    }

    public static  void bfs(Point point){

        int sum = numberMaps[point.y][point.x];
        visited[point.y][point.x] = true;
        Queue<Point> q = new LinkedList<>();
        q.offer(point);
        while(!q.isEmpty()){
            Point now = q.poll();

            int x1 = now.getX();
            int y1 = now.getY();

            for(int i=0; i<4;i++){
                int nx = x1 +dx[i];
                int ny = y1 +dy[i];

                if(nx<0 || x<=nx ||ny<0 || y<=ny)
                    continue;

                if(!visited[ny][nx]){
                    visited[ny][nx] = true;
                    sum += numberMaps[ny][nx];
                    q.offer(new Point(nx, ny));
                }
            }
        }
        answer.add(sum);
    }

    public static void main(String[] args) {
        String[] maps = {"X591X","X1X5X","X231X", "1XXX1"} ;
        for(int sol :solution(maps)){
            System.out.println(sol + " ");
        }
    }
}