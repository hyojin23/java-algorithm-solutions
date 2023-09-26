package Section2_Array.Reverse_Prime_Number;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {

    public List<Integer> solution(int[] arr) {

        List<Integer> list = new ArrayList<>();

        for (int x : arr) {

            int cnt = 0;
            int r = 0;

            while (x != 0) {
                r = r * 10 + (x % 10);
                x = x / 10;
            }

            for (int i = 1; i <= r; i++) {
                if (r % i == 0) {
                    cnt++;
                }

                if (cnt > 2) {
                    break;
                }
            }

            if (cnt == 2) {
                list.add(r);
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

        for (int x : T.solution(arr)) {
            System.out.print(x + " ");
        }
    }
}
