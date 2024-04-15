package algorithmTest.programmers.LV_3.단속카메라;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;

        Arrays.sort(routes, Comparator.comparingInt(o -> o[1]));
        //(o1, o2) -> o1[1] - o2[1] -> Comparator.comparingInt(o -> o[1])

        int cam = Integer.MIN_VALUE;

        for(int[] route : routes){
            if(cam < route[0]){
                answer++;
                cam = route[1];
            }
        }

        return answer;
    }
}
