package algorithmTest.programmers.LV_1.약수의_갯수_덧셈_문제;

public class Solution {

    public static void main(String[] args) {

    }

    public int solution(int left, int right) {
        int answer = 0;

        for(int i = left; i <= right; i++){
            if(count(i)%2==0){
                answer += i;
                continue;
            }
            answer -= i;
        }
        return answer;
    }

    public int count(int number){
        int count = 0;
        for(int i = 0; i <= number; i++){
            if(number%i == 0) count++;
        }

        return count;
    }

}
