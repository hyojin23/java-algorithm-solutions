package Section6_Sorting_and_Searching.Music_Video;

import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public int videoCnt(int mid, int[] arr) {

        int cnt = 1;
        int sum = 0;
        for (int x : arr) {
            if (mid >= sum + x) {
                sum += x;
            }
            else {
                sum = x;
                cnt++;
            }
        }
        return cnt;
    }

    public int solution(int n, int m, int[] arr) {

        int lt = arr[n - 1];
        int rt = Arrays.stream(arr).sum();
        int answer = 0;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (videoCnt(mid, arr) > m) {
                lt = mid + 1;
            }
            else if (videoCnt(mid, arr) <= m) {
                answer = mid;
                rt = mid - 1;
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
