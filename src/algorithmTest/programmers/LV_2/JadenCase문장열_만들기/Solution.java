package algorithmTest.programmers.LV_2.JadenCase문장열_만들기;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution("3people unFollowed  me"));
    }

    public static String solution(String s) {
        s = s.toLowerCase();
        boolean check = true;
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                check = true;
            } else if (check) {
                c = Character.toUpperCase(c);
                check = false;
            }
            sb.append(c);
        }

        return sb.toString();
    }
}
/**
 * StringBuffer answer = new StringBuffer();
 *         boolean firstCheck = true;
 *         boolean check = false;
 *
 *         for(int i =0; i<s.length();i++){
 *             String in = String.valueOf(s.charAt(i));
 *
 *             if(in.equals(" ")) {
 *                 firstCheck = true;
 *             }
 *             if(!in.equals(" ")){
 *                 if(firstCheck){
 *                     answer.append(in.toUpperCase());
 *                     firstCheck = false;
 *                     check = true;
 *                 }else{
 *                     answer.append(in.toLowerCase());
 *                     check = true;
 *                 }
 *             }else  if(check) {
 *                 answer.append(" ");
 *                 check = false;
 *             }
 *         }
 *         if(!" ".equals(answer.toString().substring(answer.length()-1, answer.length()))){
 *             answer.deleteCharAt(answer.lastIndexOf(" "));
 *         }
 *         return answer.toString();
 */