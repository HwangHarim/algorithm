package algorithmTest.baekjoon.알파벳찾기;

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Character, Integer> checkMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for(int i ='a'; i<='z';i++){
            checkMap.put((char) i, checkMap.getOrDefault((char) i, -1));
        }


        String words = br.readLine();

        for(int i =0; i<words.length();i++){
            if(checkMap.get(words.charAt(i))==-1){
                checkMap.put(words.charAt(i), i);
            }

        }

        for(int i ='a'; i<='z';i++){
            sb.append(checkMap.get((char) i)).append(" ");

        }
        System.out.println(sb);
    }
}
