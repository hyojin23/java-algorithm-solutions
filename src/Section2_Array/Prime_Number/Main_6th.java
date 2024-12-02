package Section2_Array.Prime_Number;

import java.util.Scanner;

public class Main_6th {

    public int solution(int n) {

        int[] ch = new int[n + 1];
        int answer = 0;

        for (int i = 2; i <= n; i++) {
            if (ch[i] == 0) {
                answer++;
            }
            for (int j = 2; i * j <= n; j++) {
                ch[i * j] = 1;
            }
        }
        return answer;
    }


    public static void main(String[] args) {

        Main_6th T = new Main_6th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(T.solution(n));
    }
}
