package algorithmTest.baekjoon.스택_수열;

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int round = Integer.parseInt(br.readLine());

        int start =0;
        while(round --> 0){
           int value = Integer.parseInt(br.readLine());
           if(value > start){
               for(int i =start+1 ; i<=value; i++){
                   stack.push(i);
                   sb.append("+").append('\n');
               }
               start = value;
           }

           else if(value != stack.peek()){
               bw.write("NO");
               br.close();
               bw.close();
               return;
           }

           stack.pop();
            sb.append("-").append('\n');
        }

        bw.write(sb.toString());

        bw.close();
        br.close();
    }
}