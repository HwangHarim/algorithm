package algorithmTest.programmers.LV_1.이상한_문자_만들기_문제;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution("java string plus null open ten vnxtss enenbndix tttenene"));
    }
    public static String solution(String s) {
        List<String> init = new ArrayList<>(List.of(s.split(" ")));
        StringBuilder answer = new StringBuilder();

        for(String str : init){
            List<String> changer = new ArrayList<>(List.of(str.split("")));
            for (int i = 0; i <changer.size(); i++) {
              String result = i%2 == 0? changer.get(i).toUpperCase(): changer.get(i).toLowerCase();
              answer.append(result);
            }
            answer.append(" ");
        }

        return answer.substring(0,answer.length()-1);
    }
}
/* 비슷한 답
*String answer = "";
        int cnt = 0;
        String[] array = s.split("");

        for(String ss : array) {
            cnt = ss.contains(" ") ? 0 : cnt + 1;
            answer += cnt%2 == 0 ? ss.toLowerCase() : ss.toUpperCase();
        }
      return answer;
* **/