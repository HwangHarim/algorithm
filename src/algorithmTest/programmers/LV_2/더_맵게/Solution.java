package algorithmTest.programmers.LV_2.더_맵게;

import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {
    int[] a={10,0,3,0,0,1,4,7,2};
    int k =1;
    System.out.println(solution(a,k));
    int i = 1000000000;
    }

    public static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> initNums = new PriorityQueue<>();
        for(int number : scoville){
            initNums.offer(number);
        }
        int answer = 0;
        int successScoville = 0;

        while(initNums.size()>1&& (initNums.peek() < K)){

            int first = initNums.poll();
            int second = initNums.poll();

            successScoville = first + second*2;
            initNums.offer(successScoville);

            answer++;
        }

        if(initNums.size() ==1&&initNums.peek()<K){
            return -1;
        }

        return answer;

    }
}
