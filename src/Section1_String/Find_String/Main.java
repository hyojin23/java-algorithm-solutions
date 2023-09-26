package Section1_String.Find_String;

import java.util.Scanner;

public class Main {

    public int solution(String str, char c) {

        int cnt = 0;

        for (char x : str.toCharArray()) {
            char a = Character.toLowerCase(x);
            char b = Character.toLowerCase(c);
            if (a == b) {
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        char c = sc.next().charAt(0);

        System.out.println(T.solution(str, c));
    }
}
