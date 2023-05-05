package algorithmTest.inflearn.dfs.조합구하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 조합구하기_Solution {

    static class Main{
        static int n;
        static int m;
        static int[] pm;

        public static void main(String[] args) throws Exception{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] input = br.readLine().split(" ");
            n = Integer.parseInt(input[0]);
            m = Integer.parseInt(input[1]);
            pm = new int[m];
            dfs(0, 1);
        }

        public static void dfs(int L, int s){
            if(L == m){
                for(int x : pm){
                    System.out.print(x+" ");
                }
                System.out.println();
            }else{
                for(int i=s; i<=n; i++){
                  pm[L] = i;
                  dfs(L+1,s+1);
                }
            }
        }
    }
}