package Section10_Dynamic_Programming.Maximum_Partial_Incremental_Sequence;

import java.util.Scanner;
import java.util.Arrays;

public class Main_3rd {

    public int solution(int n, int[] arr) {

        int[] dy = new int[n];
        Arrays.fill(dy, 1);
        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    if (dy[i] < dy[j] + 1) {
                        dy[i] = dy[j] + 1;
                    }
                }
            }
        }

        for (int x : dy) {
            answer = Math.max(answer, x);
        }

        return answer;
    }

    public static void main(String[] args) {

        Main_3rd T = new Main_3rd();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(T.solution(n, arr));
    }
}
