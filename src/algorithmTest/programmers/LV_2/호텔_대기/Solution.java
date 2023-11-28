package algorithmTest.programmers.LV_2.호텔_대기;

import java.util.*;
import java.util.stream.Collectors;

class Solution {

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
        List<algorithmTest.programmers.LV_2.호텔_대기.Solution.Time> timeList = new ArrayList<>();

        for(String[] roomRead : book_time){
            String[] startTime  = roomRead[0].split(":");
            int start  = Integer.parseInt(startTime[0])*60 + Integer.parseInt(startTime[1]);
            String[] endTime  = roomRead[1].split(":");
            int end  = Integer.parseInt(endTime[0])*60+Integer.parseInt(endTime[1])+10;
            timeList.add(new algorithmTest.programmers.LV_2.호텔_대기.Solution.Time(start, end));
        }

        timeList = timeList.stream().sorted(
            Comparator.comparingInt(time -> time.start)
        ).collect(Collectors.toList());

        PriorityQueue<Integer> rooms = new PriorityQueue<>();

        for(algorithmTest.programmers.LV_2.호텔_대기.Solution.Time now : timeList){
            if(rooms.size() ==0){
                rooms.add(now.end);
                continue;
            }

            int earliestEmptyRoom = rooms.peek();

            if(now.start >= earliestEmptyRoom){
                rooms.poll();
                rooms.add(now.end);
            }else {
                rooms.add(now.end);
            }
        }


        return rooms.size();
    }
}