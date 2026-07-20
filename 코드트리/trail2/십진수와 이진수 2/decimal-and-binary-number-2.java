import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String strN = n+"";

        int num = 0;
        for (int i=0; i<strN.length(); i++) {
            int tmp = strN.charAt(i) - '0';
            num = num * 2 + tmp;
        }

        num = num * 17;

        int[] dg = new int[100];
        int cnt = 0;

        while (true) {
            if (num < 2) {
                dg[cnt++] = num;
                break;
            }

            dg[cnt++] = num%2;
            num/=2;
        }

        for (int i = cnt-1; i>=0; i--) {
            System.out.print(dg[i]);
        }
        
    }
}