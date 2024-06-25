package algorithmTest.softeer.진정한효도;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        int answer = Integer.MAX_VALUE;
        int[][] board = new int[3][3];
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i =0; i<3; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            board[i][0] = Integer.parseInt(st.nextToken());
            board[i][1] = Integer.parseInt(st.nextToken());
            board[i][2] = Integer.parseInt(st.nextToken());
        }

        for(int i =1; i<=3; i++){

            for(int j = 0; j<3; j++){
                int all_x =0;
                int all_y =0;
                for(int k= 0; k<3;k++){
                    int sum_x = Math.abs(i - board[j][k]);
                    int sum_y = Math.abs(i - board[k][j]);
                    if(sum_x != 0){
                        all_x += sum_x;
                    }
                    if(sum_y !=0){
                        all_y += sum_y;
                    }
                }

                answer = Math.min(answer, all_x);
                answer = Math.min(answer, all_y);

            }
        }

        bw.write(String.valueOf(answer));
        br.close();
        bw.close();
    }
}
