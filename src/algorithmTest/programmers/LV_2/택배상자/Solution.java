package algorithmTest.programmers.LV_2.택배상자;

import java.util.*;
class Solution {

    public int solution(int[] order) {
        int answer = 0;
        int orderRang = order.length;
        int index = 0;
        Stack<Integer> sub = new Stack<>();

        for(int i = 1; i<=orderRang; i++){
            if(order[index] == i){
                answer++;
                index++;
                while(!sub.isEmpty() && sub.peek() == order[index]){
                    sub.pop();
                    answer++;
                    index++;
                }
                continue;
            }

            sub.push(i);
        }
        return answer;
    }
}