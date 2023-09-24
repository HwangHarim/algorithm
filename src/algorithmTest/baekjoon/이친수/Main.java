package algorithmTest.baekjoon.이친수;


import java.io.*;

class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N+1][2];

        dp[1][0] = 0;
        dp[1][1] = 1;

        for(int i =2; i<=N; i++){
            for(int j =0;j<2;j++){
                if(j == 1){
                    dp[i][j] = dp[i-1][0];
                }else{
                    dp[i][j] = dp[i-1][0] + dp[i-1][1];
                }
            }
        }
        long answer =0;

        for(int i =0; i<2;i++){
            answer += dp[N][i];
        }

        long[] dy = new long[N+1];
        dy[0] =0;
        dy[1] =1;
        for(int i =2; i <=N; i++){
            dy[i] = dy[i-1] + dy[i-2];

        }
        long test = dy[N];
       for(int i =1; i<=N; i++){
           System.out.println( (dp[i][0]+dp[i][1]) == dy[i]);
       }

        br.close();
        bw.close();
    }
}