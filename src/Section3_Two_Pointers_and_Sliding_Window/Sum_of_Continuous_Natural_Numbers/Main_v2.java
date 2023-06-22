package Section3_Two_Pointers_and_Sliding_Window.Sum_of_Continuous_Natural_Numbers;

import java.util.Scanner;

public class Main_v2 {

    public int solution(int[] arr, int n) {

        int lt = 0, rt = 0;
        int sum = 0, cnt = 0;

        while (rt < n) {
            if (sum == n) {
                cnt++;
                sum = sum + arr[rt++];
            }

            if (sum < n) {
                sum = sum + arr[rt++];
            }
            else if (sum > n) {
                sum = sum - arr[lt++];
            }
        }
        return cnt;
    }

    public static void main(String[] args) {

        Main_v2 T = new Main_v2();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        System.out.println(T.solution(arr, n));
    }
}
