package Section2_Array.Reverse_Prime_Number;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_v2 {

    public boolean isPrime(int num) {

        if (num == 1)
            return false;
        for (int i = 2; i < num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public List<Integer> solution(int[] arr) {

        List<Integer> answer = new ArrayList<>();

        for (int i : arr) {
            int tmp = i;
            int res = 0;
            while (tmp > 0) {
                int t = tmp % 10;
                res = res * 10 + t;
                tmp = tmp / 10;
            }
            if (isPrime(res))
                answer.add(res);
        }

        return answer;
    }

    public static void main(String[] args) {

        Main_v2 T = new Main_v2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i : T.solution(arr))
            System.out.print(i + " ");
    }
}
