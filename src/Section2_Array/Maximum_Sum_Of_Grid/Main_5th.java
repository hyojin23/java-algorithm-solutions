package Section2_Array.Maximum_Sum_Of_Grid;

import java.util.Scanner;

public class Main_5th {

    public int solution(int n, int[][] arr) {

        int max = Integer.MIN_VALUE;
        int crossSum1 = 0;
        int crossSum2 = 0;
        for (int i = 0; i < n; i++) {
            int hSum = 0;
            int vSum = 0;
            for (int j = 0; j < n; j++) {
                hSum += arr[i][j];
                vSum += arr[j][i];

                if (i == j) {
                    crossSum1 += arr[i][j];
                }

                if (i + j == n - 1) {
                    crossSum2 += arr[i][j];
                }
            }
            max = Math.max(hSum, max);
            max = Math.max(vSum, max);
        }

        max = Math.max(crossSum1, max);
        max = Math.max(crossSum2, max);

        return max;
    }

    public static void main(String[] args) {

        Main_5th T = new Main_5th();
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
