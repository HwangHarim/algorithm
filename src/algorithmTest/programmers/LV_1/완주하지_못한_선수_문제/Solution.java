package algorithmTest.programmers.LV_1.완주하지_못한_선수_문제;

import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
        String[] participant={"leo", "kiki", "eden","eden"};
        String[] completion={"leo", "kiki","eden"};
        solution(participant,completion);
    }
    public static String solution(String[] participant, String[] completion) {
        HashMap<String, String> init = new HashMap<>();
        for(int i = 0; i < participant.length; i++){
            init.put(participant[i],"1");
        }

        String answer = "";


        return answer;
    }

}
