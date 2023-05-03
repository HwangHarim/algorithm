package algorithmTest.programmers.LV_1.행렬의_덧셈_문제;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        int[][] arr1 = {{1,2},{2,3}};
        int[][] arr2 = {{3,4},{5,6}};
        solution(arr1,arr2);
    }


    public static int[][] solution(int[][] arr1, int[][] arr2) {

        List<Integer> indexZero = new ArrayList<>();
        for(int i=0 ; i<arr1.length ; i++) {
            for(int j=0 ; j<arr1[0].length ; j++) {
                arr1[i][j] += arr2[i][j];
            }
        }
        return arr1;
    }
}
