package algorithmTest.programmers.LV_2.쿼드압축_후_개수_세기;

public class Solution {
    int[] answer = new int[2];
    public int[] solution(int[][] arr){
        quad(arr, 0,0, arr.length);

        return answer;
    }

    public boolean zip(int[][] arr, int x, int y, int size, int value){
        for(int i =x; i < x+size; i++){
            for(int j = y; j < y+size; j++){
                if(arr[i][j] != value){
                    return false;
                }
            }
        }
        return true;
    }

    public void quad(int[][] arr, int x, int y, int size){

        if(zip(arr,x,y,size, arr[x][y])){
            if(arr[x][y] == 1)
                answer[1]++;
            else answer[0]++;
            return ;
        }
        quad(arr,x,y, size/2);
        quad(arr,x,y + size/2, size/2);
        quad(arr,x+size/2,y, size/2);
        quad(arr,x+size/2,y + size/2, size/2);

    }
}
