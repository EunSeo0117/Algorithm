import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.

        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        String week = sc.next();

        int[] month = {0,31,29,31,30,31,30,31,31,30,31,30,31};
        
        int first = 0;
        for (int i=1; i<m1; i++) {
            first+=month[i];
        }
        first += d1;

        int second = 0;
        for (int i=1; i<m2; i++) {
            second += month[i];
        }
        second += d2;

        int total = second - first;
        int tmp = total / 7;
        int tmp2 = total % 7;

        int answer =tmp;

        int idx = 0;
        String[] weeks = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        for (int i=0; i<weeks.length; i++) {
            if (week.equals(weeks[i])) {
                idx = i;
                break;
            }
        }
        if (idx <= tmp2) answer+=1;

        
        System.out.println(answer);

    }
}