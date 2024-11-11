package Section6_Sorting_and_Searching.Music_Video;

import java.util.Arrays;
import java.util.Scanner;

public class Main_5th {

    public boolean canRecord(int targetCnt, int minute, int[] arr) {

        int sum = 0;
        int cnt = 1;
        for (int x : arr) {
            if (sum + x <= minute) {
                sum += x;
            }
            else {
                sum = x;
                cnt++;
            }
        }
        return cnt <= targetCnt;
    }

    public int solution(int n, int m, int[] arr) {

        int lt = 0;
        int rt = Arrays.stream(arr).sum();
        int answer = 0;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            boolean canRecord = canRecord(m, mid, arr);

            if (canRecord) {
                rt = mid - 1;
                answer = mid;
            }
            else {
                lt = mid + 1;
            }
        }
        return answer;
    }


    public static void main(String[] args) {

        Main_5th T = new Main_5th();
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
