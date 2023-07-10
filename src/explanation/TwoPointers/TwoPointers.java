package explanation.TwoPointers;

public class TwoPointers {

    public static void main(String[] args) {
        int[] x = {1, 2, 3, 4, 2};
        int target = 5;
        System.out.println(twoPointers(x, target));
    }

    public static int twoPointers(int[] x, int target) {
        int n = x.length;
        int end = 0;
        int sum = 0;
        int count = 0;

        // twoPointer 를 이용한 부분합 구하기
        for (int i = 0; i < n; i++) {
            while (end < n && sum < target) {
                sum += x[end];
                end++;
            }

            if (sum == target) {
                count++;
            }
            sum -= x[i];
        }
        return  count;
    }
}
