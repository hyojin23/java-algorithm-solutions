package Section6_Sorting_and_Searching.Choosing_A_Stable;

import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public int solution(int n, int c, int[] arr) {

        int lt = 1;
        int rt = Arrays.stream(arr).max().getAsInt() - Arrays.stream(arr).min().getAsInt();

        Arrays.sort(arr);

        int mid;
        int answer = 0;

        while (lt <= rt) {

            mid = (lt + rt) / 2;

            int cnt = 1;
            int std = arr[0];
            for (int x : arr) {
                if (x >= std + mid) {
                    cnt++;
                    std = x;
                }
            }

            if (cnt < c) {
                rt = mid - 1;
            }
            else {
                answer = mid;
                lt = mid + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Main T = new Main();
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
