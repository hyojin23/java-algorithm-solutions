package BOJ.BOJ17779;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static int solution(int N, int[][] board) {

        int answer = Integer.MAX_VALUE;

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                for (int d1 = 1; d1 <= N; d1++) {
                    for (int d2 = 1; d2 <= N; d2++) {

                        if (x + d1 + d2 >= N) continue;
                        if (y - d1 < 0) continue;
                        if (y + d2 >= N) continue;

                        boolean[][] isBorder = new boolean[N][N];

                        for (int i = 0; i <= d1; i++) {     //1번 경계선
                            isBorder[x + i][y - i] = true;
                        }

                        for (int i = 0; i <= d2; i++) {     //2번 경계선
                            isBorder[x + i][y + i] = true;
                        }

                        for (int i = 0; i <= d2; i++) {     //3번 경계선
                            isBorder[x + d1 + i][y - d1 + i] = true;
                        }

                        for (int i = 0; i <= d1; i++) {     //4번 경계선
                            isBorder[x + d2 + i][y + d2 - i] = true;
                        }


                        boolean[][] isFive = new boolean[N][N];

                        for (int r = 0; r < N; r++) {       //경계선 내부(5번 구역) 구하기
                            int left = -1, right = -1;
                            for (int c = 0; c < N; c++) {
                                if (isBorder[r][c]) {
                                    if (left == -1) {
                                        left = c;
                                    }
                                    right = c;
                                }
                            }
                            if (left != -1 && right != -1) {
                                for (int c = left; c <= right; c++) {
                                    isFive[r][c] = true;
                                }
                            }
                        }

                        int[] population = new int[5];
                        int[][] paint = new int[N][N];

                        //1번 구역
                        for (int r = 0; r < x + d1; r++) {
                            for (int c = 0; c <= y; c++) {
                                if (isBorder[r][c]) {
                                    break;
                                }
                                population[0] += board[r][c];
                                paint[r][c] = 1;
                            }
                        }

                        //2번 구역
                        for (int r = 0; r <= x + d2; r++) {
                            for (int c = N - 1; c > y; c--) {
                                if (isBorder[r][c]) {
                                    break;
                                }
                                population[1] += board[r][c];
                                paint[r][c] = 2;
                            }
                        }

                        //3번 구역
                        for (int r = x + d1; r < N; r++) {
                            for (int c = 0; c < y - d1 + d2; c++) {
                                if (isBorder[r][c]) {
                                    break;
                                }
                                population[2] += board[r][c];
                                paint[r][c] = 3;
                            }
                        }

                        //4번 구역
                        for (int r = x + d2 + 1; r < N; r++) {
                            for (int c = N - 1; c >= y -d1 + d2; c--) {
                                if (isBorder[r][c]) {
                                    break;
                                }
                                population[3] += board[r][c];
                                paint[r][c] = 4;
                            }
                        }

                        //5번 구역
                        for (int r = 0; r < N; r++) {
                            for (int c = 0; c < N; c++) {
                                if (isFive[r][c]) {
                                    population[4] += board[r][c];
                                    paint[r][c] = 5;
                                }
                            }
                        }

                        int max = Integer.MIN_VALUE;
                        int min = Integer.MAX_VALUE;
                        for (int val : population) {
                            max = Math.max(max, val);
                            min = Math.min(min, val);
                        }
                        answer = Math.min(answer, max - min);
                    }
                }
            }
        }

        return answer;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(solution(N, board));
    }
}
