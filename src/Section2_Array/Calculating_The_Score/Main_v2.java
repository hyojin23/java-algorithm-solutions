package Section2_Array.Calculating_The_Score;

import java.util.Scanner;

public class Main_v2 {

    public int solution(int[] arr) {

        int s = 0;
        int t = 0;

        for (int i : arr) {
            if (i == 1) {
                t += ++s;
            } else {
              s = 0;
            }
        }
        return t;
    }

    public static void main(String[] args) {

        Main_v2 T = new Main_v2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(arr));
    }
}
