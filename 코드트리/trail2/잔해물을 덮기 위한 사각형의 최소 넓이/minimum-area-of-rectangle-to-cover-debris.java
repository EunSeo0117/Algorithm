import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int[][] arr = new int[2001][2001];

        Scanner sc = new Scanner(System.in);
        int rect1_x1 = sc.nextInt()+1000;
        int rect1_y1 = sc.nextInt()+1000;

        int rect1_x2 = sc.nextInt()+1000;
        int rect1_y2 = sc.nextInt()+1000;

        int rect2_x1 = sc.nextInt()+1000;
        int rect2_y1 = sc.nextInt()+1000;
        int rect2_x2 = sc.nextInt()+1000;
        int rect2_y2 = sc.nextInt()+1000;
        

        for (int i=rect1_y1; i<rect1_y2; i++) {
            for (int j=rect1_x1; j<rect1_x2; j++) {
                arr[i][j]=1;
            }
        }

        for (int i=rect2_y1; i<rect2_y2; i++) {
            for (int j=rect2_x1; j<rect2_x2; j++) {
                arr[i][j]=0;
            }
        }

        int minx=2001,maxx=-1;
        int miny=2001,maxy=-1;
        for (int i=0; i<2000;i++) {
            for (int j=0; j<2000; j++) {
                if (arr[i][j]==1 && i>maxy) maxy=i;
                if (arr[i][j]==1 && i<miny) miny=i;
                if (arr[i][j]==1 && j>maxx) maxx=j;
                if (arr[i][j]==1 && j<minx) minx=j;
            }
        }

        if (maxx == -1) {
            System.out.println(0);
            return;
        }


        int ans = (maxx-minx+1) * (maxy-miny+1);


        System.out.println(ans);

    }
}