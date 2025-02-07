package Section2_Array.Reverse_Prime_Number;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main_7th {

    public boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


    public List<Integer> solution(int n, int[] arr) {

        List<Integer> list = new ArrayList<>();
        for (int x : arr) {
            int result = 0;
            while (x > 0) {
                int remain = x % 10;
                result = result * 10 + remain;
                x = x / 10;
            }
            if (isPrime(result)) {
                list.add(result);
            }
        }
        return list;
    }


    public static void main(String[] args) {

        Main_7th T = new Main_7th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int x : T.solution(n, arr)) {
            System.out.print(x + " ");
        }
    }
}
