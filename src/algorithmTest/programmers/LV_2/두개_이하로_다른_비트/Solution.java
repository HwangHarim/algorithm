package algorithmTest.programmers.LV_2.두개_이하로_다른_비트;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        long[] a = {11,17};
        System.out.println(solution(a));
    }

//    public static long[] solution(long[] numbers) {
//
//        long[] answer = new long[numbers.length];
//
//        for (long i = 0; i < numbers.length; i++) {
//            long number = numbers[(int) i];
//            long now = number+1;
//            char[] numberBinary = Long.toBinaryString(number).toCharArray();
//            while (true) {
//
//                char[] nowBinary = Long.toBinaryString(now).toCharArray();
//                long gap = nowBinary.length - numberBinary.length;
//                long count = gap;
//                for (long j = numberBinary.length - 1; 0 <= j; j--) {
//                    if (numberBinary[(int) j] != nowBinary[(int) (j + gap)]) {
//                        count++;
//                    }
//                }
//                if (count < 3) {
//                    answer[(int) i] = now;
//                    break;
//                }
//                now++;
//            }
//        }
//        return answer;
//    }
    public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for(int i=0; i<numbers.length;i++){
            if(numbers[i] %2 ==0){
                answer[i] = numbers[i]+1;
            }else{
                String s = Long.toString(numbers[i],2);
                int zeroIdx = s.lastIndexOf("0");
                if(zeroIdx != -1){
                    s = s.substring(0, zeroIdx) + "10" + s.substring(zeroIdx+2, s.length());
                    answer[i] = Long.parseLong(s,2);
                }else{
                    s ="10"+ s.substring(1, s.length());
                    answer[i] = Long.parseLong(s,2);
                }
            }
        }
        return answer;
    }
}
