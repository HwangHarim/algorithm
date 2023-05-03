package algorithmTest.programmers.LV_1.달력_문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution(5,24));
    }
    public static String solution(int a, int b) {
        int dayNumbers = 0;

        List<Integer> one = new ArrayList<>(
            Arrays.asList(1, 3,5,7,8,10)
        );
        List<Integer> zero = new ArrayList<>(
            Arrays.asList(4,6,9,11)
        );

        String[] day = {"THU","FRI","SAT","SUN","MON","TUE","WED"};

        for(int i=1;i<a;i++){
            if(one.contains(i)){
                dayNumbers+=31;
            }else if(zero.contains(i)){
                dayNumbers+=30;
            }else if(i ==2){
                dayNumbers+=29;
            }
        }
        dayNumbers+=b;
        return day[dayNumbers%7];
    }
}