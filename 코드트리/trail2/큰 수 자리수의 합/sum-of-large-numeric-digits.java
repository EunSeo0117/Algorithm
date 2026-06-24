import java.util.Scanner;
public class Main {
    public static int add(int n) {
        if (n/10==0) return n%10;

        return add(n/10) + n%10;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        // Please write your code here.

        int n = a*b*c;
        System.out.println(add(n));

    }
}