package Section3_Two_Pointers_and_Sliding_Window.Maximum_Length_Continuous_Partial_Sequence;

import java.util.Scanner;

public class Main_v2 {

    public int solution(int[] arr, int n, int k) {

        int lt = 0, cnt = 0;
        int answer = 0, len = 0;

        for (int rt = 0; rt < n; rt++) {

            if (arr[rt] == 0) {
                arr[rt] = 2;
                cnt++;
            }

            while (cnt > k) {
                if (arr[lt] == 2) {
                    arr[lt] = 0;
                    cnt--;
                }
                lt++;
            }

            if (cnt == k) {
                len = rt - lt + 1;
            }
            if (len > answer)
                answer = len;
        }
        return answer;
    }

    public static void main(String[] args) {

        Main_v2 T = new Main_v2();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(T.solution(arr, n, k));


    }
}
