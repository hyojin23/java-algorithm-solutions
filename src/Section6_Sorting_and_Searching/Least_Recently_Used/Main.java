package Section6_Sorting_and_Searching.Least_Recently_Used;

import java.util.Scanner;

public class Main {

    public int[] solution(int s, int n, int[] arr) {

        int[] cache = new int[s];

        for (int job : arr) {
            int i;
            for (i = s - 1; i >= 0; i--) {
                if (cache[i] == job) {
                    break;
                }
            }

            // Cache Miss
            int k;
            if (i == -1) {
                k = s - 1;
            }
            // Cache Hit
            else {
                k = i;
            }
            for (int j = k - 1; j >= 0; j--) {
                cache[j + 1] = cache[j];
            }
            cache[0] = job;
        }

        return cache;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int x : T.solution(s, n, arr)) {
            System.out.print(x + " ");
        }
    }
}
