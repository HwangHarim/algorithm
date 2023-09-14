package algorithmTest.baekjoon.단어_뒤집기2;

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String words = br.readLine();
        Stack<String> stack = new Stack<>();
        Queue<String> queue = new LinkedList<>();


        boolean flag = false;
        StringBuilder sb = new StringBuilder();
            for(String s :words.split("")){
                if(s.equals(" ")){
                    while (!stack.empty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(" ");
                    continue;
                }
                if(s.equals("<")){
                    if(!stack.empty()){
                        while(!stack.empty()){
                            sb.append(stack.pop());
                        }
                    }
                    sb.append(s);
                    flag =true;
                    continue;
                }
                if(s.equals(">")){
                    sb.append(s);
                    flag =false;
                    continue;
                }

                if(flag){
                    sb.append(s);
                }else{
                    stack.push(s);
                }
            }
            if(!stack.empty()){
                while (!stack.empty()) {
                    sb.append(stack.pop());
                }
            }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}