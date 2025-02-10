package Section2_Array.Rankings;

import java.util.Scanner;

public class Main_7th {

    public int[] solution(int n, int[] scores) {

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int grade = 1;
            for (int other : scores) {
                if (other > scores[i]) {
                    grade++;
                }
            }
            answer[i] = grade;
        }
        return answer;
    }


    public static void main(String[] args) {

        Main_7th T = new Main_7th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] scores = new int[n];

        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        for (int x : T.solution(n, scores)) {
            System.out.print(x + " ");
        }
    }
}
