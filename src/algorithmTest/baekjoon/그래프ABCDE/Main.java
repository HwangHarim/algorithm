package algorithmTest.baekjoon.그래프ABCDE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main{

    static ArrayList[] map;
    static boolean[] visited;
    static int personCount, lineCount;
    static int answer = 0;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        personCount = Integer.parseInt(st.nextToken());
        lineCount = Integer.parseInt(st.nextToken());

        map = new ArrayList[personCount];
        visited = new boolean[personCount];

        for(int i =0; i<personCount; i++){
            map[i] = new ArrayList<Integer>();
        }

        for(int i =0; i<lineCount;i++){
            StringTokenizer init = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(init.nextToken());
            int y = Integer.parseInt(init.nextToken());

            map[x].add(y);
            map[y].add(x);
        }

        for(int i=0; i<personCount; i++){
            Arrays.fill(visited, false);
            dfs(i,0);

            if(answer == 1){
                break;
            }
        }


        System.out.println(answer);
        br.close();
    }

    public static void dfs(int index, int level){
        if(level == 5){
            answer = 1;
            return;
        }

        visited[index] = true;
        for(int i =0; i<map[index].size();i++){
            if(!visited[(int) map[index].get(i)]){
                dfs((Integer) map[index].get(i), level+1);
            }

            if(answer == 1){
                return;
            }
        }
        visited[index] = false;
    }
}