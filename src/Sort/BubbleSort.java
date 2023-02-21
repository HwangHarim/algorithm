package Sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
    int[] arr = {6,7,2,4,0,9};
    bubble(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;

    }

    public static void bubble(int[] arr, int n){
      int k =0;

      while(k<n-1){
          int last =n-1;
          for(int j =n-1; j>k; j--){
              if(arr[j-1]>arr[j]){
                  swap(arr, j-1, j);
                  last = j;
              }
          }
          k = last;
      }
    }
}
