package algorithmTest.baekjoon.더하기123;

import java.io.*;

public class Main {

    static int answer;
    static int number;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());

        while (count > 0) {
            answer = 0;
            number = Integer.parseInt(br.readLine());
            for(int i=1; i<4;i++){
                dfs(i);
            }

            bw.write(String.valueOf(answer));
            bw.newLine();

            count--;
        }

        br.close();
        bw.close();
    }

    public static void dfs(int index) {
        if (number == index) {
            answer++;
            return;
        }
        if (number < index) {
            return;
        }
        dfs(index + 1);
        dfs(index + 2);
        dfs(index + 3);
    }
}
