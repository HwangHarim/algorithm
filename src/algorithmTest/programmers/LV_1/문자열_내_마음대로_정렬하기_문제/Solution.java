package algorithmTest.programmers.LV_1.문자열_내_마음대로_정렬하기_문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        String[] strings = {"sun", "bed", "car"};
        System.out.println(Arrays.toString(solution(strings, 1)));
    }

    public static String[] solution(String[] strings, int n) {
        List<String> init = new ArrayList<>();
        String[] answer = {};
        for(String s : strings){
            init.add(s.charAt(n)+s);
        }
        Collections.sort(init);
        answer = new String[init.size()];
        for(int i= 0;i<init.size(); i++){
           answer[i] = init.get(i).substring(1);
        }

        return answer;
    }
}

/*
 * 반성 :
 * 1. 문자열을 정렬이라고 하면 Collections.sort 생각하기
 * 2. substring 기능 암기하기
 * 3. 특정한 문자를 이야기 할 때는 charAt 항상 생각하기
 * **/
