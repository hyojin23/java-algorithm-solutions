package Section2_Array.Reverse_Prime_Number;

import java.util.Scanner;

public class Main {

    public void solution(int n, int[] arr) {

        for (int x : arr) {
            boolean isPrime = true;
            int num = Integer.parseInt(new StringBuilder(String.valueOf(x)).reverse().toString());

            if (num == 1) {
                isPrime = false;
            }

            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.print(num + " ");
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
