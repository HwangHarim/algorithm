package algorithmTest.baekjoon.종이자르기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String arg[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> garo = new ArrayList<>();
        List<Integer> sero = new ArrayList<>();

        garo.add(Integer.parseInt(st.nextToken()));
        sero.add(Integer.parseInt(st.nextToken()));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int what = Integer.parseInt(st.nextToken());
            int line = Integer.parseInt(st.nextToken());

            if (what == 0) {
                int index;
                for (index = 0; line - sero.get(index) > 0; index++) {
                    line -= sero.get(index);
                }
                int temp = sero.remove(index);
                sero.add(index, temp - line);
                sero.add(index, line);
            } else {
                int index;
                for (index = 0; line - garo.get(index) > 0; index++) {
                    line -= garo.get(index);
                }
                int temp = garo.remove(index);
                garo.add(index, temp - line);
                garo.add(index, line);
            }
        }

        int max = 0;
        for (int i : garo) {
            for (int j : sero)
                max = Math.max(i * j, max);
        }
        System.out.println(max);

    }
}