package algorithmTest.programmers.LV_1.서울에서_김서방_찾기;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

    }

    public String solution(String[] seoul) {
        String answer = "";
        List<String> init = new ArrayList<>(List.of(seoul));
        for(int i=0;i<init.size(); i++){
            if(init.get(i).equals("Kim")){
                answer = "김서방은 " +i+"에 있다";
            }
        }
        //int x = Arrays.asList(seoul).indexOf("Kim");
        // indexof 사용하면 바로 위치를 알수 있음.
        return answer;
    }

}
