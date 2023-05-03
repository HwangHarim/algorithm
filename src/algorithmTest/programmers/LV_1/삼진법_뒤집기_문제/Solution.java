package algorithmTest.programmers.LV_1.삼진법_뒤집기_문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        solution(45);
    }

    public static int solution(int n) {
        List<String> initNum = new ArrayList<>();

        int answer = 0;
        String[] init = Integer.toString(n,3).split("");

        initNum.addAll(Arrays.asList(init));

        Collections.reverse(initNum);

        StringBuilder result = new StringBuilder();

        for(String s : initNum){
            result.append(s);
        }

        answer = Integer.parseInt(result.toString(),3);

        return answer;
    }
}
