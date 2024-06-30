package Section2_Array.Maximum_Sum_Of_Grid;

import java.util.Scanner;

public class Main_2nd {

    public int solution(int[][] arr, int n) {

        int answer = Integer.MIN_VALUE;
        int hSum, vSum;

        int cSum = 0;
        int dSum = 0;

        for (int i = 0; i < n; i++) {
            hSum = 0;
            vSum = 0;

            for (int j = 0; j < n; j++) {
                hSum += arr[i][j];
                vSum += arr[j][i];

                if (i == j) {
                    cSum += arr[i][j];
                }

                if (i + j == n - 1) {
                    dSum += arr[i][j];
                }
            }
            answer = Math.max(answer, hSum);
            answer = Math.max(answer, vSum);
        }
        answer = Math.max(answer, cSum);
        answer = Math.max(answer, dSum);

        return answer;
    }

    public static void main(String[] args) {

        Main_2nd T = new Main_2nd();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(T.solution(arr, n));
    }
}
