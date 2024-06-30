package Section2_Array.Prime_Number;

import java.util.Scanner;

public class Main_2nd {

    public int solution(int n) {

        int[] ch = new int[n + 1];
        int answer = 0;

        for (int i = 2; i <= n; i++) {
            if (ch[i] == 0) {
                for (int j = i; j <= n; j = j + i) {
                    ch[j] = 1;
                }
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        Main_2nd T = new Main_2nd();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(T.solution(n));
    }
}
