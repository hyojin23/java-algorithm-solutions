package BOJ.BOJ17822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static final int CLOCK_WISE = 0;
    static final int COUNTER_CLOCK_WISE = 1;

    public static int solution(int[][] disks, int[][] rotations) {

        int[][] nextDisks = copyDisks(disks);

        for (int[] info : rotations) {
            int[][] rotatedDisks = getRotatedDisks(info, nextDisks);    //원 회전

            //인접한 수 제거
            boolean[][] isNeighbor = new boolean[N][M];
            boolean hasSameNeighbor = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int next = (j + 1) % M;
                    if (rotatedDisks[i][j] == 0 || rotatedDisks[i][next] == 0) {
                        continue;
                    }
                    if (rotatedDisks[i][j] == rotatedDisks[i][next]) {      //원 안에서 인접한 수
                        isNeighbor[i][j] = true;
                        isNeighbor[i][next] = true;
                        hasSameNeighbor = true;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (i == N - 1 || rotatedDisks[i][j] == 0 || rotatedDisks[i + 1][j] == 0) {
                        continue;
                    }
                    if (rotatedDisks[i][j] == rotatedDisks[i + 1][j]) {     //원과 원 사이 인접한 수
                        isNeighbor[i][j] = true;
                        isNeighbor[i + 1][j] = true;
                        hasSameNeighbor = true;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (isNeighbor[i][j]) {
                        rotatedDisks[i][j] = 0;
                    }
                }
            }

            //인접한 수가 하나도 없으면 평균을 구하고, 평균보다 큰 수에서 1 빼고 평균보다 작은 수에서 1 더한다.
            if (!hasSameNeighbor) {
                int sum = 0;
                int cnt = 0;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (rotatedDisks[i][j] > 0) {
                            sum += rotatedDisks[i][j];
                            cnt++;
                        }
                    }
                }
                double avg = (double) sum / cnt;

                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (rotatedDisks[i][j] == 0) {
                            continue;
                        }
                        if (rotatedDisks[i][j] > avg) {
                            rotatedDisks[i][j]--;
                        } else if (rotatedDisks[i][j] < avg) {
                            rotatedDisks[i][j]++;
                        }
                    }
                }
            }
            nextDisks = copyDisks(rotatedDisks);
        }

        //원의 숫자 합 구하기
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sum += nextDisks[i][j];
            }
        }
        return sum;
    }

    public static int[][] getRotatedDisks(int[] info, int[][] disks) {

        int[][] result = new int[N][M];
        for (int i = 0; i < disks.length; i++) {
            result[i] = Arrays.copyOf(disks[i], disks[i].length);
        }

        for (int i = 1; info[0] * i <= N; i++) {
            int row = info[0] * i - 1;
            int dir = info[1];
            int steps = info[2];
            for (int j = 0; j < M; j++) {
                int newColIdx = 0;
                if (dir == CLOCK_WISE) {
                    newColIdx = (j + steps) % M;
                }
                else if (dir == COUNTER_CLOCK_WISE) {
                    newColIdx = (M + (j - steps)) % M;
                }
                result[row][newColIdx] = disks[row][j];
            }
        }
        return result;
    }

    public static int[][] copyDisks(int[][] original) {
        int[][] result = new int[original.length][original[0].length];

        for (int i = 0; i < original.length; i++) {
            result[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] disks = new int[N][M];
        int[][] rotations = new int[T][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                disks[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                rotations[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution(disks, rotations));
    }
}
