package Section1_String.Reverse_Specific_Text;

import java.util.Scanner;

public class Main_v2 {

    public String solution(String str) {

        char[] wordArr = str.toCharArray();
        int lt = 0, rt = str.length() - 1;
        while (lt < rt) {
            if (!Character.isAlphabetic(wordArr[lt])) {
                lt++;
            } else if (!Character.isAlphabetic(wordArr[rt])) {
                rt--;
            } else {
                char tmp = wordArr[lt];
                wordArr[lt] = wordArr[rt];
                wordArr[rt] = tmp;
                lt++;
                rt--;
            }
        }
        return String.valueOf(wordArr);
    }

    public static void main(String[] args) {

        Main_v2 T = new Main_v2();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }
}
