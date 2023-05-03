package algorithmTest.programmers.LV_1.두개뽑아서_더하기_문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        int[] numbers = {5, 0, 2, 7};
        System.out.println(Arrays.toString(solution(numbers)));
    }

    public static int[] solution(int[] numbers) {
        int idx =0;
        List<Integer> init = new ArrayList<>();

        for(int i=0; i<numbers.length; i++) {
            for(int j =i+1; j<numbers.length;j++){
                if(i== numbers.length-1){
                    break;
                }
                init.add(numbers[i]+numbers[j]);
            }
        }
        Set<Integer> results = new HashSet<>(init);

        int[] answer = new int[results.size()];
        for(int i:results){
            answer[idx++] = i;
        }
        Arrays.sort(answer);
        return answer;
    }
}
