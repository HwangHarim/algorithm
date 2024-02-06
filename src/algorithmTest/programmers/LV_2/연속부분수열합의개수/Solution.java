package algorithmTest.programmers.LV_2.연속부분수열합의개수;
import java.util.*;

/**
 * 중복제거 : Set 개수 생각하기
 * 배열의 인덱스를 돌고 도는 방법 -> %길이
 */
class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();

        int start = 1;

        while(start <= elements.length){
            for(int i =0; i<elements.length; i++){
                int value =0;
                for(int j =i; j<i+start;j++){
                    value += elements[j%elements.length];
                }
                set.add(value);
            }
            start++;
        }
        return set.size();
    }
}
