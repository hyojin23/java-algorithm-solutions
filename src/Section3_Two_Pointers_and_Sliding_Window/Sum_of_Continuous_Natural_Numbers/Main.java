package Section3_Two_Pointers_and_Sliding_Window.Sum_of_Continuous_Natural_Numbers;

import java.util.Scanner;

public class Main {

    public int solution(int n) {

        n--;
        int i = 2;
        int answer = 0;
        while (n > 0) {
            n = n - i;
            if (n % i == 0) {
                answer++;
            }
            i++;
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
