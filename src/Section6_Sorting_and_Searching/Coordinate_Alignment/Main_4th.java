package Section6_Sorting_and_Searching.Coordinate_Alignment;

import java.util.Scanner;
import java.util.Arrays;

class Coordinate_4th implements Comparable<Coordinate_4th> {

    int x, y;

    Coordinate_4th(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Coordinate_4th ob) {

        if (this.x == ob.x) {
            return this.y - ob.y;
        }
        else {
            return this.x - ob.x;
        }
    }
}

public class Main_4th {

    public static void main(String[] args) {

        Main_4th T = new Main_4th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Coordinate_4th[] arr = new Coordinate_4th[n];

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr[i] = new Coordinate_4th(x, y);
        }

        Arrays.sort(arr);

        for (Coordinate_4th co : arr) {
            System.out.println(co.x + " " + co.y);
        }
    }
}
