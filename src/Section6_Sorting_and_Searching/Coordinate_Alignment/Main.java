package Section6_Sorting_and_Searching.Coordinate_Alignment;

import java.util.Scanner;
import java.util.Arrays;

class Coordinate implements Comparable<Coordinate> {

    int x, y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Coordinate ob) {

        if (this.x == ob.x) {
            return this.y - ob.y;
        }
        else {
            return this.x - ob.x;
        }
    }
}

public class Main {

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Coordinate[] arr = new Coordinate[n];

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr[i] = new Coordinate(x, y);
        }

        Arrays.sort(arr);

        for (Coordinate co : arr) {
            System.out.println(co.x + " " + co.y);
        }
    }
}
