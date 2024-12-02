package Section2_Array.Rankings;

import java.util.Scanner;

public class Main_6th {

    public int[] solution(int n, int[] arr) {

        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            int grade = 1;
            for (int j = 0; j < n; j++) {
                if (arr[j] > arr[i]) {
                    grade++;
                }
            }
            answer[i] = grade;
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

        for (int x : T.solution(n, arr)) {
            System.out.print(x + " ");
        }
    }
}
