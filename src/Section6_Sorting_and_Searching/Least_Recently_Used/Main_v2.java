package Section6_Sorting_and_Searching.Least_Recently_Used;

import java.util.Scanner;

public class Main_v2 {

    public int[] solution(int s, int n, int[] job) {

        int[] cache = new int[s];
        boolean isCacheHit;

        for (int i = 0; i < n; i++) {
            isCacheHit = false;
            for (int j = 0; j < s; j++) {
                if (cache[j] == job[i]) {
                    cacheHit(job[i], j, cache);
                    isCacheHit = true;
                    break;
                }
            }
            if (!isCacheHit) {
                cacheMiss(job[i], cache);
            }
        }
        return cache;
    }

    public void cacheMiss(int target, int[] cache) {

        int n = cache.length;

        for (int i = 0; i < n -1; i++) {
            cache[n - i - 1] = cache[n - i - 2];
        }
        cache[0] = target;
    }

    public void cacheHit(int target, int targetIdx, int[] cache) {

        for (int i = 0; i < targetIdx; i++) {
            cache[targetIdx - i] = cache[targetIdx - i - 1];
        }
        cache[0] = target;
    }

    public static void main(String[] args) {

        Main_v2 T = new Main_v2();
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i : T.solution(s, n, arr)) {
            System.out.print(i + " ");
        }
    }
}
