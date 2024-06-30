package Section6_Sorting_and_Searching.Least_Recently_Used;

import java.util.Scanner;

public class Main {

    public int[] solution(int s, int n, int[] job) {

        int[] cache = new int[s];
        boolean isCacheHit;
        int hitIndex = 0;

        for (int i = 0; i < n; i++) {
            isCacheHit = false;
            for (int j = 0; j < s; j++) {

                // cache hit
                if (job[i] == cache[j]) {
                    isCacheHit = true;
                    hitIndex = j;
                }

            }

            if (isCacheHit) {
                for (int k = hitIndex - 1; k >= 0; k--) {
                    cache[k + 1] = cache[k];
                }
            }
            else {
                for (int k = s - 2; k >= 0; k--) {
                    cache[k + 1] = cache[k];
                }
            }

            cache[0] = job[i];
        }

        return cache;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        int n = sc.nextInt();
        int[] job = new int[n];

        for (int i = 0; i < n; i++) {
            job[i] = sc.nextInt();
        }

        for (int i : T.solution(s, n, job)) {
            System.out.print(i + " ");
        }
    }
}
