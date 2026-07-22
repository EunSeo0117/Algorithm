import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] A = new int[n][2];

        int[] a = new int[1000001];
        int timer = 1;
        int a_dis = 0;
        for (int i = 0; i < n; i++) {
            int u = sc.nextInt();
            int t = sc.nextInt();

            for (int k=0; k<t; k++) {
                a_dis += u; // 누적거리값
                a[timer] = a_dis; // 1초씩 갈때마다 거리
                timer++; // 타이머
            }

        }

        int[] b = new int[1000001];
        int timer2 = 1;
        int b_dis = 0;
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int t = sc.nextInt();

            for (int k=0; k<t; k++) {
                b_dis += u; // 누적거리값
                b[timer2] = b_dis; // 1초씩 갈때마다 거리
                timer2++; // 타이머
            }
        }

        int whofist = 0; //1a 2b
        int cgcnt = 0;
        for (int i=1; i<timer2; i++) {
            if (whofist!=1 && a[i]>b[i]) {
                //System.out.println(a[i]+","+b[i]+"이므로 a선두");
                whofist = 1;
                cgcnt++;
            } else if (whofist!=2 && a[i]<b[i]) {
                //System.out.println(a[i]+","+b[i]+"이므로b선두");
                whofist = 2;
                cgcnt++;
            }  
        }
        System.out.println(cgcnt-1);
    }
}