package Section6_Sorting_and_Searching.Least_Recently_Used;

import java.util.Scanner;
// My solution
public class Main2 {

    public int[] pushBackNumbers(int p, int[] arr) {
        for (int i=p-1; i>0; i--) {
            arr[i]  = arr[i-1];
        }
        return arr;
    }

    public int[] cacheMiss(int j, int[] arr) {
        pushBackNumbers(arr.length, arr)[0] = j;
        return arr;
    }

    public int[] cacheHit(int j, int[] arr) {
        int idx = 0;
        for (int x : arr) {
            if (x == j) {
                break;
            }
            idx++;
        }
        int tmp = arr[idx];
        pushBackNumbers(idx+1, arr)[0] = tmp;
        return arr;
    }

    public int[] solution(int s, int n, int[] arr) {
        int[] cache = new int[s];
        for (int x : arr) {
            boolean isCacheHit = false;
            for (int y : cache) {
                if (x == y) {
                    cache = cacheHit(y, cache);
                    isCacheHit = true;
                }
            }
            if (!isCacheHit) {
                cacheMiss(x, cache);
            }
        }
        return cache;
    }

    public static void main(String[] args) {
        Main2 T = new Main2();
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int x : T.solution(s, n, arr)) {
            System.out.print(x + " ");
        }
    }
}
