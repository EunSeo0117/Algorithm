import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[201][201];

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt()+100;
            int y = sc.nextInt()+100;

            for (int k=y; k<y+8; k++) {
                for (int j=x; j<x+8;j++) {
                    arr[k][j]=1;
                }
            }
        }

        int cnt=0;
        for (int i=0; i<200;i++) {
            for (int j=0;j<200;j++) {
                if (arr[i][j]==1) cnt++;
            }
        }
        System.out.println(cnt);        
    }
}