package Section2_Array.Visible_Student;

import java.util.Scanner;

public class Main_v2 {

    public int solution(int[] arr) {

        int answer = 0;
        int max = Integer.MIN_VALUE;

        for (int i : arr) {

            if (i > max)
                max = i;
            else if (i == max)
                continue;

            if (i == max)
                answer++;
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
        System.out.println(T.solution(arr));
    }
}