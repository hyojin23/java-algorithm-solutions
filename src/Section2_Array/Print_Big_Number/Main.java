package Section2_Array.Print_Big_Number;

import java.util.Scanner;

public class Main {

    public void solution(int n, int[] arr) {

        System.out.print(arr[0] + " ");

        for (int i = 1; i < n; i++) {

            if (arr[i] > arr[i - 1]) {
                System.out.print(arr[i] + " ");
            }
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        T.solution(n, arr);
    }
}
