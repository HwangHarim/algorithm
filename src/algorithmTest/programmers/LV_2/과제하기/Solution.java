package algorithmTest.programmers.LV_2.과제하기;
import java.util.*;

class Solution {

    static class Task{
        private String name;
        private int startTime;
        private int playTime;

        public Task(String name, int startTime, int playTime){
            this.name = name;
            this.startTime = startTime;
            this.playTime = playTime;
        }

        public Task(String name, int playTime){
            this.name = name;
            this.playTime = playTime;
        }
    }

    public List<String> solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        PriorityQueue<Task> timeLine = new PriorityQueue<>(
            (o1, o2) -> (o1.startTime - o2.startTime)
        );


        for(int i=0; i<plans.length; i++){
            String[] time = plans[i][1].split(":");
            int init = Integer.parseInt(time[0])*60 +Integer.parseInt(time[1]);
            timeLine.offer(new Task(plans[i][0], init, Integer.parseInt(plans[i][2])));
        }

        Stack<Task> stopStudyStack = new Stack<>();

        while(!timeLine.isEmpty()){
            Task now = timeLine.poll();

            String name = now.name;
            int nowTime = now.startTime;
            int playTime = now.playTime;

            int currentTime = nowTime;

            if(!timeLine.isEmpty()){
                if(nowTime + playTime < timeLine.peek().startTime){
                    answer.add(name);
                    currentTime += playTime;

                    while(!stopStudyStack.isEmpty()){
                        Task rem = stopStudyStack.pop();

                        if(currentTime + rem.playTime < timeLine.peek().startTime){
                            currentTime += rem.playTime;
                            answer.add(rem.name);
                        }else{
                            int t = rem.playTime - (timeLine.peek().startTime - currentTime);
                            stopStudyStack.push(new Task(rem.name, t));
                            break;
                        }
                    }
                }else if(nowTime+playTime == timeLine.peek().startTime){
                    answer.add(name);
                }else{
                    int t = (timeLine.peek().startTime - currentTime);
                    stopStudyStack.push(new Task(name, playTime - t));
                }
            }else{
                if(stopStudyStack.isEmpty()){
                    answer.add(name);
                }else{
                    answer.add(name);

                    while(!stopStudyStack.isEmpty()){
                        Task rem = stopStudyStack.pop();
                        answer.add(rem.name);
                    }
                }
            }
        }

        return answer;
    }
}