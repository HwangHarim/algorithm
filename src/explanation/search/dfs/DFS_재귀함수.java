package explanation.search.dfs;

import java.util.Scanner;

public class DFS_재귀함수 {


    static int edge;
    static int vertex;
    static int[][] map;
    static boolean[] visit;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        vertex = sc.nextInt(); //정점의 수
        edge = sc.nextInt(); //간선의 수
        map = new int[vertex+1][vertex+1];//정점간의 연결의 정보를 담는 객체
        visit = new boolean[vertex+1];//정점을 방문했는지 체크하기 위한 객체

        for(int i=0; i<edge;i++){
            int start = sc.nextInt();
            int next = sc.nextInt();

            map[start][next] = 1;
            map[next][start] = 1;
        }
        dfs(1);
    }

    public static void dfs(int v){
        visit[v] = true;
        System.out.print(v+" ");
        for(int i=1; i<vertex + 1; i++){
            if(map[v][i] == 1&&visit[i]==false) {
                dfs(i);
            }
        }
    }
}
