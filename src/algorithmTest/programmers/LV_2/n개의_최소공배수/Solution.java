package algorithmTest.programmers.LV_2.n개의_최소공배수;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        int[] init = {2,6,8,14};
        System.out.println(solution(init));
    }


    public static int solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int count =1;

        for(int i : arr){
            list.add(i);
        }

        Collections.sort(list, Collections.reverseOrder());


        int max = list.get(0);
        list.remove(0);

        while(true){
            int trueCount= 0;
            for(int number : list){
                if(((double)(max*count)%(double)number) == 0){
                    trueCount++;
                }
            }

            if(trueCount == list.size()) break;
            count++;
        }

        return max*count;
    }
}