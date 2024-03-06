package algorithmTest.programmers.LV_3.인사평가;

import java.util.*;
public class Solution {

    public int solution(int[][] scores){
        int answer =0;
        int score_1 = scores[0][0];
        int score_2 = scores[0][1];

        Arrays.sort(scores, (o1,o2) -> {
           if(o1[0] == o2[0]){
               return o1[1] - o2[1]; // 내림차순
           }
           return o2[0] - o1[0];
        });

        int maxScore = scores[0][1];

        for(int i =1; i<scores.length; i++){
            if(scores[i][1] < maxScore){
                if(scores[i][0]==score_1 && scores[i][1] == score_2){
                    return -1;
                }

                scores[i][0] = -1;
                scores[i][1] = -1;
            }else {
                maxScore = scores[i][1];
            }
        }
        answer =1;

        for(int i =0; i< scores.length; i++){
            if(scores[i][0]+scores[i][1] > score_1 + score_2){
                answer++;
            }else{
                break;
            }
        }

        return answer;
    }
}
