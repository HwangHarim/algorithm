package algorithmTest.programmers.LV_1.예산_문제;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] arr={2, 6, 83, 3};
        System.out.println(solution(arr, 10));
    }

    public static int solution(int[] d, int budget) {
        int answer = 0;
        int result = 0;

        int[] init = Arrays.stream(d).sorted().toArray();

        //d 부서의 개수 = d.length  budget = 최대 금액
        for (int j :init) {
            result += j;
            if (result > budget) {
               break;
            }
            answer++;
        }

        return answer;
    }

}
