package BOJ.BOJ14891;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class Main {

    static int[][] gears;
    static final int LEFT_SIDE_IDX = 6;
    static final int RIGHT_SIDE_IDX = 2;
    static final int CLOCK_WISE = 1;
    static final int COUNTER_CLOCK_WISE = -1;

    public static void rotate(int idx, int dir) {

        if (dir == CLOCK_WISE) {
            int last = gears[idx][7];
            for (int i = 7; i >= 1; i--) {
                gears[idx][i] = gears[idx][i - 1];
            }
            gears[idx][0] = last;
        }
        else if (dir == COUNTER_CLOCK_WISE){
            int last = gears[idx][0];
            for (int i = 0; i < 7; i++) {
                gears[idx][i] = gears[idx][i + 1];
            }
            gears[idx][7] = last;
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        gears = new int[4][8];

        for (int i = 0; i < 4; i++) {
            String line = br.readLine();
            for (int j = 0; j < 8; j++) {
                gears[i][j] = line.charAt(j) - '0';
            }
        }

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] dirs = new int[4];

            int rotateGearNum = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            int rotateGearIdx = rotateGearNum - 1;
            dirs[rotateGearIdx] = dir;

            for (int myIdx = rotateGearIdx - 1; myIdx >= 0; myIdx--) {
                if (gears[myIdx][RIGHT_SIDE_IDX] != gears[myIdx + 1][LEFT_SIDE_IDX]) {
                    dirs[myIdx] = -dirs[myIdx + 1];
                }
                else {
                    break;
                }
            }

            for (int myIdx = rotateGearIdx + 1; myIdx < 4; myIdx++) {
                if (gears[myIdx - 1][RIGHT_SIDE_IDX] != gears[myIdx][LEFT_SIDE_IDX]) {
                    dirs[myIdx] = -dirs[myIdx - 1];
                }
                else {
                    break;
                }
            }

            for (int gearIdx = 0; gearIdx < 4; gearIdx++) {
                if (dirs[gearIdx] != 0) {
                    rotate(gearIdx, dirs[gearIdx]);
                }
            }
        }

        int[] score = {1, 2, 4, 8};
        int answer = 0;
        for (int i = 0; i < 4; i++) {
            answer += gears[i][0] * score[i];
        }
        System.out.println(answer);
    }
}
