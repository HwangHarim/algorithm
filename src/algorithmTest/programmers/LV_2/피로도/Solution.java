package algorithmTest.programmers.LV_2.피로도;

import java.util.*;

class Solution {


    static int status;
    static boolean[] visited;
    static int answer = Integer.MIN_VALUE;

    static List<Dungeon> dungeonList = new ArrayList<>();

    public static void main(String[] args) {
        int[][] a = {{80,20},{20,40},{30,10}};
        System.out.println(solution(80, a));
    }

    static class Dungeon{
        int limit, minus;

        public Dungeon(int limit, int minus){
            this.limit = limit;
            this.minus = minus;
        }
    }

    public static int solution(int k, int[][] dungeons) {
        status = k;
        visited = new boolean[dungeons.length];

        for(int i =0; i<dungeons.length; i++){
            dungeonList.add(new Dungeon(dungeons[i][0], dungeons[i][1]));
        }

        dfs(0, status);


        return answer;
    }


    public static void dfs(int level, int hp){

        for(int i = 0; i< dungeonList.size(); i++){
            if(!visited[i] && dungeonList.get(i).limit<= hp){
                visited[i] = true;
                dfs(level+1, hp - dungeonList.get(i).minus);
                visited[i] = false;
            }
            answer = Math.max(answer, level);
        }
    }
}