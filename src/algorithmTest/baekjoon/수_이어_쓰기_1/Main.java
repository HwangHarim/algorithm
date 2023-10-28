package algorithmTest.baekjoon.수_이어_쓰기_1;

import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String number = br.readLine();
        int answer=0;
        for(int i=1; i<=number.length();i++){
            if(i == number.length()){
                if(i<2){
                    System.out.println(number);
                    return;
                }
                answer += (Integer.parseInt(number)-Math.pow(10,i-1)+1)*i;
                System.out.println(answer);
            }else{
                    answer += (9*Math.pow(10,i-1))*i;
            }
        }
    }
}
