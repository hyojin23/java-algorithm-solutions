package Section6_Sorting_and_Searching.Least_Recently_Used;

import java.util.Scanner;

public class Main_5th {

    public int[] solution(int s, int n, int[] arr) {

        int[] cache = new int[s];

        for (int x : arr) {
            boolean cacheHit = false;
            for (int i = 0; i < cache.length; i++) {
                if (x == cache[i]) {
                    for (int j = i - 1; j >= 0; j--) {
                        cache[j + 1] = cache[j];
                    }
                    cacheHit = true;
                    break;
                }
            }
            if (!cacheHit) {
                for (int i = s - 2; i >= 0; i--) {
                    cache[i + 1] = cache[i];
                }
            }
            cache[0] = x;
        }
        return cache;
    }


    public static void main(String[] args) {

        Main_5th T = new Main_5th();
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
