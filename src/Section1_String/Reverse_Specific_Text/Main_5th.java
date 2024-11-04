package Section1_String.Reverse_Specific_Text;

import java.util.Scanner;

public class Main_5th {

    public String solution(String str) {

        char[] chArr = str.toCharArray();
        int lt = 0;
        int rt = chArr.length - 1;

        while (lt < rt) {
            if (Character.isAlphabetic(chArr[lt]) && Character.isAlphabetic(chArr[rt])) {
                char tmp = chArr[lt];
                chArr[lt] = chArr[rt];
                chArr[rt] = tmp;
                lt++;
                rt--;
            }
            else if (!Character.isAlphabetic(chArr[lt])) {
                lt++;
            }
            else if (!Character.isAlphabetic(chArr[rt])) {
                rt--;
            }
            else {
                lt++;
                rt--;
            }
        }
        return String.valueOf(chArr);
    }


    public static void main(String[] args) {

        Main_5th T = new Main_5th();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        System.out.println(T.solution(str));
    }
}
