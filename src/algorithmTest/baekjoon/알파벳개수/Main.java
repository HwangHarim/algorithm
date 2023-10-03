package algorithmTest.baekjoon.알파벳개수;

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String words = br.readLine();
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for(int i ='a'; i<='z';i++){

            map.put((char) i, map.getOrDefault((char) i, 0));
        }

        for(char c : words.toCharArray()){
            map.put(c, map.get(c)+1);
        }

        for(int i ='a'; i<='z';i++){
            sb.append(map.get((char) i)).append(" ");
        }
        System.out.println(sb);
        br.close();
    }
}
