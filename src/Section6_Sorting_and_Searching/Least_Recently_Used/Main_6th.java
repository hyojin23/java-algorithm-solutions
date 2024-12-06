package Section6_Sorting_and_Searching.Least_Recently_Used;

import java.util.Scanner;

public class Main_6th {

    public int[] solution(int s, int n, int[] arr) {

        int[] cache = new int[s];

        for (int x : arr) {
            int start = s - 1;
            for (int i = 0; i < s; i++) {
                if (x == cache[i]) {
                    start = i;
                    break;
                }
            }
            for (int i = start; i >= 1; i--) {
                cache[i] = cache[i - 1];
            }
            cache[0] = x;
        }
        return cache;
    }


    public static void main(String[] args) {

        Main_6th T = new Main_6th();
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
