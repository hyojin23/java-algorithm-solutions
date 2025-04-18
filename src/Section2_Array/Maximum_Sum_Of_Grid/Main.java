package Section2_Array.Maximum_Sum_Of_Grid;

import java.util.Scanner;

public class Main {

    public int solution(int n, int[][] arr) {

        int max = Integer.MIN_VALUE;
        int cDownSum = 0;
        int cUpSum = 0;
        for (int i = 0; i < n; i++) {
            int rowSum = 0;
            int colSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += arr[i][j];
                colSum += arr[j][i];
                if (i == j) {
                    cDownSum += arr[i][j];
                }
                if (i == n - 1 - j) {
                    cUpSum += arr[i][j];
                }
            }
            max = Math.max(max, rowSum);
            max = Math.max(max, colSum);
            max = Math.max(max, cDownSum);
            max = Math.max(max, cUpSum);
        }
        return max;
    }


    public static void main(String[] args) {

        Main T = new Main();
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
