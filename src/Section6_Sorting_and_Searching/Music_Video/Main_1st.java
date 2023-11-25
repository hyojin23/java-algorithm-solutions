package Section6_Sorting_and_Searching.Music_Video;

import java.util.Scanner;

public class Main_1st {

    public int solution(int n, int m, int allTime, int[] arr) {

        int answer = 0;
        int lt = 1;
        int rt = allTime;
        int mid = (lt + rt) / 2;

        while (lt < rt) {

            boolean isRecordable = enoughRecord(arr, mid, m);

            if (isRecordable) {
                rt = mid;
            }
            else {
                lt = mid + 1;
            }

            mid = (lt + rt) / 2;
        }

        answer = mid;

        return answer;
    }

    private boolean enoughRecord(int[] arr, int mid, int videoCnt) {

        int sum = 0;
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum > mid) {
                i--;
                sum = 0;
                cnt++;
            }
        }
        cnt++;

        return cnt <= videoCnt;
    }

    public static void main(String[] args) {

        Main_1st T = new Main_1st();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int allTime = 0;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            allTime += arr[i];
        }

        System.out.println(T.solution(n, m, allTime, arr));
    }
}
