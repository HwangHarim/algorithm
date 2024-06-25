package algorithmTest.softeer.연탄의크기;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int number = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> numbers = new ArrayList<>();
        int answer = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<number;i++){
            int num = Integer.parseInt(st.nextToken());
            max = Math.max(num, max);
            numbers.add(num);
        }

        Collections.sort(numbers);

        for(int i =2; i <=max;i++){
            int count = 0;
            for(int j =i; j<number; j++){
                if(numbers.get(j) % i == 0){
                    count+=1;
                }
            }
            answer = Math.max(answer, count);
        }

        bw.write(String.valueOf(answer));
        br.close();
        bw.close();
    }
}
