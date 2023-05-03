package algorithmTest.inflearn.dfs.바둑이_승차;

import java.io.*;

public class 바둑이_승차_Solution {

    static class Main {

        static int answer=0;
        static int weight;
        static int total;

        public static void main(String[] args) throws Exception{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            String input1 = bf.readLine();
            String[] inputs =input1.split(" ");
            weight =  Integer.parseInt(inputs[0]);
            total =  Integer.parseInt(inputs[1]);
            int[] dogs = new int[total];
            for(int i=0; i<total;i++){
                dogs[i] = Integer.parseInt(bf.readLine());
            }
            bf.close();

            dfs(0,0,dogs);
            System.out.println(answer);
        }

        public static void dfs(int i,int sum, int[] dogs){
            if(sum>weight){
                return;
            }
            if(i==total){
                answer = Math.max(answer, sum);
            }else {
                dfs(i+1, sum+dogs[i], dogs);
                dfs(i+1, sum, dogs);
            }
        }
    }

}
