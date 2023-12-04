package algorithmTest.programmers.LV_2.테이블_해시_함수;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        int[][] a = {{2,2,6}, {1,5,10},{4,2,9},{3,8,3}};

        System.out.println(solution(a, 2,2,3));
    }

    public static int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.sort(data, (o1, o2) -> o1[col-1] != o2[col-1] ? o1[col-1] - o2[col-1] : o2[0] - o1[0]);

        for (int i = row_begin-1; i<= row_end-1;i++){
            int S_i = 0;
            for (int d: data[i]){
                S_i += (d % (i + 1));
            }
            answer = (answer ^ S_i);
        }

        return answer;
    }
}