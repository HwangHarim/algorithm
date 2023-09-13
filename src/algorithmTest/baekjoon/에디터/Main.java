package algorithmTest.baekjoon.에디터;

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Stack<String> stackL = new Stack<>();
        Stack<String> stackR = new Stack();

        String words = br.readLine();

        for(String word : words.split("")){
            stackL.push(word);
        }

        int round = Integer.parseInt(br.readLine());

        for(int i =0; i<round; i++){
            st = new StringTokenizer(br.readLine());
            switch(st.nextToken()){
                case "L" :
                    if(!stackL.empty()){
                        stackR.push(stackL.pop());
                    }
                    break;
                case "D" :
                    if(!stackR.empty()){
                        stackL.push(stackR.pop());
                    }
                    break;
                case "B" :
                    if(!stackL.empty()){
                        stackL.pop();
                    }
                    break;
                case "P" :
                    stackL.push(st.nextToken());
                    break;
            }
        }
        while(!stackL.empty()){
            stackR.push(stackL.pop());
        }
        StringBuilder sb = new StringBuilder();
       while(!stackR.empty()){
            sb.append(stackR.pop());
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}