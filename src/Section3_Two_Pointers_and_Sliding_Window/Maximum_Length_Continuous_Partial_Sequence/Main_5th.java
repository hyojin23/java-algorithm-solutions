package Section3_Two_Pointers_and_Sliding_Window.Maximum_Length_Continuous_Partial_Sequence;

import java.util.Scanner;

public class Main_5th {

    public int solution(int n, int k, int[] arr) {

        int lt = -1;
        int cnt = 0;
        int max = Integer.MIN_VALUE;
        for (int rt = 0; rt < n; rt++) {
            if (arr[rt] == 0) {
                if (cnt < k) {
                    cnt++;
                }
                else {
                    lt++;
                    while (arr[lt] != 0) {
                        lt++;
                    }
                }
            }
            max = Math.max(rt - lt, max);
        }
        return max;
    }


    public static void main(String[] args) {

        Main_5th T = new Main_5th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(T.solution(n, k, arr));
    }
}
