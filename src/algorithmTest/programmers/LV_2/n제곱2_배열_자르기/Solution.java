package algorithmTest.programmers.LV_2.n제곱2_배열_자르기;

import algorithmTest.inflearn.dfs.동전교환.동전문제_Solution;
import java.util.*;

class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(4, 7, 14)));
    }


    public static int[] solution(int n, long left, long right) {

        int[] answer = new int[(int) (right - left + 1)];

        long startI = left / n;
        long startJ = left % n;
        long endI = right / n;
        long endJ = right % n;

        int index = 0;

        for (long i = startI; i <= endI; i++) {
            if (i == startI) {
                for (long j = startJ; j < n; j++) {
                    if (j <= i) {
                        for (long k = j; k <= i; k++) {
                            answer[index] = (int) i + 1;
                            index++;
                            j++;
                        }
                        j--;
                        continue;
                    }
                    answer[index] = (int) j + 1;
                    index++;
                }
            } else if (i == endI) {
                for (long j = 0; j <= endJ; j++) {
                    if (j == 0 && i < endJ) {
                        for (long k = 0; k <= i; k++) {
                            answer[index] = (int) i + 1;
                            index++;
                            j++;
                        }
                        j--;
                        continue;
                    } else if(j == 0 && i >= endJ){
                        for (long k = 0; k <= endJ; k++) {
                            answer[index] = (int) i + 1;
                            index++;
                            j++;
                        }
                        j--;
                        continue;
                    }
                    answer[index] = answer[index-1]+1;
                    index++;
                }
            } else {
                for (long j = 0; j < n; j++) {
                    if (j == 0) {
                        for (long k = 0; k <= i; k++) {
                            answer[index] = (int) i + 1;
                            index++;
                            j++;
                        }
                        j--;
                        continue;
                    }
                    answer[index] = (int) j + 1;
                    index++;
                }
            }
        }

        return answer;
    }
}

