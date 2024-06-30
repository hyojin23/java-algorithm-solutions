package Section1_String.Reverse_Specific_Text;

import java.util.Scanner;

public class Main_2nd {

    public String solution(String str) {

        int lt = 0, rt = str.length() - 1;
        char[] arr = str.toCharArray();

        while (lt < rt) {
            if (Character.isAlphabetic(arr[lt]) && Character.isAlphabetic(arr[rt])) {
                char tmp = arr[lt];
                arr[lt] = arr[rt];
                arr[rt] = tmp;
                lt++;
                rt--;
            }
            else if (Character.isAlphabetic(arr[lt]) && !Character.isAlphabetic(arr[rt])) {
                rt--;
            }
            else {
                lt++;
            }
        }
        return String.valueOf(arr);
    }


    public static void main(String[] args) {

        Main_2nd T = new Main_2nd();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        System.out.println(T.solution(str));
    }
}
