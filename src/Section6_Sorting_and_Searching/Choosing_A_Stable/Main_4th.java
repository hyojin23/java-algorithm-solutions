package Section6_Sorting_and_Searching.Choosing_A_Stable;

import java.util.Scanner;
import java.util.Arrays;

public class Main_4th {

    public boolean isPosPlace(int mid, int c, int[] arr) {

        int cnt = 1;
        int sel = arr[0];
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] >= sel + mid) {
                cnt++;
                sel = arr[i];
            }
        }

        return cnt >= c;
    }

    public int solution(int n, int c, int[] arr) {

        Arrays.sort(arr);

        int lt = arr[1] - arr[0];
        int rt = Arrays.stream(arr).max().getAsInt() - Arrays.stream(arr).min().getAsInt();
        int answer = 0;

        while (lt <= rt) {

            int mid = (rt + lt) / 2;

            if (isPosPlace(mid, c, arr)) {
                lt = mid + 1;
                answer = mid;
            }
            else {
                rt = mid - 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Main_4th T = new Main_4th();
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
