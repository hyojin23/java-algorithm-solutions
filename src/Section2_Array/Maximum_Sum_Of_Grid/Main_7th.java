package Section2_Array.Maximum_Sum_Of_Grid;

import java.util.Scanner;

public class Main_7th {

    public int solution(int n, int[][] arr) {

        int max = Integer.MIN_VALUE;
        int upCrossSum = 0;
        int downCrossSum = 0;
        for (int i = 0; i < n; i++) {
            int rowSum = 0;
            int colSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += arr[i][j];
                colSum += arr[j][i];
                if (i == j) {
                    upCrossSum += arr[i][j];
                }
                if (j == n - 1 - i) {
                    downCrossSum += arr[i][j];
                }
            }
            max = Math.max(rowSum, max);
            max = Math.max(colSum, max);
        }
        max = Math.max(upCrossSum, max);
        max = Math.max(downCrossSum, max);

        return max;
    }


    public static void main(String[] args) {

        Main_7th T = new Main_7th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(T.solution(n, arr));
    }
}
