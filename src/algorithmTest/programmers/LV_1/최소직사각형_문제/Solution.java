package algorithmTest.programmers.LV_1.최소직사각형_문제;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {
        int[][] sizes = {{60,50},{30,70},{80,40}};
        System.out.println(solution(sizes));
    }
    public static int solution(int[][] sizes) {
        int answer = 0;
        int idx =0;
        for (int i = 0; i < sizes.length; i++) {
              if(sizes[i][idx]<=sizes[i][idx+1]){
                  int temp = sizes[i][idx];
                  sizes[i][idx] = sizes[i][idx + 1];
                  sizes[i][idx + 1] = temp;
              }
        }
        Arrays.sort(sizes, (o1, o2) -> o2[0] - o1[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);

        for (int[] size : sizes) {
            pq.offer(size);
        }

        answer = sizes[0][0] * pq.poll()[1];

        return answer;
    }
}
