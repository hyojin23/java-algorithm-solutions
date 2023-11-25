package Section6_Sorting_and_Searching.Coordinate_Alignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Point_1st implements Comparable<Point_1st> {
    public int x, y;
    Point_1st(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Point_1st o) {
        if (this.x == o.x) {
            return this.y - o.y;
        } else {
            return this.x - o.x;
        }
    }
}

public class Main_1st {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Point_1st> arr = new ArrayList<>();
        for (int i=0; i<n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr.add(new Point_1st(x, y));
        }
        Collections.sort(arr);
        for (Point_1st o: arr) {
            System.out.println(o.x + " " + o.y);
        }
    }
}
