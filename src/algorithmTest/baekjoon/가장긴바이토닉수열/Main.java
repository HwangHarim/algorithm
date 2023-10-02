package algorithmTest.baekjoon.가장긴바이토닉수열;

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] seq = new int[n];
        int[] dpU = new int[n];
        int[] dpD = new int[n];
        int max =0;
        StringTokenizer st = new StringTokenizer(br.readLine());


        for(int i=0; i<n;i++){
            seq[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n;i++){
            dpU[i] =1;
            for(int j=0; j<i; j++) {
                if (seq[j] < seq[i] && dpU[i] <= dpU[j]) {
                    dpU[i] = dpU[j] + 1;
                }
            }
        }


        for(int i=n-1; 0<=i;i--){
            dpD[i] =1;
            for(int j=n-1; i<j; j--) {
                if (seq[j] < seq[i] && dpD[i] <= dpD[j]) {
                    dpD[i] = dpD[j] + 1;
                }
            }
        }

        for(int i=0; i<n;i++){
            max = Math.max(max, dpU[i]+dpD[i]);
        }
        System.out.println(max-1);
        br.close();
    }
}
