package algorithmTest.programmers.LV_2.스택문제;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


class Solution {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 2, 3};
        System.out.println(solution(a));
    }

    public static int[] solution(int[] prices) {
        int[] ans = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                ans[stack.peek()] = i - stack.peek();
                stack.pop(); // 답을 구했기 때문에 stack에서 제거한다
            }
            stack.push(i);
            Map<String, ArrayList<int[]>> categoryMap = new HashMap<>();
        }

        while (!stack.isEmpty()) { // 값을 구하지 못한 index == 끝까지 가격이 떨어지지 않은 주식
            ans[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }

        return ans;
    }

}
