import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr =new int[201][201];

        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt()+100;
            int y1 = sc.nextInt()+100;

            int x2 = sc.nextInt()+100;
            int y2 = sc.nextInt()+100;

            int flag = 0;
            if (i==0 || i%2==0) flag = 1;
            else flag=2;

            for (int k=y1; k<y2; k++) {
                for (int j=x1; j<x2; j++) {
                    arr[k][j] = flag;
                }
            }
        }

        int cnt=0;
        for (int i=0; i<200;i++) {
            for (int j=0; j<200;j++) {
                if (arr[i][j]==2) cnt++;
            }
        }

        System.out.println(cnt);
    }
}