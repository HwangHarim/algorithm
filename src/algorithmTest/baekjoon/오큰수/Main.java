package algorithmTest.baekjoon.오큰수;

import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> arr = new ArrayList<>();
        int round = Integer.parseInt(br.readLine());
        Queue<Integer> qL = new LinkedList<>();
        Queue<Integer> qR = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean flag =false;
        for (int i = 0; i < round; i++) {
            qL.offer(Integer.parseInt(st.nextToken()));
        }

        for(int i=0; i<round; i++){
            int number = qL.poll();

            while(!qL.isEmpty()){
                if(number<qL.peek()){
                    sb.append(qL.peek()).append(" ");
                    flag = true;
                    break;
                }
            }
            if(!flag){
                sb.append("-1").append(" ");
            }
            while (!qL.isEmpty()) {
              qR.offer(qL.poll());
            }
            while (!qR.isEmpty()) {
                qL.offer(qR.poll());
            }
            
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}