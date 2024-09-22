package Section2_Array.Visible_Student;

import java.util.Scanner;

public class Main_4th {

    public int solution(int n, int[] arr) {

        int max = 0;
        int cnt = 0;
        for (int x : arr) {
            if (x > max) {
                cnt++;
                max = x;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {

        Main_4th T = new Main_4th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(T.solution(n, arr));
    }
}
