package Section6_Sorting_and_Searching.Least_Recently_Used;

import java.util.Scanner;

public class Main_7th {

    public int[] solution(int s, int n, int[] arr) {

        int[] cache = new int[s];
        for (int job : arr) {
            boolean cacheHit = false;
            for (int i = 0; i < s; i++) {
                if (job == cache[i]) {
                    for (int j = i - 1; j >= 0; j--) {
                        cache[j + 1] = cache[j];
                    }
                    cacheHit = true;
                    break;
                }
            }
            if (!cacheHit) {
                for (int j = s - 2; j >= 0; j--) {
                    cache[j + 1] = cache[j];
                }
            }
            cache[0] = job;
        }
        return cache;
    }


    public static void main(String[] args) {

        Main_7th T = new Main_7th();
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
