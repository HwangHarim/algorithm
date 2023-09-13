package algorithmTest.baekjoon.큐;

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        int init = Integer.parseInt(br.readLine());
        int last = 0;
        for(int i=0; i<init; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String commendWord = st.nextToken();


            switch(commendWord){
                case "push":
                        last = Integer.parseInt(st.nextToken());
                        queue.offer(last);

                    break;
                case "pop":
                        if(!queue.isEmpty()){
                            sb.append(queue.poll()).append('\n');
                        }else {
                          sb.append("-1").append('\n');
                        }
                    break;
                case "size":
                        sb.append(queue.size()).append('\n');
                    break;
                case "empty":
                        if (!queue.isEmpty()) {
                            sb.append("0").append('\n');
                        }else {
                            sb.append("1").append('\n');
                        }
                    break;
                case "front":
                    if (!queue.isEmpty()) {
                        sb.append(queue.peek()).append('\n');
                    }else {
                        sb.append("-1").append('\n');
                    }
                    break;
                case "back":
                    if (!queue.isEmpty()) {
                        sb.append(last).append('\n');
                    }else {
                        sb.append("-1").append('\n');
                    }
                    break;
            }
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }

}
