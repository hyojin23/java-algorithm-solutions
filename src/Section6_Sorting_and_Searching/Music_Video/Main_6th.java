package Section6_Sorting_and_Searching.Music_Video;

import java.util.Scanner;
import java.util.Arrays;

public class Main_6th {

    public int videoCount(int mid, int[] arr) {

        int cnt = 1;
        int sum = 0;
        for (int x : arr) {
            if (sum + x > mid) {
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
        int answer = 0;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            int cnt = videoCount(mid, arr);
            if (cnt <= m) {
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

        Main_6th T = new Main_6th();
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
