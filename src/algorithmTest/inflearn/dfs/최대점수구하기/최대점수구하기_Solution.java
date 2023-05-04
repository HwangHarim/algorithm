package algorithmTest.inflearn.dfs.최대점수구하기;

import java.io.*;

public class 최대점수구하기_Solution {
    static class Main{
        static int answer=0;
        static int m;//제안 시간
        static int n;//문제 개수
        public static void main(String[] args) throws Exception{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            String input1 = bf.readLine();
            String[] input = input1.split(" ");
            n = Integer.parseInt(input[0]);
            m = Integer.parseInt(input[1]);
            int[] answers = new int[n];
            int[] answerTime =  new int[n];
            for (int i = 0; i < n; i++) {
              String inputScore = bf.readLine();
              String[] sores = inputScore.split(" ");
              answers[i] = Integer.parseInt(sores[0]);
              answerTime[i] = Integer.parseInt(sores[1]);
            }
            bf.close();
            dfs(0,0,0,answers,answerTime);
            System.out.println(answer);
        }

        public static void dfs(int i,  int answerSum, int timeSum, int[] answers, int[] answerTime){
            if(timeSum>m){
                return;
            }
            if(i==n){
                answer = Math.max(answer, answerSum);
            }else{
                dfs(i+1,answerSum+answers[i], timeSum+answerTime[i], answers, answerTime);
                dfs(i+1,answerSum, timeSum, answers, answerTime);
            }
        }
    }
}