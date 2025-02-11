package Section3_Two_Pointers_and_Sliding_Window.Sum_of_Continuous_Natural_Numbers;

import java.util.Scanner;

public class Main_7th {

    public int solution(int n) {

        int answer = 0;
        int cnt = 1;
        int sum = n - cnt;
        while (sum > 0) {
            cnt++;
            sum -= cnt;
            if (sum % cnt == 0) {
                answer++;
            }
        }
        return answer;
    }


    public static void main(String[] args) {

        Main_7th T = new Main_7th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(T.solution(n));
    }
}
