package BOJ.BOJ5052;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEnd = false;
}

public class Main {

    public boolean insert(TrieNode root, String number) {

        TrieNode current = root;
        for (Character ch : number.toCharArray()) {
            if (!current.children.containsKey(ch)) {
                current.children.put(ch, new TrieNode());
            }
            current = current.children.get(ch);
            if (current.isEnd) {
                return false;
            }
        }
        if (!current.children.isEmpty()) {
            return false;
        }
        current.isEnd = true;
        return true;
    }

    public String solution(int n, String[] numbers) {

        Arrays.sort(numbers);
        TrieNode root = new TrieNode();
        for (String number : numbers) {
            if (!insert(root, number)) {
                return "NO";
            }
        }
        return "YES";
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            String[] numbers = new String[n];
            for (int j = 0; j < n; j++) {
                numbers[j] = sc.next();
            }
            System.out.println(T.solution(n, numbers));
        }
    }
}
