package algorithmTest.programmers.LV_3.미로탈출명령어;

import java.util.*;

class Solution {



    public static boolean[][] visited;
    public static Point start;
    public static Point end;


    public static int[] dy = {1,0,0,-1};
    public static int[] dx = {0,-1,1,0};

    public static String[] move = {"d","l","r","u"};
    public static int target;
    static int n,m;
    static String answer =  null;
    static StringBuffer log;
    public static void main(String[] args) {
        System.out.println(solution(3,4,2,3,3,1,5));
    }
    public static String solution(int n, int m, int x, int y, int r, int c, int k) {
        Solution.n = n;
        Solution.m = m;
        start = new Point(x,y);
        end = new Point(r,c);
        log = new StringBuffer();
        target = k;
        if((k - getLength(start)) % 2 == 1 || k < getLength(start)) return "impossible";
        dfs(0, start);

        return answer == null ? "impossible" : answer;
    }

    public static void dfs(int deap, Point point){
        if(answer != null){
            return;
        }
        if(target < deap + getLength(point)){
            return;
        }

        if(deap == target){
            answer = log.toString();
            return;
        }

        for(int i =0; i < 4; i++){
            Point nowPoint = new Point(point.point_1 + dy[i], point.point_2+dx[i]);

            if(nowPoint.point_1 <= 0 || n<nowPoint.point_1 || nowPoint.point_2<=0 || m <nowPoint.point_2){
                continue;
            }

            log.append(move[i]);
            dfs(deap+1, nowPoint);
            log.delete(deap, deap+1);
        }


    }

    public static int getLength(Point point){
        return Math.abs(point.point_1-end.point_1) + Math.abs(point.point_2 - end.point_2);
    }


    static class Point{
        int point_1, point_2;

        public Point(int point_1, int point_2){
            this.point_1 = point_1;
            this.point_2 = point_2;
        }
    }
}