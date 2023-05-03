package algorithmTest.programmers.LV_1.두_정수_사이의_합_문제;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution(-10, 100));
    }

    public static long solution(int a, int b) {
        long answer=0;
        if(a == b){
            answer = a;
            return answer;
        }if(a>b){
            for (long i = b; i <= a; i++) {
              answer+=i;
            }
        }if(a<b){
            for (long i = a; i <= b; i++) {
                answer+=i;
            }
        }
        return answer;
    }
}
