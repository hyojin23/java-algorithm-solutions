package Section1_String.Find_String;

import java.util.Scanner;

public class Main_4th {

    public int solution(String str, char c) {

        int answer = 0;

        for (char x : str.toCharArray()) {
            if (x == c) {
                answer++;
            }
        }

        return answer;
    }


    public static void main(String[] args) {

        Main_4th T = new Main_4th();
        Scanner sc = new Scanner(System.in);

        String str = sc.next().toLowerCase();
        char c = sc.next().toLowerCase().charAt(0);

        System.out.println(T.solution(str, c));
    }
}
