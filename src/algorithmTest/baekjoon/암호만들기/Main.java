package algorithmTest.baekjoon.암호만들기;

import java.util.*;
import java.io.*;

public class Main {

    static boolean[] visited;
    static ArrayList<String> answers = new ArrayList<>();
    static String[] member;

    static int L, C;
    static String[] words = {"a", "e", "i", "o", "u"};

    static boolean flag=false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        member = br.readLine().split(" ");
        Arrays.sort(member);


        visited = new boolean[member.length];

        for (int i = 0; i < C; i++) {
            dfs(i, member[i]);
        }

        for (String j : answers) {
            bw.write(j);
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    public static void dfs(int index, String password) {
        if (password.length() == L) {
            for (String word : words) {
                if (password.contains(word)) {
                    flag =true;
                    break;
                }
            }
            if(flag){
                String a = password;
                for (String word: words) {
                    a.replaceAll(word, "");
                }
                if(2 <= a.length()){
                    answers.add(password);
                    flag = false;
                    return;
                }
            }

            return;
        }
        visited[index] = true;

        for (int i = index; i < C; i++) {
            if (!visited[i]) {
                dfs(i, password + member[i]);
                visited[i] = false;
            }
        }
    }
}
