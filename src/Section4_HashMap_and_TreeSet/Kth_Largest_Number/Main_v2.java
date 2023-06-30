package Section4_HashMap_and_TreeSet.Kth_Largest_Number;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class Main_v2 {

    public int solution(int[] arr, int n, int k) {

        TreeSet<Integer> tSet = new TreeSet<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int l = j + 1; l < n; l++) {
                    tSet.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }

        int cnt = 0;
        for (int x : tSet) {
            cnt++;
            if (cnt == k) return x;
        }

        return -1;
    }

    public static void main(String[] args) {

        Main_v2 T = new Main_v2();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(arr, n, k));

    }
}
