package algorithmTest.programmers.LV_1.K번째수_문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        System.out.println(Arrays.toString(solution(array, commands)));
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i =0; i<commands.length; i++){
            List<Integer> numbers = new ArrayList<>();

            for(int num:array){
                numbers.add(num);
            }
            List<Integer> nums = numbers.subList(commands[i][0]-1,commands[i][1]);
            Collections.sort(nums);
            answer[i] = nums.get(commands[i][2]-1);
        }
        return answer;
    }
}