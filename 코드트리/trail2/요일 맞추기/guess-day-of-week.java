import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();

        int[] month = {0, 31,28,31,30,31,30,31,31,30,31,30,31};
        
        int first = 0;
        for (int i=1; i<m1; i++) {
            first+=month[i];
        }
        first +=d1;

        int second = 0;
        for (int i=1; i<m2; i++) {
            second+=month[i];
        }
        second +=d2;


        int total = second - first;

        String[] week = { "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        total = total % 7;
        if (total < 0) total = 7 +total;
        System.out.println(week[total]);

    }
}