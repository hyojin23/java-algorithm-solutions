package Section1_String.Case_Change;

import java.util.Scanner;

public class Main_6th {

    public void solution(String str) {

        for (char c : str.toCharArray()) {
            if (Character.isLowerCase(c)) {
                System.out.print(Character.toUpperCase(c));
            }
            else {
                System.out.print(Character.toLowerCase(c));
            }
        }
    }


    public static void main(String[] args) {

        Main_6th T = new Main_6th();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

       T.solution(str);
    }
}
