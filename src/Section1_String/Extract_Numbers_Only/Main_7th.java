package Section1_String.Extract_Numbers_Only;

import java.util.Scanner;

public class Main_7th {

    public int solution(String str) {

        int answer = 0;
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                answer = answer * 10 + (c - 48);
            }
        }
        return answer;
    }


    public static void main(String[] args) {

        Main_7th T = new Main_7th();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        System.out.println(T.solution(str));
    }
}
