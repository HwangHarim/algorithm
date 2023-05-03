package algorithmTest.programmers.LV_1.문자열을_정수로_바꾸기_문제;


public class Solution {

    public static void main(String[] args) {
        System.out.println(solution("-1234"));
    }
    public static int solution(String s) {
       if(s.contains("-")){
           s = s.substring(1);
           return -(Integer.parseInt(s));
       }
       return Integer.parseInt(s);
    }
}
