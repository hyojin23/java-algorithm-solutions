package Section1_String.Secret_Code;

import java.util.Scanner;

public class Main {

    public int binaryToDecimal(String binary) {
        int decimal = 0;
        int val = 1;
        for (int i = binary.length() - 1; i >= 0; i--) {
            if (binary.charAt(i) == '1') {
                decimal += val;
            }
            val *= 2;
        }
        return decimal;
    }

    public String solution(int n, String str) {

        StringBuilder sb = new StringBuilder();
        str = str.replace("#", "1").replace("*", "0");
        for (int i = 0; i < n; i++) {
            String code = str.substring(0, 7);
            sb.append((char) binaryToDecimal(code));
            str = str.substring(7);
        }
        return sb.toString();
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String str = sc.next();
        System.out.println(T.solution(n, str));
    }
}
