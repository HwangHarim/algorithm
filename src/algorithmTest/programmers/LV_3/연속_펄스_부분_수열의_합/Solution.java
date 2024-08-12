package algorithmTest.programmers.LV_3.연속_펄스_부분_수열의_합;

class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        long answer1 = 0;
        long answer2 = 0;
        boolean isPlus = true;

        for (int number : sequence) {
            answer1 += isPlus ? number : -number;
            answer2 += isPlus ? -number : number;
            answer1 = Math.max(0, answer1);
            answer2 = Math.max(0, answer2);
            answer = Math.max(answer, Math.max(answer1, answer2));

            isPlus = !isPlus;
        }

        return answer;
    }
}
