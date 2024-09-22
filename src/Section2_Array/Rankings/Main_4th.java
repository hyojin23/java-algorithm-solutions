package Section2_Array.Rankings;

import java.util.Scanner;

public class Main_4th {

    public int[] solution(int n, int[] arr) {

        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int y : arr) {
                if (arr[i] < y) {
                    cnt++;
                }
            }
            answer[i] = cnt + 1;
        }

        return answer;
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

