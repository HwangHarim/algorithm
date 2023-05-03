package algorithmTest.programmers.LV_1.자릿수_더하기_문제;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution(123));
    }

    public static int solution(int n) {
        int answer = 0;
        String number = String.valueOf(n);
        List<String> initNums = new ArrayList<>(List.of(number.split("")));
        for(String num : initNums){
            answer += Integer.parseInt(num);
        }
        return answer;
    }
}
