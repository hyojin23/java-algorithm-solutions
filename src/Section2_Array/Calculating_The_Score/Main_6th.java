package Section2_Array.Calculating_The_Score;

import java.util.Scanner;

public class Main_6th {

    public int solution(int n, int[] arr) {

        int answer = 0;
        int score = 0;
        for (int x : arr) {
            if (x == 0) {
                score = 0;
            }
            else {
                answer += ++score;
            }
        }
        return answer;
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
