package Section2_Array.Decide_Temporary_Class_President;

import java.util.Scanner;

public class Main_2nd {

    public int solution(int[][] arr, int n) {

        int answer = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= 5; k++) {
                    if (i == j) {
                        break;
                    }
                    if (arr[i][k] == arr[j][k]) {
                        cnt++;
                        break;
                    }
                }
            }
            if (cnt > max) {
                answer = i;
                max = cnt;
            }
        }
        return answer;
    }


    public static void main(String[] args) {

        Main_2nd T = new Main_2nd();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n + 1][6];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 5; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(T.solution(arr, n));
    }
}
