package Section6_Sorting_and_Searching.Music_Video;

import java.util.Scanner;
import java.util.Arrays;

public class Main_4th {

    public boolean isPosRecord(int mid, int m, int[] arr) {

        int sum = 0;
        int cnt = 1;
        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];

            if (sum > mid) {
                i--;
                sum = 0;
                cnt++;
            }
        }

        return cnt <= m;
    }

    public int solution(int n, int m, int[] arr) {

        int lt = Arrays.stream(arr).max().isPresent() ? Arrays.stream(arr).max().getAsInt() : 0;
        int rt = Arrays.stream(arr).sum();
        int answer = 0;

        while (lt <= rt) {

            int mid = (lt + rt) / 2;

            if (isPosRecord(mid, m, arr)) {
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

        Main_4th T = new Main_4th();
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
