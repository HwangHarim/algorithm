package algorithmTest.baekjoon.날짜계산;

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int answer =0;
        int yearE =0;
        int yearS =0;
        int yearM =0;
        while(true){
            if(yearE ==E &&yearS ==S &&yearM ==M){
                break;
            }

            answer++;
            yearE++;
            yearS++;
            yearM++;
            if (yearE == 16) yearE=1;
            if (yearS==29) yearS=1;
            if (yearM==20) yearM=1;
            if(E == yearE &&S == yearS &&M == yearM){
                break;
            }
        }

        System.out.println(answer);
        br.close();
    }
}