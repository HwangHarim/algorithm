package algorithmTest.baekjoon.오등큰수;

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int[] count = new int[1000001];
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N;i++){
            int index = Integer.parseInt(st.nextToken());
            arr[i] = index;
            count[index] += 1;
        }

        for(int i=0; i<N;i++){
            while(!stack.empty()&& count[arr[stack.peek()]]<count[arr[i]]){
                arr[stack.pop()] = arr[i];
            }

            stack.push(i);
        }
        while(!stack.empty()){
            arr[stack.pop()] = -1;
        }

        for(int answer : arr){
            sb.append(answer).append(" ");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}