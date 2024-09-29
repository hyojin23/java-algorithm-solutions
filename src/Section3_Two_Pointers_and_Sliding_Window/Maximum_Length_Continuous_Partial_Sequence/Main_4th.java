package Section3_Two_Pointers_and_Sliding_Window.Maximum_Length_Continuous_Partial_Sequence;

import java.util.Scanner;

public class Main_4th {

    public int solution(int n, int k, int[] arr) {

        int answer = 0;
        int lt = 0;
        int len = 0;
        int cnt = 0;

        for (int rt = 0; rt < n; rt++) {

            if (arr[rt] == 0) {
                cnt++;
            }

            while (cnt > k) {
                if (arr[lt] == 0) {
                    cnt--;
                    lt++;
                }
                else {
                    lt++;
                }
            }

            len = rt - lt + 1;

            answer =  Math.max(answer, len);
        }

        return answer;
    }

    public static void main(String[] args) {

        Main_4th T = new Main_4th();
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

