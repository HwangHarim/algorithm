package algorithmTest.programmers.LV_2.짝지어제거하기;

import java.util.*;

public class Main {

    public static void main(String[] args) {

    }

    public int solution(String s){

        char[] carr = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<carr.length; i++){
            char c = carr[i];

            if(stack.isEmpty()) stack.push(c);

            else{
                if(stack.peek() == c){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }
        }

        return stack.isEmpty() ? 1: 0;
    }

}
