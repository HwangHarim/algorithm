package algorithmTest.programmers.LV_3.섬_연결;

import java.util.*;

class Solution {

    /**
     * 풀이 - 그리드 탐색
     * 최소 신장 트리 - 사이클이 존재하지 않고, 최소의 합을 구할 때
     * 풀이 배열 정렬 -> 부모 비교 -> 다르면 같게 변경 -> 합 구하기
     * Union-find
     */
    public int find(int[] parent, int node){
        if(parent[node] == node){
            return node;
        }
        return parent[node] = find(parent, parent[node]);
    }

    public void union(int[] parent, int a, int b){
        a = find(parent, a);
        b = find(parent, b);

        if(a!=b){
            parent[b] = a;
        }
    }
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[] parent = new int[n];

        for(int i =0; i<n; i++){
            parent[i] = i;
        }
        Arrays.sort(costs, (o1,o2) -> o1[2] - o2[2]);

        for(int i =0; i<costs.length; i++){
            if(find(parent, costs[i][0]) != find(parent, costs[i][1])){
                answer += costs[i][2];
                union(parent, costs[i][0], costs[i][1]);
            }
        }

        return answer;
    }
}
