package Sort;

public class ShellSort {

    public static void main(String[] args) {

    }

    public static void shellSort(int[] a, int n){
        for(int h=n;h>0;h/=2){
            for(int i=h;i<n;i++){
                int j;
                int tmp = a[i];
                for(j = i-h;j>=0&&a[j]>tmp;j -=h){
                    a[j+h] = a[j];
                }
                a[j+h] = tmp;
            }
        }
    }
}