package Section1_String.Valid_Palindrome;

import java.util.Scanner;

public class Main_v2 {

    public String solution(String str) {

        String pureNum = str.toUpperCase().replaceAll("[^A-Z]", "");
        String reversePureNum = new StringBuilder(pureNum).reverse().toString();
        if (pureNum.equals(reversePureNum))
            return "YES";
        return "NO";
    }

    public static void main(String[] args) {

        Main_v2 T = new Main_v2();
        Scanner sc = new Scanner(System.in);
        System.out.println(T.solution(sc.nextLine()));
    }
}
