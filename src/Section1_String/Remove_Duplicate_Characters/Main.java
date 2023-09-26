package Section1_String.Remove_Duplicate_Characters;

import java.util.*;

public class Main {

    public void solution(String str) {

        for (int i = 0; i < str.length(); i++) {
            if (i == str.indexOf(str.charAt(i))) {
                System.out.print(str.charAt(i));
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


