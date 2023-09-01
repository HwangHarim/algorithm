package algorithmTest.baekjoon.N과M_2;

import java.util.*;
import java.io.*;
import javax.print.DocFlavor.STRING;

public class Main {

    static int n, m;
    static boolean[] visited;
    static ArrayList<String> results = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            dfs(i, "");
        }

        for(String answers : results){
            for(String answer : answers.split("")){
                bw.write(answer+" ");
            }
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    public static void dfs(int index, String num) {
        if (num.length() == m) {
           if(!results.contains(num)){
               results.add(num);
           }
           return;
        }

        for (int i = index; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                num += String.valueOf(i);
                dfs(i, num);
                visited[i] = false;
                num = num.substring(0,num.length()-1);
            }
        }
    }
}