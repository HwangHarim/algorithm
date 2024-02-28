package explanation.정렬;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) {
        int[][] arr = {{1,3},{3,5},{2,6},{9,11}};
        arrSort(arr);
        ArrayListSort();

    }

    public static void arrSort(int[][] arr){
        //2차원 배열 정렬 -> 배열 [1] 번째 값을 기준으로 오름 차순
        Arrays.sort(arr, (o1,o2) -> o1[1] - o2[1]);
        System.out.println(Arrays.deepToString(arr));
        //내림차순
        Arrays.sort(arr, (o1,o2) -> o2[1] - o1[1]);
        System.out.println(Arrays.deepToString(arr));
        //2차원 배열 서로의 합으로 정렬
        Arrays.sort(arr, (o1,o2)-> (o1[0]+o1[1]) - (o2[0]+o2[1]));

        System.out.println(Arrays.deepToString(arr));
    }


    public static void ArrayListSort(){
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        ArrayList<String> sublist1 = new ArrayList<>(Arrays.asList("orange", "apple", "banana"));
        ArrayList<String> sublist2 = new ArrayList<>(Arrays.asList("melon", "grape", "kiwi"));
        ArrayList<String> sublist3 = new ArrayList<>(Arrays.asList("peach", "cherry", "pear"));
        list.add(sublist1);
        list.add(sublist2);
        list.add(sublist3);
        Collections.sort(list, (o1, o2) -> o1.get(1).compareTo(o2.get(1)));
        System.out.println(Collections.unmodifiableList(list));

        // 숫자인 경우 리스트 안의 리스트 내용으로 정렬하고 싶을 경우
        ArrayList<ArrayList<Integer>> list2 = new ArrayList<>();
        ArrayList<Integer> sublist4 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ArrayList<Integer> sublist5 = new ArrayList<>(Arrays.asList(1, 2, 4, 6, 5));
        list2.add(sublist4);
        list2.add(sublist5);

        Collections.sort(list2, (o1, o2) -> {
            int i = 0;
            while (i < o1.size() && i < o2.size()) {
                if (!o1.get(i).equals(o2.get(i))) {
                    return o2.get(i) - o1.get(i);
                }
                i++;
            }
            return o2.size() - o1.size(); // 길이가 짧은 것이 앞에 오도록 정렬
        });

        System.out.println(Collections.unmodifiableList(list2));
    }
}
