package Section1_String.Reverse_Specific_Text;

import java.util.Scanner;

public class Main_6th {

    public String solution(String str) {

        int lt = 0;
        int rt = str.length() - 1;
        char[] charArr = str.toCharArray();

        while (lt < rt) {
            if (Character.isAlphabetic(charArr[lt]) && Character.isAlphabetic(charArr[rt])) {
                char tmp = charArr[lt];
                charArr[lt] = charArr[rt];
                charArr[rt] = tmp;
                lt++;
                rt--;
            }
            else if (Character.isAlphabetic(charArr[lt])) {
                rt--;
            }
            else if (Character.isAlphabetic(charArr[rt])) {
                lt++;
            }
            else {
                lt++;
                rt--;
            }
        }
        return String.valueOf(charArr);
    }


    public static void main(String[] args) {

        Main_6th T = new Main_6th();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        System.out.println(T.solution(str));
    }
}
