package Section2_Array.Maximum_Sum_Of_Grid;

import java.util.Scanner;

public class Main_v2 {

    public int solution(int n, int[][] arr) {

        int max = Integer.MIN_VALUE;
        int rSum, cSum, bSum, tSum;

        for (int i = 0; i < n; i++) {
            rSum = 0;
            cSum = 0;
            bSum = 0;
            tSum = 0;

            for (int j = 0; j < n; j++) {
                rSum += arr[i][j];
                cSum += arr[j][i];
                bSum += arr[j][j];
                tSum += arr[j][n - 1 - j];
            }
            int a = Math.max(rSum, cSum);
            int b = Math.max(bSum, tSum);
            int c = Math.max(a, b);
            max = Math.max(max, c);
        }
        return max;
    }

    public static void main(String[] args) {

        Main_v2 T = new Main_v2();
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
