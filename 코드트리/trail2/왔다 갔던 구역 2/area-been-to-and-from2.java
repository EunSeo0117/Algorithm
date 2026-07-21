import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] arr = new long[2001];

        int idx = 1000;
        for (int i=0; i<n;i++) {
            int t = sc.nextInt();
            char m = sc.next().charAt(0);

            for (int j=0; j<t; j++) {
                if (m == 'R') {
                    arr[idx]++;
                    idx++;
                } else if (m=='L') {
                    idx--;
                    arr[idx]++;
                }
            }
        }


        int cnt = 0;
        for (int i=0; i<=2000; i++) {
            if (arr[i]>=2) {
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}