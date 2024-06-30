package Section5_Stack_and_Queue.Postfix_Expression;

import java.util.Scanner;
import java.util.Stack;

public class Main_2nd {

    public int solution(String str) {

        Stack<Integer> stack = new Stack<>();

        for (char c : str.toCharArray()) {

            if (Character.isDigit(c)) {
                stack.push(c - 48);
            }
            else {

                int rt = stack.pop();
                int lt = stack.pop();

                if (c == '+') {
                    stack.push(lt + rt);
                }
                else if (c == '-') {
                    stack.push(lt - rt);
                }
                else if (c == '*') {
                    stack.push(lt * rt);
                }
                else if (c == '/') {
                    stack.push(lt / rt);
                }
            }
        }

        return stack.get(0);
    }

    public static void main(String[] args) {

        Main_2nd T = new Main_2nd();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        System.out.println(T.solution(str));
    }
}
