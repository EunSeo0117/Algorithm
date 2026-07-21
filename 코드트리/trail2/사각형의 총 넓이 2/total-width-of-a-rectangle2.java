import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
        int[][] map = new int[201][201];
        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            x1+=100;
            x2+=100;
            y1+=100;
            y2+=100;

            for (int k=y1; k<y2;k++) {
                for (int j=x1; j<x2;j++) {
                    map[k][j]=1;
                }
            }
        }

        int cnt=0;
        for (int i=0; i<200;i++) {
            for (int j=0; j<200;j++) {
                if (map[i][j]==1) cnt++;
            }
        }

        System.out.print(cnt);
    }
}