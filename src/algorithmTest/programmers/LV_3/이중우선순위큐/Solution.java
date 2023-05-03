package algorithmTest.programmers.LV_3.이중우선순위큐;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {
        String[] a = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        solution(a);
    }

    public static int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        String[] init = new String[operations.length];
        for(int i=0; i<operations.length;i++){
          if (operations[i].contains("I")) {
              init[i] = operations[i].substring(2);
              minHeap.add(Integer.parseInt(init[i]));
              maxHeap.add(Integer.parseInt(init[i]));
            }
            if (operations[i].equals("D -1")&& minHeap.peek() != null){
                maxHeap.remove(minHeap.peek());
                minHeap.poll();
            }if (operations[i].equals("D 1")&& maxHeap.peek() != null){
                minHeap.remove(maxHeap.peek());
                maxHeap.poll();
            }
        }
        int[] answer = new int[2];
        if(minHeap.peek() == null&&maxHeap.peek() == null){
            return answer;
        }
        answer[0] = maxHeap.peek();
        answer[1] = minHeap.peek();
        return answer;
    }
}
