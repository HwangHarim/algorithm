package algorithmTest.baekjoon.문자열분석;

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String words;
        StringBuilder sb = new StringBuilder();
        while((words = br.readLine()) != null){
            int[] count = new int[4];
            for(int i=0; i<words.length();i++){
                if('A'<=words.charAt(i)&&words.charAt(i)<='Z'){
                    count[1] +=1;
                    continue;
                }
                if('a'<=words.charAt(i)&&words.charAt(i)<='z'){
                    count[0] +=1;
                    continue;
                }
                if('0'<=words.charAt(i)&&words.charAt(i)<='9'){
                    count[2] +=1;
                    continue;
                }if(words.charAt(i)==' ') {
                    count[3] += 1;
                }
            }
            for(int n : count){
                sb.append(n).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}