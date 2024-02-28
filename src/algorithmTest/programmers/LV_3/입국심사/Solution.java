package algorithmTest.programmers.LV_3.입국심사;

public class Solution {

    //이분탐색 문제
    public long solution(int n, int[] times){
        long answer =0;
        long left = 0;
        long right = times[times.length - 1] * (long)n;

        while(left <= right){
            long mid = (left+right)/2;
            long complete =0;
            for (int time : times) {
                complete += time / mid;
            }
            if(complete<n){
                left = mid+1;
            }else{
                right = mid -1;
                answer = mid;
            }
        }


        return answer;
    }
}
