package algorithmTest.programmers.LV_2.기능개발;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Solution {

    public static void main(String[] args) {

    }

    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> result = new LinkedList<>();
        List<Integer> answerList = new ArrayList<>();

        for(int i=0; i<speeds.length; i++){
            double reMain = (100 - progresses[i])/speeds[i];
            int data = (int) Math.ceil(reMain);

            if(!result.isEmpty()&&result.peek()<data){
                answerList.add(result.size());
                result.clear();
            }
            result.offer(data);
        }
        answerList.add(result.size());

        int[] answer = new int[answerList.size()];
        for(int i=0;i<answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
