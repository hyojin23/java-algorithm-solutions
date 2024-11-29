package Section1_String.Find_String;

import java.util.Scanner;

public class Main_6th {

    public int solution(String str, char ch) {

        int answer = 0;
        for (char c : str.toCharArray()) {
            if (ch == c) {
                answer++;
            }
        }
        return answer;
    }


    public static void main(String[] args) {

        Main_6th T = new Main_6th();
        Scanner sc = new Scanner(System.in);

        String str = sc.next().toLowerCase();
        char ch = sc.next().toLowerCase().charAt(0);

        System.out.println(T.solution(str, ch));
    }
}
