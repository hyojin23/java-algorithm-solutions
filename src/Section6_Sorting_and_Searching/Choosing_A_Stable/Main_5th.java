package Section6_Sorting_and_Searching.Choosing_A_Stable;

import java.util.Scanner;
import java.util.Arrays;

public class Main_5th {

    public boolean canArrange(int targetCnt, int distance, int[] arr) {

        Arrays.sort(arr);

        int pos = arr[0];
        int cnt = 1;
        for (int x : arr) {
            if (x >= pos + distance) {
                pos = x;
                cnt++;
            }
        }

        return cnt >= targetCnt;
    }

    public int solution(int n, int c, int[] arr) {

        int lt = 1;
        int rt = Arrays.stream(arr).max().getAsInt() - Arrays.stream(arr).min().getAsInt();
        int answer = 0;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            boolean canArrage = canArrange(c, mid, arr);

            if (canArrage) {
                answer = mid;
                lt = mid + 1;
            }
            else {
                rt = mid - 1;
            }
        }
        return answer;
    }


    public static void main(String[] args) {

        Main_5th T = new Main_5th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(T.solution(n, c, arr));
    }
}
