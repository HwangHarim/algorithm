package algorithmTest.programmers.LV_2.송전탑_2개로나누기;

import java.util.*;

class Solution {

    static ArrayList<Integer>[] list;
    static int min;
    static boolean[] visited;

    static void dfs(int n, int v1, int v2) {
        for(int num : list[n]) {
            if((n==v1 && num==v2) || (n==v2 && num==v1)) continue; // 3
            if(!visited[num]) { // 4
                visited[num] = true;
                dfs(num,v1,v2);
            }
        }
    }

    public int solution(int n, int[][] wires) {
        int answer = -1;
        list = new ArrayList[n+1];
        min = n;
        // 1
        for(int i=1; i<=n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            list[v1].add(v2);
            list[v2].add(v1);
        }

        for(int i=0; i<wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            visited = new boolean[n+1];
            visited[1] = true;
            // 2
            dfs(1,v1,v2);
            // 5
            int cnt = 0;
            for(int j=1; j<visited.length; j++) {
                if(visited[j]) cnt++;
            }
            min = Math.min(min, Math.abs(n-(2*cnt)));
        }

        answer = min;

        return answer;
    }
}