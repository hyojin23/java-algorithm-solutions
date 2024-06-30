package Section1_String.Extract_Numbers_Only;

import java.util.Scanner;

public class Main {

    public int solution(String str) {

        int answer = 0;

        for (char c : str.toCharArray()) {

            if (c >= 48 && c <= 57) {
                answer = answer * 10 + (c - 48);
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        System.out.println(T.solution(str));
    }
}
