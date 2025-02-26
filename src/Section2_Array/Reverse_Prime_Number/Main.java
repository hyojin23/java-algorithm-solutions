package Section2_Array.Reverse_Prime_Number;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {

    public boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> solution(int n, int[] arr) {

        List<Integer> list = new ArrayList<>();
        for (int x : arr) {
            int res = 0;
            while (x > 0) {
                int remain = x % 10;
                x = x / 10;
                res = res * 10 + remain;
            }
            if (isPrime(res)) {
                list.add(res);
            }
        }
        return list;
    }


    public static void main(String[] args) {

        Main T = new Main();
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
