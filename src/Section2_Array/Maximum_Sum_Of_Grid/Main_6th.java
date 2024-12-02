package Section2_Array.Maximum_Sum_Of_Grid;

import java.util.Scanner;

public class Main_6th {

    public int solution(int n, int[][] arr) {

        int answer = Integer.MIN_VALUE;

        int rtUpSum = 0;
        int rtDownSum = 0;
        for (int i = 0; i < n; i++) {
            int rowSum = 0;
            int colSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += arr[i][j];
                colSum += arr[j][i];
                if (i == j) {
                    rtUpSum += arr[i][j];
                }
                if (j == n - 1 - i) {
                    rtDownSum += arr[i][j];
                }
            }
            answer = Math.max(rowSum, answer);
            answer = Math.max(colSum, answer);
        }
        answer = Math.max(rtUpSum, answer);
        answer = Math.max(rtDownSum, answer);

        return answer;
    }


    public static void main(String[] args) {

        Main_6th T = new Main_6th();
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
