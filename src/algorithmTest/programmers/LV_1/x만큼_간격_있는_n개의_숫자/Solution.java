package algorithmTest.programmers.LV_1.x만큼_간격_있는_n개의_숫자;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(2, 5)));
    }

    public static long[] solution(int x, int n) {
        long[] answer = new long[n];

        for(int i = 1; i <= n; i++){
            answer[i-1] = (long) i*x;
        }

        return answer;
    }

}
