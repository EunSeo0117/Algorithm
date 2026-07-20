import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        int[] dg = new int[20];
        int cnt = 0;
        while (true) {
            if (a < 2) {
                dg[cnt++] = a;
                break;
            }

            dg[cnt++] = a % 2;
            a /= 2;
        }

        for (int i = cnt-1; i>=0; i--) {
            System.out.print(dg[i]);
        }
    }
}