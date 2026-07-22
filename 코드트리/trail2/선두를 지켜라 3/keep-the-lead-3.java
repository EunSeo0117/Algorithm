import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int timer = 1;

        int idx = 0;
        int[] a = new int[10000001];
        for (int i = 0; i < n; i++) {
            int u = sc.nextInt();
            int t = sc.nextInt();

            for (int k=0;k<t;k++) {
                idx+=u;
                a[timer] = idx;
                timer++;
            }
        }
        
        timer = 1;
        idx = 0;
        int[] b = new int[1000001];
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int t = sc.nextInt();

            for (int k=0;k<t;k++) {
                idx+=u;
                b[timer] = idx;
                timer++;
            }
        }

        int first = 0;
        int cgcnt = 0;
        for (int i=0; i<timer; i++) {
            if (first!=1 && a[i]>b[i]) {
                first = 1;
                cgcnt++;

            } else if (first!=2 && a[i]<b[i]) {
                first =2;
                cgcnt++;
            } else if (first!=3 && a[i]==b[i]) {
                first = 3;
                cgcnt++;
            }
        }

        System.out.println(cgcnt-1);
    }
}