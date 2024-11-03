package Section1_String.Find_String;

import java.util.Scanner;

public class Main_5th {
    public int solution(String s, char c) {

        int cnt = 0;
        for (char ch : s.toCharArray()) {
            if (ch == c) {
                cnt++;
            }
        }
        return cnt;
    }


    public static void main(String[] args) {

        Main_5th T = new Main_5th();
        Scanner sc = new Scanner(System.in);

        String s = sc.next().toLowerCase();
        char c = sc.next().toLowerCase().charAt(0);

        System.out.println(T.solution(s, c));
    }
}
