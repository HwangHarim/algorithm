package algorithmTest.baekjoon.단어뒤집기;

import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        String[] init = br.readLine().split(" ");

        for(String word : init){
            String[] words = word.split("");
            for(int i =words.length-1; 0<=i;i--){
                sb.append(words[i]);
            }
            sb.append(" ");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}