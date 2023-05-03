package algorithmTest.programmers.LV_1.없는_숫자_더하기_문제;

public class Solution {

    public static void main(String[] args) {

    }

    public int solution(int[] numbers) {
        int answer = 45;

        for (int number : numbers) {
            answer -= number;
        }

        return answer;
    }
}