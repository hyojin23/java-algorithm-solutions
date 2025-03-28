package Section10_Dynamic_Programming.Maximum_Partial_Incremental_Sequence;

import java.util.Scanner;

public class Main_4th {

    public int solution(int n, int[] arr) {

        int[] dy = new int[n];
        dy[0] = 1;
        int answer = 0;

        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    max = Math.max(max, dy[j]);
                }
            }
            dy[i] = max + 1;
            answer = Math.max(dy[i], answer);
        }
        return answer;
    }

    public static void main(String[] args) {

        Main_4th T = new Main_4th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(T.solution(n, arr));
    }
}
