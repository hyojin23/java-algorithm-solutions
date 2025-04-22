package Section10_Dynamic_Programming.Maximum_Partial_Incremental_Sequence;

import java.util.Scanner;

public class Main_7th {

    public int solution(int n, int[] arr) {

        int[] dy = new int[n];
        dy[0] = 1;
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int max = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    max = Math.max(max, dy[j] + 1);
                }
                answer = Math.max(max, answer);
                dy[i] = max;
            }
        }
        return answer;
    }


    public static void main(String[] args) {

        Main_7th T = new Main_7th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, arr));
    }
}
