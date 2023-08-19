package algorithmTest.programmers.LV_2.기능개발;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Solution {

    public static void main(String[] args) {
        int[] one ={93, 30, 55};
        int[] speeds ={1,30,5};
        System.out.println(Arrays.toString(solution(one, speeds)));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answers = new ArrayList<>();
        int[] answer;
        int number=0;
        int dayCount =1;
        int finish=0;
        Queue<Integer> q = new LinkedList<>();

        for(int progresse : progresses){
            q.offer(progresse);
        }

        int now = q.poll();

        while(!q.isEmpty()){

            now += speeds[number];
            if(100 <= now){
                now = q.poll();
                finish++;
                number++;
                for(int i=number; i<progresses.length;i++){
                    if(100 <= progresses[i]+dayCount*speeds[i]){
                        finish++;
                        number++;
                        now = q.poll();
                    }
                    if(i == progresses.length-1){
                        answers.add(finish);
                        finish =0;
                    }
                }
            }
            dayCount++;
        }

        answer = new int[answers.size()];
        for(int i =0; i<answers.size();i++){
            answer[i] = answers.get(i);
        }

        return answer;
    }
}
/**
 * Queue<Integer> result = new LinkedList<>();
 *         List<Integer> answerList = new ArrayList<>();
 *
 *         for(int i=0; i<speeds.length; i++){
 *             double reMain = (100 - progresses[i])/speeds[i];
 *             int data = (int) Math.ceil(reMain);
 *
 *             if(!result.isEmpty()&&result.peek()<data){
 *                 answerList.add(result.size());
 *                 result.clear();
 *             }
 *             result.offer(data);
 *         }
 *         answerList.add(result.size());
 *
 *         int[] answer = new int[answerList.size()];
 *         for(int i=0;i<answer.length; i++) {
 *             answer[i] = answerList.get(i);
 *         }
 */