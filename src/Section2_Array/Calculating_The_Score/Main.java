package Section2_Array.Calculating_The_Score;

import java.util.Scanner;

public class Main {

    public int solution(int[] arr) {

        int score = 0;
        int sum = 0;
        for (int x : arr) {
            if (x == 0) {
                score = 0;
            }
            else {
                sum += ++score;
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(T.solution(arr));
    }
}
