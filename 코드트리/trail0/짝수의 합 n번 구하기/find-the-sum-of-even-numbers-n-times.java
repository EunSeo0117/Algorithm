import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i=0; i<n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int total = 0;
            for (int j=a; j<=b;j++) {
                if (j%2==0) total +=j;
            } 
            System.out.println(total);
        }
    }
}