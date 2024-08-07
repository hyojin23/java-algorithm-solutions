package Section2_Array.Calculating_The_Score;

import java.util.Scanner;

public class Main_3rd {

    public int solution(int n, int[] arr) {

        int s = 0;
        int sum = 0;
        for (int x : arr) {

            if (x == 0) {
                s = 0;
            }
            else if (x == 1) {
                sum += ++s;
            }
        }

        return sum;
    }

    public static void main(String[] args) {

        Main_3rd T = new Main_3rd();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(T.solution(n, arr));
    }
}
