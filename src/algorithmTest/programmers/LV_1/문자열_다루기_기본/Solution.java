package algorithmTest.programmers.LV_1.문자열_다루기_기본;


public class Solution {

    public static void main(String[] args) {
        System.out.println(solution("2123123"));
    }

    public static boolean solution(String s) {

        if(s.length() == 4 || s.length() == 6) {
            try {
                Integer.parseInt(s);
                return true;
            } catch (NumberFormatException ex) {
                return false;
            }
        }
        return true;
    }
}
