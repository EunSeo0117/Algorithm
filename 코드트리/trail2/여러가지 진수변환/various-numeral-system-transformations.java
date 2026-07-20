import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();

        int[] dg = new int[20];
        int cnt =0;
        while (true) {
            if (n<b) {
                dg[cnt++] = n;
                break;
            }

            dg[cnt++] = n%b;
            n/=b;
        }

        for (int i = cnt-1; i>=0; i--) {
            System.out.print(dg[i]);
        }
    }
}