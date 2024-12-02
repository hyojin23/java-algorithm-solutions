package Section2_Array.Visible_Student;

import java.util.Scanner;

public class Main_6th {

    public int solution(int n, int[] arr) {

        int max = Integer.MIN_VALUE;
        int cnt = 0;

        for (int height : arr) {
            if (height > max) {
                cnt++;
                max = height;
            }
        }
        return cnt;
    }


    public static void main(String[] args) {

        Main_6th T = new Main_6th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(T.solution(n, arr));
    }
}
