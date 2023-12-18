package algorithmTest.programmers.LV_2.마법의_엘리베이터;

class Solution {

    public static void main(String[] args) {
        System.out.println(solution(2554));
    }
    public static int solution(int storey) {
        int answer=0;
        String number = String.valueOf(storey);
        int storeyLength = number.length();
        int now = storey;

        for(int i = (int) Math.pow(10, storeyLength-1); 0<i; i/=10){
            int a = now/i;
            int b = 11 - now/i;
            answer += Math.min(a, b);
            now = now%i;
        }

        int n = storey;
        String[] numbers = number.split("");
        int aSum=0;
        for(int i= numbers.length-1; 0<=i;i--){
            int tmp=0;
            int a = 10 - Integer.parseInt(numbers[i]);
            aSum+=a;
            tmp+= aSum;
            n += (int) Math.pow(10, (numbers.length-1- i))*a;
            String sum = String.valueOf(n);
            for(String s: sum.split("")){
                tmp += Integer.parseInt(s);
            }
            answer = Math.min(answer, tmp);
        }

        return answer;
    }
}
