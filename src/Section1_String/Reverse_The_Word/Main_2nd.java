package Section1_String.Reverse_The_Word;

import java.util.Scanner;

public class Main_2nd {

    public String[] solution(int n, String[] arr) {

        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            char[] s = arr[i].toCharArray();
            int lt = 0, rt = s.length - 1;

            while (lt < rt) {
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
            answer[i] = String.valueOf(s);
        }
        return answer;
    }

    public static void main(String[] args) {

        Main_2nd T = new Main_2nd();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        for (String s : T.solution(n, arr)) {
            System.out.println(s);
        }
    }
}
