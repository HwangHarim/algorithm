package algorithmTest.programmers.LV_1.정수_내림차순_정렬_문제;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution(1234));
    }

    public static long solution(long n) {
        String[] initNum = String.valueOf(n).split("");
        Arrays.sort(initNum);
        StringBuilder init = new StringBuilder();
        for(String s : initNum){
            init.append(s);
        }
        return Long.parseLong(init.reverse().toString());
    }
}
/*
*String[] list = String.valueOf(n).split("");
        Arrays.sort(list);

        StringBuilder sb = new StringBuilder();
        for (String aList : list) sb.append(aList);

        return Long.parseLong(sb.reverse().toString());
* **/