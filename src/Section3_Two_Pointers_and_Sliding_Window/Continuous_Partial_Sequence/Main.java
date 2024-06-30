package Section3_Two_Pointers_and_Sliding_Window.Continuous_Partial_Sequence;

import java.util.Scanner;

public class Main {

    public int solution(int n, int m, int[] arr) {

        int lt = 0;
        int rt = 0;
        int sum = arr[0];
        int cnt = 0;

        while (rt < n) {

            if (sum < m) {
                sum += arr[++rt];
            }
            else if (sum > m) {
                sum -= arr[lt++];
            }
            else {
                sum -= arr[lt++];
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(T.solution(n, m, arr));
    }
}
