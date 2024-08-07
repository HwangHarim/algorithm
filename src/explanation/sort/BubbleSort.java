package explanation.sort;

import java.util.Arrays;

/**
 * 버블 정렬은
 * n개 기준 n번씩 반복을 진행하므로 O(n*n)으로 엄청난 시간복잡도를 갖는다.
 * 그러므로 정렬을 거의 사용하지 않는다.
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {6, 7, 2, 4, 0, 9};
        bubble(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;

    }

    public static void bubble(int[] arr, int n) {
        int k = 0;

        while (k < n - 1) {
            int last = n - 1;
            for (int j = n - 1; j > k; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                    last = j;
                }
            }
            k = last;
        }
    }
}
