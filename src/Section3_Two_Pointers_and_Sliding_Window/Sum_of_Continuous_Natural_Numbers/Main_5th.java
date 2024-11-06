package Section3_Two_Pointers_and_Sliding_Window.Sum_of_Continuous_Natural_Numbers;

import java.util.Scanner;

public class Main_5th {

    public int solution(int n) {

        int lt = 1;
        int sum = 0;
        int answer = 0;

        for (int rt = 1; rt <= n / 2 + 1; rt++) {
            sum += rt;
            if (sum == n) {
                answer++;
            }
            while (sum >= n) {
                sum -= lt++;
                if (sum == n) {
                    answer++;
                }
            }
        }
        return answer;
    }


    public static void main(String[] args) {

        Main_5th T = new Main_5th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(T.solution(n));
    }
}
