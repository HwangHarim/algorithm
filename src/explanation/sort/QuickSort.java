package explanation.sort;

public class QuickSort {

    public static void main(String[] args) {
    }

    public static void swap(int[] a, int idx1, int idx2){
        int tmp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = tmp;
    }
    public void quickSort(int[] a, int left,int right){
        int pl =left;
        int pr =right;
        int x =a[(pl+pr)/2];

        do{
            while (a[pl] < x) pl++;
            while (a[pr]>x) pr--;
            if(pl<=pr){
                swap(a,pl++,pr--);
            }
        }while (pl<=pr);
        if(left<pr) quickSort(a,left,pr);
        if(right<pl) quickSort(a,pl,right);
    }
}
