package Section6_Sorting_and_Searching.Choosing_A_Stable;

import java.util.Scanner;
import java.util.Arrays;

public class Main_3rd {

    public int solution(int n, int c, int[] arr) {

        Arrays.sort(arr);

        int lt = 1;
        int rt = arr[n -1];
        int answer = 0;

        while (lt <= rt) {

            int mid = (lt + rt) / 2;
            int ep = arr[0];
            int cnt = 1;

            for (int x : arr) {
                if (x - ep >= mid) {
                    ep = x;
                    cnt++;
                }

                if (cnt == c) break;
            }

            if (cnt == c) {
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

        Main_3rd T = new Main_3rd();
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
