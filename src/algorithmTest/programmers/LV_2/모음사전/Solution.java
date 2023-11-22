package algorithmTest.programmers.LV_2.모음사전;

import java.util.*;

class Solution {
    static String[] words = {"A","E","I","O","U"};
    static String str = "";
    static int answer = 0;
    static int number;
    static String target;

    public static void main(String[] args) {
        System.out.println(solution("I"));
    }

    public static int solution(String word) {
        target = word;

        for(int i = 0; i < words.length; i++){
            dfs(1, words[i]);
        }
        return number;
    }

    public static void dfs(int level, String str){

        if(target.equals(str)){
            answer++;
            number = answer;
            return;
        }

        if(5== level){
            answer++;
            return;
        }
        if(5 < level) {
            return;
        }

        answer++;

        for(int i = 0; i < words.length; i++){
            dfs(level+1, str+words[i]);
        }
    }
}
