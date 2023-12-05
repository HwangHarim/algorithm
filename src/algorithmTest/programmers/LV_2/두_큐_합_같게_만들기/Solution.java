package algorithmTest.programmers.LV_2.두_큐_합_같게_만들기;

import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int target = 0;
        int answer = 0;
        long sum1 =0;
        long sum2 =0;
        Queue<Integer> a1 = new LinkedList<>();
        Queue<Integer> a2 = new LinkedList<>();

        for(int i =0; i < queue1.length; i++){
            a1.offer(queue1[i]);
            sum1 += (long) queue1[i];

            a2.offer(queue2[i]);
            sum2 += (long) queue2[i];

            target += (long) (queue1[i] + queue2[i]);
        }

        if(target%2 != 0){
            return -1;
        }

        int index = 0;
        target = target/2;

        while(sum1 != sum2){
            if(answer > (queue1.length + queue2.length) * 2){
                return -1;
            }
            if(sum1 < sum2){

                long number2 = (long) a2.poll();

                sum1 += number2;
                sum2 -= number2;
                a1.offer((int) number2);
            }
            else if(sum2<sum1){
                long number1 = (long) a1.poll();
                sum1 -= number1;
                sum2 += number1;

                a2.offer((int) number1);
            }
            else{
                return answer;
            }
            answer++;

        }

        return answer;
    }
}