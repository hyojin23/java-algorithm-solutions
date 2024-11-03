package Section1_String.Case_Change;

import java.util.Scanner;

public class Main {

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

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

       T.solution(str);
    }
}
