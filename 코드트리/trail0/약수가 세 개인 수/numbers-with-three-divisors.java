import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        int e = sc.nextInt();

        int totalcnt=0;
        for (int i=s; i<=e; i++) {
            int cnt=0;
            for (int j=1; j<=i; j++) {
                if (i%j==0) cnt+=1;
            }

            if (cnt==3)totalcnt+=1;
        }

        System.out.println(totalcnt);
    }
}