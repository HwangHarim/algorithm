package algorithmTest.programmers.LV_1.제일_작은_수_제거하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        int[] arr = {10,3,4,5,9,7};
        System.out.println(Arrays.toString(solution(arr)));
    }

    public static int[] solution(int[] arr) {
        int min = arr[0];
        if(arr.length == 1){
            return new int[]{-1};
        }
        List<Integer>  result = new ArrayList<>();
        for (int j : arr) {
            min = Math.min(min, j);
        }
        for(int i: arr){
            if(i ==min){
                continue;
            }
            result.add(i);
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i <result.size(); i++) {
          answer[i] = result.get(i);
        }
        return answer;
    }
}
