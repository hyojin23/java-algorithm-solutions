package Section2_Array.Prime_Number;

import java.util.Scanner;

public class Main {

    public int solution(int n) {

        int answer = 0;
        int[] ch = new int[n + 1];

        for (int i = 2; i < n + 1; i++) {

            if (ch[i] == 0) {
                answer++;
            }
            for (int j = 2; i * j < n + 1; j++) {
                ch[i * j] = 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(T.solution(n));
    }
}
