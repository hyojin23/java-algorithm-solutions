package Section3_Two_Pointers_and_Sliding_Window.Sum_of_Continuous_Natural_Numbers;

import java.util.Scanner;

public class Main_6th {

    public int solution(int n) {

        int answer = 0;
        n -= 1;
        int i = 1;
        while (n > 0) {
            n -= ++i;
            if (n % i == 0) {
                answer++;
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