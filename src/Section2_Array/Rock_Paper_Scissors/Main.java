package Section2_Array.Rock_Paper_Scissors;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public List<Character> solution(int[] A, int[] B, int n) {

        List<Character> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (A[i] == B[i]) {
                answer.add('D');
            } else if (A[i] == 1 && B[i] == 3) {
                answer.add('A');
            } else if (A[i] == 2 && B[i] == 1) {
                answer.add('A');
            } else if (A[i] == 3 && B[i] == 2) {
                answer.add('A');
            } else {
                answer.add('B');
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];

        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            B[i] = sc.nextInt();
        }

        for (char c : T.solution(A, B, n)) {
            System.out.println(c);
        }
    }
}
