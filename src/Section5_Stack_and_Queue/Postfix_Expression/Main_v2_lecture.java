package Section5_Stack_and_Queue.Postfix_Expression;

import java.util.Scanner;
import java.util.Stack;

public class Main_v2_lecture {

    public int solution(String str) {

        int answer;
        Stack<Integer> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(c - 48);
            }
            else {
                int rt = stack.pop();
                int lt = stack.pop();

                if (c == '+') stack.push(lt + rt);
                else if (c == '-') stack.push(lt - rt);
                else if (c == '*') stack.push(lt * rt);
                else if (c == '/') stack.push(lt / rt);
            }
        }
        answer = stack.get(0);
        return answer;
    }

    public static void main(String[] args) {

        Main_v2_lecture T = new Main_v2_lecture();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        System.out.println(T.solution(str));
    }
}
