package algorithmTest.programmers.LV_1.나누어떨어지는숫자배열_문제;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        int[] arr ={2,36,1,3};
        int divisor =1;
        solution(arr, divisor);
    }

    public static List<Integer> solution(int[] arr, int divisor) {
        List<Integer> result = new ArrayList<>();
        for(int init:arr){
            if(init%divisor == 0){
                result.add(init);
            }
        }
        Collections.sort(result);
        if(result.size()==0){
            result.add(-1);
        }
        return result;
    }
}
