package algorithmTest.softeer.금고털이;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<int[]> jw = new ArrayList<>();
        int answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        int limit = Integer.parseInt(st.nextToken());
        int jws = Integer.parseInt(st.nextToken());

        for(int i =0; i<jws; i++){
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            jw.add(new int[] {cost, count});
    }

        Collections.sort(jw,(o1, o2) ->o2[1]-o1[1]);

    int now = limit;
        for(int i = 0; i<jw.size();i++){
        if(now >= jw.get(i)[0]){
            now -= jw.get(i)[0];
            answer += jw.get(i)[0]*jw.get(i)[1];
        } else if(now < jw.get(i)[0]){
            answer += now*jw.get(i)[1];
            break;
        }
    }

        bw.write(String.valueOf(answer));

        br.close();
        bw.close();

}
}

