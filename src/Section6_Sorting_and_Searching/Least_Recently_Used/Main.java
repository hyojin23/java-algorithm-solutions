package Section6_Sorting_and_Searching.Least_Recently_Used;

import java.util.Scanner;

public class Main {

    public int[] solution(int s, int n, int[] arr) {

        int[] cache = new int[s];
        cache[0] = arr[0];
        boolean isCacheHit;

        for (int i = 1; i < n; i++) {
            isCacheHit = false;
            for (int j = 0; j < s; j++) {
                // cache hit
                if (cache[j] == arr[i]) {
                    int k;
                    for (k = j - 1; k >= 0; k--) {
                        cache[k + 1] = cache[k];
                    }
                    cache[k + 1] = arr[i];
                    isCacheHit = true;
                    break;
                }
            }
            // cache miss
            if (!isCacheHit) {
                int k;
                for (k = s - 2; k >= 0; k--) {
                    cache[k + 1] = cache[k];
                }
                cache[k + 1] = arr[i];
            }
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
