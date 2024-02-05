package algorithmTest.programmers.LV_2.영어끝말잇기;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        int n = 2;
        String[] arr = {"hello", "one", "even", "never", "now", "world", "draw"};
        System.out.println(Arrays.toString(solution(n, arr)));

    }
    public static int[] solution(int n, String[] words) {
        Set<String> wordSet = new HashSet<>();

        for(int i =0; i< words.length; i++){
            wordSet.add(words[i]);
            if(0<i){
                if(wordSet.size() != i+1 || words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)){
                    int number = i%n+1;
                    int round = (i+1)/n;
                    if((i+1)%n !=0){
                        round++;
                    }
                    return new int[] {number, round};
                }
            }
        }

        return new int[] {0,0};
    }
}