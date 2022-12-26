package Section1_String.Find_String;

import java.util.Scanner;

public class Main_v2 {

    public int solution(String str, char c) {

        int count = 0;
        c = Character.toUpperCase(c);

        for (char stringCharacters : str.toUpperCase().toCharArray()) {
            if (stringCharacters == c) {
                count += 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Main_v2 T = new Main_v2();
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        char c = scan.next().charAt(0);
        System.out.println(T.solution(str, c));
    }
}
