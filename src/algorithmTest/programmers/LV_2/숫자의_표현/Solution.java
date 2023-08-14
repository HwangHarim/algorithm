package algorithmTest.programmers.LV_2.숫자의_표현;

import java.util.*;

class Solution {
    public static int solution(int n) {
        int answer = 1;
        double N = n;

        for(double i=2; i<= N;i++){
            double sum=0;
            for(double j = i-1;0<j;j--){
                sum +=j;
            }
            if(N-sum<=0){
                break;
            }
            double start = (N-sum)/i;
            if(start == (int) start && calculate(n, (int) i, (int) start)){
                answer++;
            }
        }

        return answer;
    }

    public static boolean calculate(int target, int idx, int start){
        int sum = 0;
        for(int i =0;i<idx;i++){
            sum += (start+i);
        }
        return sum == target;
    }

    public static void main(String[] args) {
        System.out.println(solution(15));
    }
}
