package algorithmTest.programmers.LV_1.문자열_문제;

public class Solution {

    public static void main(String[] args) {
            System.out.println(solution(String.valueOf(Example_Init.AAACCTTADNTTS)));
    }

    enum Example_Init{
        BANANA, AAACCTTADNTTS
    }
    public static int solution(String s) {
        char first =s.charAt(0);
        int answer =0;
        int count=0;
        int different = 0;

        for(int i=0; i<s.length();i++){
            if(count == different){
                answer++;
                first = s.charAt(i);
            }
            if(first == s.charAt(i)){
                count++;
            }
            if(first != s.charAt(i)){
                different++;
            }
        }
        return answer;
    }
}