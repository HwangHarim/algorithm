package algorithmTest.programmers.LV_3.부대복귀;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    ArrayList[] map;
    int[] graph;
    int[] answer;

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        answer = new int[sources.length];
        graph = new int[n + 1];
        Arrays.fill(graph, -1);
        map = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < roads.length; i++) {
            int a = roads[i][0];
            int b = roads[i][1];

            map[a].add(b);
            map[b].add(a);
        }

        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(destination);
        graph[destination] = 0;

        while (!dq.isEmpty()) {
            int now = dq.poll();
            int len = map[now].size();

            for (int j = 0; j < len; j++) {
                int next = (int) map[now].get(j);
                if (graph[next] == -1) {
                    graph[next] = graph[now] + 1;
                    dq.offer(next);
                }
            }
        }

        for (int i = 0; i < sources.length; i++) {
            answer[i] = graph[(int) sources[i]];
        }

        return answer;
    }
}