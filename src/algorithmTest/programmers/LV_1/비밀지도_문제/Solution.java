package algorithmTest.programmers.LV_1.비밀지도_문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        int n= 5;
        int[] arr1 ={ 9, 20, 28, 18, 11};
        int[] arr2= {30, 1, 21, 17, 28};

        System.out.println(Arrays.toString(solution(n, arr1, arr2)));
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for(int i = 0; i < arr1.length; i++){
            StringBuilder result = new StringBuilder();
            String init1= Integer.toBinaryString(arr1[i]);
            String init2 = Integer.toBinaryString(arr2[i]);

            String[] initArr1 = addZero(n, init1).split("");
            String[] initArr2 = addZero(n, init2).split("");

            for(int j =0; j<initArr1.length; j++){
                if("1".equals(initArr1[j])||"1".equals(initArr2[j])){
                    result.append("#");
                }else{
                    result.append(" ");
                }
            }
            answer[i] = result.toString();
        }

        return answer;
    }

    public static String addZero(int n, String bin){
        StringBuilder result = new StringBuilder(bin);
        if(n>bin.length()){
            for(int i=0; i< n-bin.length(); i++){
                result.insert(0, "0");
            }
        }
        return result.toString();
    }
}