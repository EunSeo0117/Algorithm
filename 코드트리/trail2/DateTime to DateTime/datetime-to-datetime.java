import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int a,b,c;
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        int first = 0;
        first = 11*24*60;
        first += 11*60;
        first += 11;

        int second = 0;
        second = a*24*60;
        second += b*60;
        second += c;

        if (second-first<0) {
            System.out.println(-1);
        } else {
            System.out.println(second-first);
        }

    }
}