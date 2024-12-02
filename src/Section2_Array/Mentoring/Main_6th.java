package Section2_Array.Mentoring;

import java.util.Scanner;

public class Main_6th {

    public int solution(int n, int m, int[][] arr) {

        int answer = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int cnt = 0;
                for (int k = 0; k < m; k++) {
                    int mentoRank = 0;
                    int menteeRank = 0;
                    for (int l = 0; l < n; l++) {
                        if (i == arr[k][l]) {
                            mentoRank = l;
                        }
                        if (j == arr[k][l]) {
                            menteeRank = l;
                        }
                    }
                    if (mentoRank < menteeRank) {
                        cnt++;
                    }
                }
                if (cnt == m) {
                    answer++;
                }
            }
        }
        return answer;
    }


    public static void main(String[] args) {

        Main_6th T = new Main_6th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(T.solution(n, m, arr));
    }
}
