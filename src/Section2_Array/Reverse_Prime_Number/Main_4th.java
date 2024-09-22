package Section2_Array.Reverse_Prime_Number;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main_4th {

    public List<Integer> solution(int n, int[] arr) {

        List<Integer> list = new ArrayList<>();
        int[] rvsArr = new int[n];

        int max = 0;
        for (int i = 0; i < n; i++) {
            int res = 0;
            while (arr[i] != 0) {
                res = res * 10 + (arr[i] % 10);
                arr[i] = arr[i] / 10;
            }
            max = Math.max(max, res);
            rvsArr[i] = res;
        }

        int[] ch = new int[max + 1];
        ch[1] = 1;

        for (int i = 2; i <= max; i++) {
            if (ch[i] == 0) {
                for (int j = i; j <= max; j = j + i) {
                    if (j != i) {
                        ch[j] = 1;
                    }
                }
            }
        }

        for (int i : rvsArr) {
            if (ch[i] == 0) {
                list.add(i);
            }
        }

        return list;
    }

    public static void main(String[] args) {

        Main_4th T = new Main_4th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i : T.solution(n, arr)) {
            System.out.print(i + " ");
        }
    }
}
