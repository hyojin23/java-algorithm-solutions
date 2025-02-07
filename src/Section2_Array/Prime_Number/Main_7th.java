package Section2_Array.Prime_Number;

import java.util.Scanner;

public class Main_7th {

    public int solution(int n) {

        int[] arr = new int[n + 1];
        int cnt = 0;
        for (int i = 2; i <= n; i++) {
            if (arr[i] == 0) {
                cnt++;
                for (int j = i; j <= n; j = i + j) {
                    arr[j] = 1;
                }
            }
        }
        return cnt;
    }


    public static void main(String[] args) {

        Main_7th T = new Main_7th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(T.solution(n));
    }
}
