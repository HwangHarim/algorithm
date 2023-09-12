package algorithmTest.baekjoon.괄호;

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();

        int round = Integer.parseInt(br.readLine());

        for(int i =0; i<round;i++){
            String init = br.readLine();
            String result = "NO";

            for(String word : init.split("")){
                if(stack.empty()&&word.equals("(")){
                    stack.push(word);
                    continue;
                }
                if(!stack.empty()&&stack.peek().equals("(")&&word.equals(")")){
                    stack.pop();
                    continue;
                }
                stack.push(word);
            }
            if(stack.empty()){
                result = "YES";
            }
            sb.append(result).append('\n');
            stack.clear();
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}