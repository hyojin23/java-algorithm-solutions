package Section1_String.Extract_Numbers_Only;

import java.util.Scanner;

public class Main_v2 {

    public int solution(String str) {

        int number = 0;
        for (char c : str.toCharArray()) {
            // if c is int 0 ~ 9
            if (c >= 48 && c <= 57)
                number = number * 10 + (c - 48);
        }
        return number;
    }

    public static void main(String[] args) {

        Main_v2 T = new Main_v2();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }
}
