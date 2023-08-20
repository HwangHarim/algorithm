package algorithmTest.programmers.LV_2.최대_최솟값_구하기;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        String s = "-1 3 5 6 7 9";
        System.out.println(solution(s));
    }

    public static String solution(String s){
        String[] init =  s.split(" ");
        int[] numbers = new int[init.length];
        String answer = "";

        for(int i =0; i< init.length; i++){
            numbers[i] = Integer.parseInt(init[i]);
        }

        Arrays.sort(numbers);

        answer += String.valueOf(numbers[0]);
        answer += " ";
        answer += String.valueOf(numbers[init.length - 1]);

        return answer;
    }
}
