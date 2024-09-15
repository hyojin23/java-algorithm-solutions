package Section1_String.Valid_Palindrome;

import java.util.Scanner;

public class Main_4th {

    public String solution(String str) {

        int lt = 0;
        int rt = str.length() - 1;

        while (lt < rt) {
            if (!Character.isAlphabetic(str.charAt(lt))) {
                lt++;
            }
            else if (!Character.isAlphabetic(str.charAt(rt))) {
                rt--;
            }
            else {
                if (str.charAt(lt) != str.charAt(rt)) {
                    return "NO";
                }
                lt++;
                rt--;
            }
        }

        return "YES";
    }

    public static void main(String[] args) {

        Main_4th T = new Main_4th();
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine().toLowerCase();

        System.out.println(T.solution(str));
    }
}