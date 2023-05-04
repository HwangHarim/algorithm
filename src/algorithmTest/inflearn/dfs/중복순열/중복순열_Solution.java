package algorithmTest.inflearn.dfs.중복순열;

import java.io.*;
public class 중복순열_Solution {
    // N번까지
    // M번 뽑기
    static class Main {
        static int n;
        static int m;
        static int[] pm;
     public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input1 = br.readLine();
        String[] input2 = input1.split(" ");

        n = Integer.parseInt(input2[0]);
        m = Integer.parseInt(input2[1]);
        pm = new int[m];
        dfs(0);
     }

     public static void dfs(int L){
         if(L==m){
             for(int x : pm) {
                 System.out.print(x + " ");}
                 System.out.println();

         }else{
             for(int i=1; i<=n; i++){
                 pm[L] = i;
                 dfs(L+1);
             }
         }

     }
    }
}
