package algorithmTest.programmers.LV_3.상담인원;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int solution(int k, int n, int[][] reqs) {
        int answer = 0;

        List<List<Time>> timeForEachType = new ArrayList<>();
        for (int i = 0; i < k + 1; i++) {
            timeForEachType.add(new ArrayList<>());
        }

        //1. 유형 마다 상담 요청 시간 불리
        for (int[] req : reqs) {
            int type = req[2];
            int start = req[0];
            int end = req[1];

            timeForEachType.get(type).add(new Time(start, start + end));
        }

        //2. 각 유형마다 1~(n-k)수의 상담사를 배정, 상담사 숫자에 따른 각 대기 시간 구현
        int[][] waitTimeForEachTime = new int[k + 1][n + 1];
        for (int type = 1; type <= k; type++) {
            if (timeForEachType.get(type).size() == 0) continue;

            for (int counselors = 1; counselors <= (n - k) + 1; counselors++) {
                waitTimeForEachTime[type][counselors] =
                        calculator(timeForEachType.get(type), counselors);
            }
        }

        //3. 우선 각 상담원 1명씩 배치
        int[] currentCounselors = new int[k + 1];
        for (int type = 1; type < k + 1; type++) {
            currentCounselors[type] = 1;
        }
        int remainCounselorNumber = n - k;

        //4. 대기시간이 가장 많이 줄어드는 곳에 상담원 배치 -> 그리드
        while (remainCounselorNumber-- > 0) {
            int maxWaitTime = 0;
            int correspondingType = 0;

            for (int type = 1; type < k + 1; type++) {
                int currentCounselorsByType = currentCounselors[type];
                int waitTimeForType = waitTimeForEachTime[type][currentCounselorsByType];
                int next = waitTimeForEachTime[type][currentCounselorsByType + 1];
                int reduceWaitingTime = Math.abs(next - waitTimeForType);

                if (reduceWaitingTime > maxWaitTime) {
                    maxWaitTime = reduceWaitingTime;
                    correspondingType = type;
                }
            }

            if (maxWaitTime == 0) {
                break;
            }

            currentCounselors[correspondingType]++;
        }

        //5. 상담원 배치가 끝나고 계산
        for (int type = 1; type < k + 1; type++) {

            if (timeForEachType.get(type).size() == 0) continue;

            int counselors = currentCounselors[type];

            answer += waitTimeForEachTime[type][counselors];
        }


        return answer;
    }

    private int calculator(List<Time> times, int peopleCount) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int waitTime = 0;

        for (Time time : times) {
            if (pq.isEmpty() || pq.size() < peopleCount) {
                pq.add(time.end);
            } else {
                int earlyConsultEndTime = pq.poll();
                if (time.start < earlyConsultEndTime) {
                    waitTime += (earlyConsultEndTime - time.start);
                    pq.add(earlyConsultEndTime + (time.end - time.start));
                } else {
                    pq.add(time.end);
                }
            }
        }

        return waitTime;
    }

    class Time {
        int start, end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}