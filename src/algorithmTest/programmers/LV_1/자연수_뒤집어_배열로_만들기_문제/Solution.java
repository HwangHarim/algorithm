package algorithmTest.programmers.LV_1.자연수_뒤집어_배열로_만들기_문제;

import java.util.Arrays;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(12345)));
    }


    public static int[] solution(long n) {
        String[] init = String.valueOf(n).split("");
        Stack<Integer> reverse = new Stack<>();
        for(String s : init){
            reverse.push(Integer.parseInt(s));
        }
        int[] answer = new int[init.length];
        for(int i =0;i<init.length;i++){
            answer[i] = reverse.pop();
        }

        return answer;
    }
}

/*
*return new StringBuilder().append(n).reverse().chars().map(Character::getNumericValue).toArray();
* **/