package Section1_String.Valid_Palindrome;

import java.util.Scanner;

public class Main_5th {

    public String solution(String str) {

        int lt = 0;
        int rt = str.length() - 1;
        char[] arr = str.toCharArray();

        while (lt < rt) {
            char a = arr[lt];
            char b = arr[rt];

            if (Character.isAlphabetic(a) && Character.isAlphabetic(b)) {
                if (a != b) {
                    return "NO";
                }
                lt++;
                rt--;
            }
            else if (!Character.isAlphabetic(a)) {
                lt++;
            }
            else if (!Character.isAlphabetic(b)) {
                rt--;
            }
            else {
                lt++;
                rt--;
            }
        }
        return "YES";
    }


    public static void main(String[] args) {

        Main_5th T = new Main_5th();
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine().toLowerCase();

        System.out.println(T.solution(str));
    }
}
