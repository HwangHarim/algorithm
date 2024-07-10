package algorithmTest.leetCode.heap.Kth_largest_element_in_an_array_215;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    static class BinaryHeap {
        public List<Integer> elems;

        public BinaryHeap() {
            elems = new ArrayList<>();
            elems.add(null);
        }

        public void swap(int i, int j) {
            int tmp = elems.get(i);
            elems.set(i, elems.get(j));
            elems.set(j, tmp);
        }

        public void percolateUp() {
            int idx = elems.size() - 1;
            int parentIdx = idx / 2;
            while (parentIdx > 0) {
                if (elems.get(idx) > elems.get(parentIdx)) {
                    swap(idx, parentIdx);
                }

                idx = parentIdx;
                parentIdx = idx / 2;
            }
        }

        public void insert(int k) {
            elems.add(k);
            percolateUp();
        }

        public void maxHeapify(int i) {
            int left = i * 2;
            int right = i * 2 + 1;
            int largest = i;

            if (left <= elems.size() - 1 && elems.get(left) > elems.get(largest)) {
                largest = left;
            }
            if (right <= elems.size() - 1 && elems.get(right) > elems.get(largest)) {
                largest = right;
            }

            if (largest != i) {
                swap(largest, i);
                maxHeapify(largest);
            }
        }

        public int extract() {
            int extracted = elems.get(1);

            elems.set(1, elems.get(elems.size() - 1));
            elems.remove(elems.size() - 1);
            maxHeapify(1);

            return extracted;
        }
    }

    public int findKthLargest(int[] nums, int k) {
        BinaryHeap heap = new BinaryHeap();
        for (int n : nums) {
            heap.insert(n);
        }

        for (int i = 0; i < k - 1; i++) {
            heap.extract();
        }

        return heap.extract();

    }
}
