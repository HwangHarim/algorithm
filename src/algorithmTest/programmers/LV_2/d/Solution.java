package algorithmTest.programmers.LV_2.d;

import java.util.ArrayList;

class Solution {

    static int[][] map;
    static ArrayList<Integer>[] mapping;
    static boolean[] visited;
    static boolean[] moveVisited;
    static int count = 0;
    static int limit;

    public static void main(String[] args) {

        int[][] init  = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};

        System.out.println(solution(6, init, 4));
    }

    public static  int solution(int N, int[][] road, int K) {
        map = new int[N+1][N+1];
        mapping = new ArrayList[N+1];
        visited = new boolean[N+1];
        moveVisited = new boolean[N+1];
        limit = K;

        for(int i =0; i<mapping.length; i++){
            mapping[i] = new ArrayList<>();
        }

        for(int i =0; i<road.length; i++){
            int x = road[i][0];
            int y = road[i][1];
            int time = road[i][2];

            mapping[x].add(y);
            mapping[y].add(x);

            if(map[x][y] == 0){
                map[x][y] = time;
            }else{
                map[x][y] = Math.min(map[x][y], time);
            }

            if(map[y][x] == 0){
                map[y][x] = time;
            }else{
                map[y][x] = Math.min(map[y][x], time);
            }

        }

        dfs(1, 0);

        for (int i = 1; i < moveVisited.length; i++) {
          if(moveVisited[i]){
              count++;
          }
        }

        return count;
    }

    public static  void dfs(int index, int sumTime){

        if(limit < sumTime){
            return;
        }
        moveVisited[index] = true;
        visited[index] = true;

        for(int i = 0; i < mapping[index].size(); i++){
            if(!visited[mapping[index].get(i)]){
                dfs(mapping[index].get(i), sumTime + map[index][mapping[index].get(i)]);
                visited[mapping[index].get(i)] = false;
            }
        }
    }
}