package Sort;

public class StraightSelectionSort {

    public static void main(String[] args) {
        int[] arr = {9,7,6,4,3,1};
        straightSelection(arr,arr.length);
    }

    public static void straightSelection(int[] arr, int lenght){
        for(int i =0; i<lenght;i++){
            for(int j=i+1; j<lenght; j++){
                if(arr[j]<arr[i]){
                    swap(arr,i,j);
                }
            }
        }
    }

    public static void swap(int[] arr, int idx1,int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

}
