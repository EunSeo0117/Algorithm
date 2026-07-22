import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] a = new int[1000001];
        int[] b = new int[1000001];

        int idx = 0;
        int timer = 1;
        for (int i=0; i<n; i++) {
            char d = sc.next().charAt(0);
            int t = sc.nextInt();

            for (int k=0; k<t; k++) {
                if (d=='L') {
                    idx--;
                    a[timer]=idx;
                } else if (d=='R') {
                    idx++;
                    a[timer]=idx;
                }
                //System.out.println("인덱스: " +idx);
                //System.out.println("timer: " +timer);
            
                timer++;
            }
        }

        idx=0;
        timer=1;
        for (int i=0; i<m; i++) {
            char d = sc.next().charAt(0);
            int t = sc.nextInt();

            for (int k=0; k<t; k++) {
                if (d=='L') {
                    idx--;
                    b[timer]=idx;
                } else if (d=='R') {
                    idx++;
                    b[timer]=idx;
                
                }

                //System.out.println("인덱스: " +idx);
                //System.out.println("timer: " +timer);
                timer++;

            }
        }
        
        int ans = -1;
        for (int i=1; i<timer; i++) {
            //System.out.println(a[i] + ":" +b[i]);
            if (a[i]==b[i]) {
                ans = i;
                break;
            }
        }

        System.out.println(ans);

        



        
    }
}