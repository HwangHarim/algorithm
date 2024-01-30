package algorithmTest.programmers.LV_2.일이사_나라의_숫자;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        System.out.println(solution(15));
    }
    public static String solution(int n) {
        String[] nums = {"4","1","2"};
        List<String> numbers = new ArrayList<>();
        String answer ="";
        int number = n;
        while(n !=0){
            int index = n%3;
            n /= 3;
            if(index == 0){
                n--;
            }
            numbers.add(nums[index]);
        }
        Collections.reverse(numbers);

        for(String word : numbers){
            answer += word;
        }

        return answer;
    }
}