package Section2_Array.Rock_Paper_Scissors;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public ArrayList<Character> solution(int n, int[] a, int[] b) {
        ArrayList<Character> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (a[i] == b[i]) {
                answer.add('D');
                // (1,3) : (scissor, paper) case
            } else if (a[i] + b[i] == 4) {
                if (a[i] < b[i]) {
                    answer.add('A');
                } else {
                    answer.add('B');
                }
            } else {
                if (a[i] > b[i]) {
                    answer.add('A');
                } else {
                    answer.add('B');
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        for (char x : T.solution(n, a, b)) {
            System.out.println(x);
        }
    }
}
