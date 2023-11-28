package algorithmTest.programmers.LV_2.호텔_대기;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    static int answer =0;

    public static void main(String[] args) {
        String[][] a = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
        System.out.println(solution(a));
    }
    static class Time{
        int start, end;
        public Time(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static int solution(String[][] book_time) {
        List<Time> timeList = new ArrayList<>();

        for(String[] roomRead : book_time){
            String[] startTime  = roomRead[0].split(":");
            int start  = Integer.parseInt(startTime[0])*60 + Integer.parseInt(startTime[1]);
            String[] endTime  = roomRead[1].split(":");
            int end  = Integer.parseInt(endTime[0])*60+Integer.parseInt(endTime[1])+10;
            timeList.add(new Time(start, end));
        }

       timeList = timeList.stream().sorted(
            Comparator.comparingInt(time -> time.start)
        ).collect(Collectors.toList());

        Stack<Integer> stack = new Stack<>();

        for(int i =0; i<timeList.size(); i++){
            int startTime = timeList.get(i).start;
            int endTime = timeList.get(i).end;

            while(!stack.isEmpty() && timeList.get(stack.peek()).end <= startTime ){
                answer = Math.max(answer, stack.size());
                stack.pop();
            }
            stack.push(i);
        }



        return answer;
    }
}