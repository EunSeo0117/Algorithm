import java.util.Scanner;
public class Main {

    public static int cnt=0;

    public static int fact(int n) {
        if (n==1) return n;

        if (n%2==0) {
            cnt++;
            return fact(n/2);
        } else {
            cnt++;
            return fact(n/3);
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        fact(n);
        System.out.println(cnt);
    }
}