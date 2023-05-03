package algorithmTest.programmers.LV_1.중간문자_출력_문제;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution("setne"));
    }

    public static String solution(String s) {
        String answer = "";
        List<String> init = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            init.add(String.valueOf(s.charAt(i)));
        }
        if(init.size()%2 ==0){
            answer= init.get(init.size()/2);
            answer+=init.get(init.size()/2+1);
        }
        if(init.size()% 2 == 1){
            answer= init.get(init.size()/2);
        }
        return answer;
    }
}
