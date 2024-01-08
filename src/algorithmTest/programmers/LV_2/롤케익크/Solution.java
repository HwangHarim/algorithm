package algorithmTest.programmers.LV_2.롤케익크;

import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer =0;
        Map<Integer, Integer> dro1 = new HashMap<>();
        Map<Integer, Integer> dro2 = new HashMap<>();

        for(int top : topping){
            dro2.put(top, dro1.getOrDefault(top,0) +1 );
        }

        for(int top : topping){
            dro1.put(top, dro1.getOrDefault(top ,0) +1);


            if(dro2.get(top) -1 == 0){
                dro2.remove(top);
            }else{
                dro2.put(top, dro2.get(top) -1);
            }

            if(dro1.size() == dro2.size()){
                answer++;
            }
        }

        return answer;
    }
}
