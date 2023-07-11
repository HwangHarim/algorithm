package algorithmTest.programmers.LV_2.거리두기확인;

import java.util.Arrays;

class Solution {

    private static final int[] dx = {0, -1, 1, 0};
    private static final int[] dy = {-1, 0, 0, 1};

    public static void main(String[] args) {
        String[][] init= {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        System.out.println(Arrays.toString(solution(init)));
    }


    public static int[] solution(String[][] places) {

        int[] answer = new int[places.length];
        for (int i = 0; i < answer.length; i++) {
            String[] place = places[i];
            char[][] room = new char[place.length][];
            for (int j = 0; j < room.length; j++) {
                room[j] = place[j].toCharArray();
            }
            if (checkCase(room)) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }

        return answer;
    }

    public static boolean checkCase(char[][] room) {
        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room[i].length; j++) {
                if (room[i][j] != 'P') {
                    continue;
                }
                if (!checkCase(room, j, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkCase(char[][] room, int idx1, int idx2) {
        for (int i = 0; i < 4; i++) {
            int nx = idx1 + dx[i];
            int ny = idx2 + dy[i];
            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) {
                continue;
            }
            switch (room[ny][nx]) {
                case 'P':
                    return false;
                case 'O':
                    if (isNextToVolunteer(room, nx, ny, 3 - i)) {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }

    public static boolean isNextToVolunteer(char[][] room, int x, int y, int now) {
        for (int d = 0; d < 4; d++) {
            if (d == now) {
                continue;
            }

            int nx = x + dx[d];
            int ny = y + dy[d];
            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) {
                continue;
            }
            if (room[ny][nx] == 'P') {
                return true;
            }
        }

        return false;
    }
}