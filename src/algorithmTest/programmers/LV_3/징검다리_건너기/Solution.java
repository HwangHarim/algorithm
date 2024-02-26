package algorithmTest.programmers.LV_3.징검다리_건너기;

class Solution {

    /**
     * 파라매틱서치 풀이로 풀이<br/>
     * -> 이진 탐색의 변형 버전으로<br/>
     * 최적해를 구하는 문제에서 사용한다.<br/>
     * 모든 문제의 조건이 yes or no로 이야기 가능해야함<br/>
     * ex> k명중 19시에 이상 차를 타를 탈 수 있다. 최대 명수를 구해라 등...<br/>
     */
    public int solution(int[] stones, int k) {
        int answer = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int stone : stones){
            min = Math.min(min, stone);
            max = Math.max(max, stone);
        }

        while(min < max){
            int mid = (min+max+1)/2;
            if(isPassable(mid, stones, k)){
                min = mid;
            }else{
                max = mid - 1;
            }
        }

        return max;
    }

    public boolean isPassable(int number, int[] arr, int k){
        int count = 0;
        for(int stone : arr){

            if(stone - number < 0){
                count++;
            } else {
                count = 0;
            }
            if(count == k){
                return false;
            }
        }
        return true;
    }
}
