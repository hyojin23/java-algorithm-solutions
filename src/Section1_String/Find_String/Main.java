package Section1_String.Find_String;

import java.util.Scanner;

public class Main {

    public int solution(String str, char c) {

        int answer = 0;

        for (char s : str.toLowerCase().toCharArray()) {

            if (s == c) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        char c = sc.next().toLowerCase().charAt(0);

        System.out.println(T.solution(str, c));
    }
}
