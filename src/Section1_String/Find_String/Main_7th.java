package Section1_String.Find_String;

import java.util.Scanner;

public class Main_7th {

    public int solution(String str, char c) {

        int cnt = 0;
        for (char ch : str.toCharArray()) {
            if (ch == c) {
                cnt++;
            }
        }
        return cnt;
    }


    public static void main(String[] args) {

        Main_7th T = new Main_7th();
        Scanner sc = new Scanner(System.in);

        String str = sc.next().toUpperCase();
        char c = sc.next().toUpperCase().charAt(0);

        System.out.println(T.solution(str, c));
    }
}
