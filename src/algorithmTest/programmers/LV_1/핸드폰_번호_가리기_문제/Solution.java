package algorithmTest.programmers.LV_1.핸드폰_번호_가리기_문제;


public class Solution {

    public static void main(String[] args) {
        System.out.println(solution("01033334444"));
    }

    public static String solution(String phone_number) {
        String[] str = phone_number.split("");
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < phone_number.length(); i++){
            if(i < phone_number.length()-4) {
                str[i] = "*";
                answer.append(str[i]);
                continue;
            }
            answer.append(str[i]);
        }

        return answer.toString();
    }

}
