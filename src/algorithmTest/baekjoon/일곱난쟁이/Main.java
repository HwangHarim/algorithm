package algorithmTest.baekjoon.일곱난쟁이;

import java.util.*;
import java.io.*;

class Main{

    static  StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum =0;
        int[] dwarfs = new int[9];
        for(int i=0; i<9; i++){
            dwarfs[i] = Integer.parseInt(br.readLine());
            sum += dwarfs[i];
        }

        for(int i=0;i<8;i++){
            for(int j=i+1; j<9;j++){
                if(sum - dwarfs[i] - dwarfs[j] == 100){
                    dwarfs[i] =0;
                    dwarfs[j] =0;
                    Arrays.sort(dwarfs);
                    for(int k =2; k<=8; k++){
                        System.out.println(dwarfs[k]);
                    }
                    return;
                }
            }
        }
        br.close();
    }
}
