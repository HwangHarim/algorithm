package algorithmTest.programmers.LV_3.디스크_컨트롤러;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {
        int[][] jobs={{0,3}, {2,6},{1,9}};
        System.out.println(solution(jobs));
    }

    public static int solution(int[][] jobs) {
        int count= 0;
        int end= 0;
        int jobIdx =0;
        int answer=0;

        Arrays.sort(jobs, (o1, o2) -> o1[0]-o2[0]);

        PriorityQueue<int[]> queue = new PriorityQueue<>(((o1, o2) -> o1[1]-o2[1]));

        while(count < jobs.length){
            while (jobIdx<jobs.length&&jobs[jobIdx][0]<=end) {
                queue.offer(jobs[jobIdx++]);
            }
            if(queue.isEmpty()){
                end = jobs[jobIdx][0];
            }else{
                int[] temp = queue.poll();
                answer += end - temp[0] + temp[1];
                end+=temp[1];
                count++;
            }
        }
        return (int)Math.floor(answer / jobs.length);
    }
}

