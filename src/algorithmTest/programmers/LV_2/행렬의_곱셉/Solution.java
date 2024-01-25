package algorithmTest.programmers.LV_2.행렬의_곱셉;


import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        int[][] a = {{1,4},{3,2},{4,1}};
        int[][] b = {{3,3},{3,3}};
        System.out.println(Arrays.deepToString(solution(a, b)));
    }
    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for(int i =0; i<answer.length; i++){
            int[] a  = arr1[i];
            for(int j =0; j<answer[0].length;j++){
                int sum =0;
                int[] b = new int[arr2.length];
                for(int k =0; k<arr2.length; k++){
                    b[k] = arr2[k][j];
                }
                for(int r =0; r<a.length; r++){
                    sum+=a[r]*b[r];
                }
                answer[i][j] = sum;
            }
        }

        return answer;
    }
}
