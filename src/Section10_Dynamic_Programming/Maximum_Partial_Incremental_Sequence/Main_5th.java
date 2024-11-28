package Section10_Dynamic_Programming.Maximum_Partial_Incremental_Sequence;

import java.util.Scanner;
import java.util.Arrays;

public class Main_5th {

    public int solution(int n, int[] arr) {

        int[] dy = new int[n];
        Arrays.fill(dy, 1);
        int answer = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
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

        Main_5th T = new Main_5th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(T.solution(n, arr));
    }
}
