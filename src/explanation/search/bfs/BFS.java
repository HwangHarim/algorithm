package explanation.search.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    static int edge;
    static int vertex;
    static Boolean[] visit;
    static int[][] map;

    public static void main(String[] args) {

    }

    public static void bfs(int i){
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        visit[i] = true;

        while(!q.isEmpty()){
            int temp = q.poll();
            System.out.println(temp+" ");
            for(int j=1;j<vertex+1;j++){
                if(map[temp][j] == 1&& visit[j] == false){
                    q.offer(j);
                    visit[j] =true;
                }
            }
        }
    }
}
