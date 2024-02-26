package algorithmTest.programmers.LV_2.할인행사;

import java.util.Map;
import java.util.HashMap;

class Solution {

    public static void main(String[] args) {
        String[] a = {"banana", "apple", "rice", "pork", "pot"};
        int[] n = {3, 2, 2, 2, 1};
        String[] d ={"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        System.out.println(solution(a,n,d));
    }

    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> order = new HashMap<>();




        for(int i =0; i<=discount.length-10; i++){
            for(int j =0; j<want.length; j++){
                order.put(want[j], number[j]);
            }
            if(checkOrder(order, discount, i)){
                answer++;
            }
        }


        return answer;
    }

    public static boolean checkOrder(Map<String, Integer> order, String[] discount, int start){
        int length = order.size();

        for(int i = start; i<start+10; i++){
            if(!order.containsKey(discount[i])){
                continue;
            }
            int orderNumber = order.get(discount[i]);
            if(orderNumber != 0){
                order.put(discount[i], orderNumber-1);
            }
        }

        for(int value : order.values()){
            if(value == 0){
                length--;
            }
        }

        return length == 0;

    }
}