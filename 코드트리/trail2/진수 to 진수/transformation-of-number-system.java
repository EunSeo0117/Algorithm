import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int n = sc.nextInt();

        // 8 to 10
        int num = 0;
        String strN = n+"";
        for (int i=0; i<strN.length(); i++) {
            int tmp = strN.charAt(i) - '0';
            num = num * a + tmp;
        }


        int[] dg = new int[100];
        int cnt = 0;
        while (true) {
            if (num < b) {
                dg[cnt++] = num;
                break;
            }

            dg[cnt++] = num%b;
            num/=b;
        }

        for (int i = cnt-1; i>=0; i--) {
            System.out.print(dg[i]);
        }

        
    }
}