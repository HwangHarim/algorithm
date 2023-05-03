package algorithmTest.programmers.LV_1.문자열_내림차순으로_정렬;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution("Zbcdefg"));
    }

    public static String solution(String s) {
        //Arrays.sort -> 배열을 정렬하는 방식
        String[] sorts = s.split("");
        Arrays.sort(sorts);
        List<String> result = new ArrayList<>(List.of(sorts));
        Collections.reverse(result);

        return String.join("", result);
    }
}
/*
*  String[] answer = s.split("");
        Arrays.sort(answer);
        Collections.reverse(Arrays.asList(answer));

        return String.join("", answer);
* 배열 Arrays.sort로 정렬후
* Collection으로 정렬(정렬에 대한 함수 정리하기)
* **/