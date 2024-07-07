package Section1_String.Reverse_Specific_Text;

import java.util.Scanner;

public class Main_3rd {

    public String solution(String str) {

        char[] cArr = str.toCharArray();
        int lt = 0;
        int rt = str.length() - 1;

        while (lt < rt) {

            if (!Character.isAlphabetic(cArr[lt])) {
                lt++;

            }
            else if (!Character.isAlphabetic(cArr[rt])) {
                rt--;
            }
            else {
                char tmp = cArr[lt];
                cArr[lt] = cArr[rt];
                cArr[rt] = tmp;
                lt++;
                rt--;
            }
        }

        return String.valueOf(cArr);
    }

    public static void main(String[] args) {

        Main_3rd T = new Main_3rd();
        Scanner sc = new Scanner(System.in);

        String n = sc.next();

        System.out.println(T.solution(n));
    }
}
