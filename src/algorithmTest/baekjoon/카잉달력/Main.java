package algorithmTest.baekjoon.카잉달력;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int targetA = Integer.parseInt(st.nextToken());
            int targetB = Integer.parseInt(st.nextToken());
            boolean flag = false;
            int a = 0;
            int b = 0;
            for (int j = 1; j < 9999999; j++) {

                if (j % M == 0) {
                    a = M;
                    b = (b + 1) % N;
                    if (a == targetA && b == targetB) {
                        sb.append(j).append("\n");
                        flag = true;
                        break;
                    }

                } else if (j % N == 0) {
                    a = (a + 1) % M;
                    b = N;
                    if (a == targetA && b == targetB) {
                        sb.append(j).append("\n");
                        flag = true;
                        break;
                    }
                } else {
                    a = j % M;
                    b = j % N;
                    if (a == targetA && b == targetB) {
                        sb.append(j).append("\n");
                        flag = true;
                        break;
                    }
                }

            }
            if(!flag){
                sb.append(-1).append("\n");
            }
        }
        System.out.print(sb);
    }
}