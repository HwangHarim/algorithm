package algorithmTest.programmers.LV_1.시저_암호_문제;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution("a B z", 2));
    }

    public static String solution(String s, int n) {
        String answer = "";

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isLowerCase(ch)) { //소문자
                ch = (char) ((ch - 'a' + n) % 26 + 'a');
            } else if (Character.isUpperCase(ch)) { //대문자
                ch = (char) ((ch - 'A' + n) % 26 + 'A');
            }
            answer += ch;
        }

        return answer;
    }
}

