package algorithmTest.softeer.XmarksTheSpot;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int number = Integer.parseInt(br.readLine());
        String[][] words = new String[number][2];
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<number;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            words[i][0] = st.nextToken();
            words[i][1] = st.nextToken();
        }

        for(String[] word : words){
            for(int i =0; i<word[0].length(); i++){
                if(word[0].charAt(i) == 'x' || word[0].charAt(i) == 'X'){
                    char c = word[1].charAt(i);
                    if('A'<= c && c<='Z'){
                        sb.append(Character.toLowerCase(c));
                    } else{
                        sb.append(c);
                    }
                }
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
