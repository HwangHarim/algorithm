package explanation.sort;

public class QuickSort {

    public static void main(String[] args) {
    }

    /**
     * 퀵 정렬은 안전한 정렬 알고리즘이 아니다.
     * 회선의 경우 O(nlog) 이지만 최악의 경우 O(n*n)이된다.(이미 정렬인된 배열일 경우)
     *
     * @param a
     * @param lo
     * @param hi
     * @return
     */
    public int quickSort(int[] a, int lo, int hi) {
        int pivot = a[hi];
        int left = lo;

        for (int right = lo; right < hi; right++) {
            if (a[right] <= pivot) {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
                left++;
            }
        }
        int temp = a[left];
        a[left] = a[hi];
        a[hi] = temp;
        return left;
    }
}
