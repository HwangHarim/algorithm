package algorithmTest.programmers.LV_1.체육복_문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        int[] lost ={3};
        int[] reserve ={1};
        System.out.println(solution(3,lost,reserve));
    }


    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        for (int i = 0; i < lost.length; i++) {
          for (int j = 0; j < reserve.length; j++ ) {
              if(lost[i] == reserve[j]){
                  answer++;
                  lost[i] = -1;
                  reserve[j] = -1;
                  break;
              }

          }
        }

        for (int k : lost) {
            for (int j = 0; j < reserve.length; j++) {
                if ((k - 1 == reserve[j]) || (k + 1 == reserve[j])) {
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        return answer;
    }
}
