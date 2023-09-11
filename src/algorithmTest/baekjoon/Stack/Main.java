package algorithmTest.baekjoon.Stack;

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();

        int init = Integer.parseInt(br.readLine());

        for(int i=0; i<init; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String commendWord = st.nextToken();

            switch(commendWord){
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if(!stack.empty()){
                        bw.write(String.valueOf(stack.pop()));
                        bw.newLine();
                    }else{
                        bw.write(String.valueOf(-1));
                        bw.newLine();
                    }
                    break;
                case "size":
                    bw.write(String.valueOf(stack.size()));
                    bw.newLine();
                    break;
                case "empty":
                    if(stack.empty()){
                        bw.write("1");
                        bw.newLine();
                    }else{
                        bw.write("0");
                        bw.newLine();
                    }
                    break;
                case "top":
                    if(!stack.empty()){
                        bw.write(String.valueOf(stack.peek()));
                        bw.newLine();
                    }else{
                        bw.write("-1");
                        bw.newLine();
                    }
                    break;
            }
        }

        br.close();
        bw.close();
    }

}
