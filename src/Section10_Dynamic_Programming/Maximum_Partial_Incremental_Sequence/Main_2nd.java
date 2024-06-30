package Section10_Dynamic_Programming.Maximum_Partial_Incremental_Sequence;

import java.util.Scanner;
import java.util.Arrays;

public class Main_2nd {

    static int[] arr;

    public int solution(int n) {

        int answer = 0;

        int[] dy = new int[n];
        Arrays.fill(dy, 1);

        dy[0] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    dy[i] = Math.max(dy[i], dy[j] + 1);
                }
            }
            answer = Math.max(answer, dy[i]);
        }

        return answer;
    }

    public static void main(String[] args) {

        Main_2nd T = new Main_2nd();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(T.solution(n));
    }
}
