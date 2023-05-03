package algorithmTest.programmers.LV_1.폰켓몬_문제;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    static int[] ss = {1,1,3,4};
    public static void main(String[] args) {
        System.out.println(solution(ss));
    }

    public static int solution(int[] nums){
        int answer = 0;

        List<Integer> numbers = new ArrayList<>();
        for(int i: nums){
            numbers.add(i);
        }
        Set<Integer> set = new HashSet<>(numbers);
        List<Integer> result = new ArrayList<>(set);

        if(result.size()< numbers.size()/2){
            answer = result.size();
        }

        if(result.size()> numbers.size()/2){
            answer = numbers.size()/2;
        }

        if(result.size()== numbers.size()/2){
            answer = numbers.size()/2;
        }

        return answer;
    }
}