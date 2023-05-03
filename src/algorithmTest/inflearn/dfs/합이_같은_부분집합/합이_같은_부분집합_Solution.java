package algorithmTest.inflearn.dfs.합이_같은_부분집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 합이_같은_부분집합_Solution {

    static class Main {
        static boolean flag = false;
        static String ANSWER = "NO";
        static int s, total = 0;
        public static void main(String[] args) throws IOException {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            s = Integer.parseInt(bf.readLine());
            String n = bf.readLine();
            String[] ns = n.split(" ");
            bf.close();
            int[] numbers = new int[ns.length];
            for (int i = 0; i < numbers.length; i++) {
                total += Integer.parseInt(ns[i]);
                numbers[i] = Integer.parseInt(ns[i]);
            }

            dfs(0, 0, numbers);
            System.out.println(ANSWER);
        }

        // 멈추는 지점 정하기, 실행할 활동 정하기
        public static void dfs(int i, int sum, int[] array) {
            if (flag||i==s) {
                return;
            }
            if (sum > total / 2) {
                return;
            }
            if (i == s-1) {
                if ((total - sum) == sum) {
                    ANSWER = "YES";
                    flag = true;
                }
            }else{
                dfs(i + 1, sum + array[i], array);
                dfs(i + 1, sum, array);
            }
        }
    }
}