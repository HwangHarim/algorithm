package algorithmTest.programmers.LV_1.음양더하기_문제;

public class Solution {

    public static void main(String[] args) {

    }

    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for (int i = 0; i < absolutes.length; i++) {
            if (signs[i]) {
                answer += absolutes[i];
                continue;
            }
            answer -= absolutes[i];
        }
        return answer;
    }
}
