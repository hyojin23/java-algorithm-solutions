package Section2_Array.Visible_Student;

import java.util.Scanner;

public class Main_5th {

    public int solution(int n, int[] arr) {

        int max = arr[0];
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                cnt++;
                max = arr[i];
            }
        }
        return cnt;
    }

    public static void main(String[] args) {

        Main_5th T = new Main_5th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(T.solution(n, arr));
    }
}
