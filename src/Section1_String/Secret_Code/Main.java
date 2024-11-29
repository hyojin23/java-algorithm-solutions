package Section1_String.Secret_Code;

import java.util.Scanner;

public class Main {

    public String solution(int n, String str) {

        str = str.replace('#', '1').replace('*', '0');
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String code = str.substring(0, 7);
            //sb.append((char) Integer.parseInt(code, 2));
            sb.append((char) binaryToDecimal(code));
            str = str.substring(7);
        }
        return sb.toString();
    }

    public int binaryToDecimal(String binary) {

        int result = 0;
        int digit = 1;
        for (int i = binary.length() - 1; i >= 0; i--) {
            if (binary.charAt(i) == '1') {
                result = result + digit;
            }
            digit = digit * 2;
        }
        return result;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String str = sc.next();

        System.out.println(T.solution(n, str));
    }
}
