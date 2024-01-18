package algorithmTest.programmers.LV_2.광물캐기;

import java.util.Collections;
import java.util.Arrays;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int cnt = Math.min(minerals.length/5+1,picks[0]+picks[1]+picks[2]);
        int[][] session = new int[cnt][3];

        int dia=0, iron=0, stone =0;

        for(int i =0; i<minerals.length; i+=5){
            if(i/5 == cnt){
                break;
            }
            for(int j =i; j<i+5; j++){
                if(minerals[j].equals("diamond")){
                    dia +=1;
                    iron +=5;
                    stone +=25;
                }else if(minerals[j].equals("iron")){
                    dia +=1;
                    iron +=1;
                    stone +=5;
                }else{
                    dia +=1;
                    iron +=1;
                    stone +=1;
                }
                if(j == minerals.length-1){
                    break;
                }
            }
            session[i/5][0] = dia;
            session[i/5][1] = iron;
            session[i/5][2] = stone;

            dia = iron = stone = 0;
        }

        Arrays.sort(session, (o1,o2) -> (o2[2] - o1[2]));

        for(int i = 0; i<cnt; i++){
            if(picks[0] != 0){
                answer+= session[i][0];
                picks[0]--;
            } else if(picks[1] != 0){
                answer+= session[i][1];
                picks[1]--;
            } else if(picks[2] != 0){
                answer+= session[i][2];
                picks[2]--;
            }
        }

        return answer;
    }
}
