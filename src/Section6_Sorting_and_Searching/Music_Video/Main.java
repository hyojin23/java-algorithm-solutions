package Section6_Sorting_and_Searching.Music_Video;

import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public int count(int[] arr, int capacity) {

        int sum = 0;
        int cnt = 1;

        for (int x : arr) {
            if (sum + x > capacity) {
                cnt++;
                sum = x;
            }
            else {
                sum += x;
            }
        }

        return cnt;
    }

    public int solution(int n, int m, int[] arr) {

        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();

        int mid;
        int answer = 0;

        while (lt <= rt) {

            mid = (lt + rt) / 2;

            if (count(arr, mid) <= m) {
                answer = mid;
                rt = mid - 1;
            }
            else {
                lt = mid + 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, m, arr));
    }
}
