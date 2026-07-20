import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int a,b,c,d;
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();

        int first;
        first = a*60;
        first += b;

        int second;
        second = c*60;
        second += d;

        System.out.println(second - first);
    }
}