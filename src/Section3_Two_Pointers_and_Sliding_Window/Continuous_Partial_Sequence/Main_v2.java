package Section3_Two_Pointers_and_Sliding_Window.Continuous_Partial_Sequence;

import java.util.Scanner;

public class Main_v2 {

    public int solution(int n, int m, int[] arr) {
        int answer = 0, sum = 0, lt = 0;
        for (int rt = 0; rt < n; rt++) {
            sum += arr[rt];
            if (sum == m)
                answer++;
            while (sum >= m) {
                sum -= arr[lt++];
                if (sum == m)
                    answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

       Main_v2 T = new Main_v2();
       Scanner sc = new Scanner(System.in);

       int n = sc.nextInt();
       int m = sc.nextInt();
       int[] arr = new int[n];

       for (int i = 0; i < n; i++) {
           arr[i] = sc.nextInt();
       }

       System.out.println(T.solution(n, m, arr));
    }
}
