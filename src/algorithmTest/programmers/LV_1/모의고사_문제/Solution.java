package algorithmTest.programmers.LV_1.모의고사_문제;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        int[] init = {1,2,3,4,5};
        solution(init);
    }

    /*
    1번 수포자가 찍는 방식: 1, 2, 3, 4, 5
    2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5
    3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5

    **/
    public static int[] solution(int[] answers) {


        int[] one = {1, 2, 3, 4, 5};
        int[] two ={2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] result = {0,0,0};

        for(int i = 0; i < answers.length; i++){
            if(answers[i] == one[i%5]){
                result[0]++;
            }
            if(answers[i] == two[i%8]){
                result[1]++;
            }
            if(answers[i] == three[i%10]){
                result[2]++;
            }
        }

        int max = Math.max(result[0],Math.max(result[1], result[2]));

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i< result.length; i++) {
          if(max == result[i]){
             numbers.add(i+1);
          }
        }

        int[] answer =new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
          answer[i] = numbers.get(i);
        }

        return answer;
    }
}
