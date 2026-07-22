import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,1,-1};

        int x=0,y=0;
        for (int i = 0; i < n; i++) {
            char direction = sc.next().charAt(0);
            int distance = sc.nextInt();

            if (direction=='W') {
                x-=distance;
            } else if (direction=='S') {
                y-=distance;
            } else if (direction=='N') {
                y+=distance;
            } else {
                x+=distance;
            }
        }

        System.out.printf("%d %d", x,y);
    }
}