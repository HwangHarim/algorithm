package algorithmTest.programmers.LV_1.소수_찾기_문제;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution(10));
    }
    public static int solution(int n) {
        int answer = 0;
        int[] init = new int[n+1];
        for(int i = 2; i <= n; i++){
            init[i] = i;
        }

        for (int i = 0; i <n; i++) {
            if(init[i] == 0){continue;}

            for (int j = 2*i;  j< n; j=+i) {
                init[i] = 0;
            }
        }

        for (int i = 0; i <n; i++) {
            if(init[i] != 0){answer++;}
        }

        return answer;
    }
}