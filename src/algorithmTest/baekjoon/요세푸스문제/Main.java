package algorithmTest.baekjoon.요세푸스문제;
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

       Queue<Integer> queue = new LinkedList<>();

        for(int i = 1 ;i<=N;i++){
           queue.offer(i);
        }
        while(!queue.isEmpty()){
            for(int i = 1; i < K; i++){
                int num = queue.poll();
                queue.offer(num);
            }
            sb.append(queue.poll()).append(", ");
        }
        String answer = sb.substring(0, sb.length()-2);
        answer+=">";
        bw.write(answer);
        br.close();
        bw.close();
    }
}
