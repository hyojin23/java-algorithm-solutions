package Section1_String.Valid_Palindrome;

import java.util.Scanner;

public class Main {

    public String solution(String str) {

        int lt = 0, rt = str.length() - 1;
        while (lt < rt) {
            if (!Character.isAlphabetic(str.charAt(lt))) {
                lt++;
            }
            if (!Character.isAlphabetic(str.charAt(rt))) {
                rt--;
            }
            if (Character.isAlphabetic(str.charAt(lt)) && Character.isAlphabetic(str.charAt(rt))) {
                if (str.charAt(lt) != str.charAt(rt)) {
                    return "NO";
                }
                else {
                    lt++;
                    rt--;
                }
            }
        }
        return "YES";
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine().toUpperCase();
        System.out.println(T.solution(str));
    }
}
