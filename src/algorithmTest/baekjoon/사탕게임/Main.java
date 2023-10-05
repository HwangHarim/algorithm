package algorithmTest.baekjoon.사탕게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String[][] candies;
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        candies = new String[n][n];

        for(int i=0; i<n; i++){
            String[] arr = br.readLine().split("");
            for(int j =0; j<n; j++){
                candies[i][j] = arr[j];
            }
        }

        for(int i=0; i<n; i++){
            for(int j =0; j<n-1; j++){
                if(!candies[i][j].equals(candies[i+1][j])){
                   swap(i,j,i+1,j);
                   count();
                   swap(i+1,j, i,j);
                }
            }
        }

        for(int i=0; i<n-1; i++){
            for(int j =0; j<n; j++){
                if(!candies[i][j].equals(candies[i][j+1])){
                    swap(i,j, i,j+1);
                    count();
                    swap(i,j+1,i, j);
                }
            }
        }


        System.out.println(answer);
        br.close();
    }

    public static void swap(int a1,int a2,int b1,int b2){
        String tmp = candies[a1][a2];
        candies[a1][a2] = candies[b1][b2];
        candies[b1][b2] = tmp;
    }

    public static void count(){


        for(int i=0; i< candies.length; i++){
            int count =1;
            for(int j =0; j<candies[i].length-1; j++){

                if(candies[i][j].equals(candies[i][j+1])){
                    count++;
                    answer = Math.max(answer, count);
                }else{
                    count =1;
                }
            }
        }

        for(int i=0; i< candies.length; i++){
            int count =1;
            for(int j =0; j<candies[i].length-1; j++){

                if(candies[j][i].equals(candies[j+1][i])){
                    count++;
                    answer = Math.max(answer, count);
                }else{
                    count =1;
                }
            }
        }
    }
}
