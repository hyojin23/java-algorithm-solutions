package Section10_Dynamic_Programming.Maximum_Partial_Incremental_Sequence;

import java.util.Scanner;

public class Main_1st {

    public int solution(int[] arr, int[] dy, int n) {

        dy[0] = 1;
        int answer = 0;

        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dy[j] > max) {
                    max = dy[j];
                }
                dy[i] = max + 1;
            }
            answer = Math.max(answer, dy[i]);
        }
        return answer;
    }
    public static void main(String[] args) {

        Main_1st T = new Main_1st();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] dy = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(arr, dy, n));
    }
}
