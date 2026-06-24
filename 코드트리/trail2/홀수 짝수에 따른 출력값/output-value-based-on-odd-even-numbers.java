import java.util.*;

public class Main {
    public static int add(int n) {
        int total = 0;
        if (n%2==0) {
            for (int i=2; i<=n;i++) {
                if (i%2==0) total+=i;
            }
        } else {
            for (int i=1; i<=n; i++) {
                if (i%2!=0) total+=i;
            }
        }

        return total;
    }
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(add(n));
    }
}