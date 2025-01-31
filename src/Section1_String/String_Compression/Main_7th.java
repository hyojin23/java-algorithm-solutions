package Section1_String.String_Compression;

import java.util.Scanner;

public class Main_7th {

    public String solution(String str) {

        int len = str.length();
        str = str + " ";
        int cnt = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                cnt++;
            }
            else if (cnt == 1){
                sb.append(str.charAt(i));
                cnt = 1;
            }
            else {
                sb.append(str.charAt(i)).append(cnt);
                cnt = 1;
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {

        Main_7th T = new Main_7th();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        System.out.println(T.solution(str));
    }
}
