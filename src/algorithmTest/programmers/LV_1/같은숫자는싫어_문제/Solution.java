package algorithmTest.programmers.LV_1.같은숫자는싫어_문제;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
       int[] arr = {1, 1, 3, 3, 0, 1, 1};
        System.out.println(solution(arr));
    }
    public static List<Integer> solution(int[] arr) {
        List<Integer> result = new ArrayList<>();
        for(int s : arr){
            if(result.size() ==0){
                result.add(s);
            }
            if(result.get(result.size() - 1) !=s){
                result.add(s);
            }
        }
        return result;
    }
}