package Section10_Dynamic_Programming.Maximum_Partial_Incremental_Sequence;

import java.util.Scanner;

public class Main {

    public int solution(int n, int[] arr) {

        int[] dy = new int[n];
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    max = Math.max(max, dy[j]);
                }
            }
            dy[i] = max + 1;
            answer = Math.max(answer, dy[i]);
        }
        return answer;
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, arr));
    }
}
