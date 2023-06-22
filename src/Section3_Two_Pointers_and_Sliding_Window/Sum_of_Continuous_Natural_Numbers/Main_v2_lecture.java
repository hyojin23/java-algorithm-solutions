package Section3_Two_Pointers_and_Sliding_Window.Sum_of_Continuous_Natural_Numbers;

import java.util.Scanner;

public class Main_v2_lecture {

    public int solution(int n) {

        int lt = 0, sum = 0, cnt = 0;
        int m = n / 2 + 1;

        int[] arr = new int[m];

        for (int i = 0; i < m; i++) {
            arr[i] = i + 1;
        }

        for (int rt = 0; rt < m; rt++) {
            sum += arr[rt];
            if (sum == n)
                cnt++;
            while (sum >= n) {
                sum -= arr[lt++];
                if (sum == n)
                    cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {

        Main_v2_lecture T = new Main_v2_lecture();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println(T.solution(n));
    }
}
