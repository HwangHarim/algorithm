package algorithmTest.programmers.LV_2.쵯솟값만들기;

import java.util.*;

class Solution
{
    public int solution(int []A, int[] B)
    {
        int answer = 0;
        Arrays.sort(A);
        Integer[] Barr =  Arrays.stream(B).boxed().toArray(Integer[]::new);
        Arrays.sort(Barr, Collections.reverseOrder());

        for(int i=0; i<A.length;i++){
            answer += A[i]*Barr[i];
        }
        return answer;
    }
}