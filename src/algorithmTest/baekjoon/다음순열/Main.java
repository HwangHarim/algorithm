package algorithmTest.baekjoon.다음순열;

import java.util.*;
import java.io.*;

class Main{
    static ArrayList<int[]> answers = new ArrayList<>();
    static boolean[] visited;
    static int n;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        visited = new boolean[n+1];

        for(int i =0; i<n;i++){
            dfs(i+1, "");
            visited[i+1] = false;
        }


        int[] init = new int[n];

        for(int i=0;i<n;i++){
            init[i] = Integer.parseInt(st.nextToken());
        }
        int index =0;
        for(int i=0; i< answers.size();i++){
            if(Arrays.equals(answers.get(i), init)){
                index = i;
                break;
            }
        }

        if(index == answers.size() - 1){
            System.out.println(-1);
            return;
        }

        System.out.println(Arrays.toString(answers.get(index + 1)));
    }

    public static void dfs(int index, String number){


        visited[index] = true;
        number += String.valueOf(index);

        if(number.length() == n){
            answers.add(converter(number));
            return;
        }

        for(int i =1; i<=n;i++){
            if(!visited[i]){
                dfs(i, number);
                number.substring(0, number.length()-1);
                visited[i] = false;
            }
        }
    }

    public static int[] converter(String num){
        int[] result = new int[n];
        for(int i=0; i<n;i++){
            result[i] = Character.getNumericValue(num.charAt(i));
        }

        return result;
    }
}
