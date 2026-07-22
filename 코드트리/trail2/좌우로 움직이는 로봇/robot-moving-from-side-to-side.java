import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        

        int[] a = new int[2000001];
        int timer = 1;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            char d = sc.next().charAt(0);

            for (int k=0; k<t; k++) {
                if (d=='L') {
                    idx--;
                } else if (d=='R') {
                    idx++;
                }
                a[timer++] = idx;
            }
        }
        
        int aTime = timer - 1;

        int[] b = new int[2000001];
        timer = 1;
        idx = 0;
        for (int i = 0; i < m; i++) {
            int t = sc.nextInt();
            char d = sc.next().charAt(0);

            for (int k=0; k<t; k++) {
                if (d=='L') {
                    idx--;
                } else if (d=='R') {
                    idx++;
                }
                b[timer++] = idx;
            }
        }
    
        int bTime = timer - 1;

    
        int maxTime = Math.max(aTime, bTime);

        for (int i = aTime + 1; i <= maxTime; i++)
            a[i] = a[aTime];

        for (int i = bTime + 1; i <= maxTime; i++)
            b[i] = b[bTime];

        
        int ans = 0;
        for (int i=1; i<=maxTime;i++) {
            //System.out.println("현재위치는" + a[i]+":"+b[i]+"입니다");
            //System.out.println("이전위치는" + a[i-1]+":"+b[i-1]+"입니다");
            if (a[i]==b[i] && a[i-1] != b[i-1]) {
                ans++;
            }

        }

        System.out.println(ans);

        
        
    }
}