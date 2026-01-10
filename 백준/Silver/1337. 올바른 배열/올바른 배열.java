import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.dgc.VMID;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] money;

    static boolean can(int K) {
        int count = 0;
        int remain = 0;

        for (int day: money) {
            if (day > K) return false;

            if (remain < day) {
                count++;
                remain = K;
            }
            remain -= day;

        }
        return count <= M;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(a);
        
        int[] newA = new int[N];
        int m = 0;
        for (int i = 0; i < N; i++) {
            if (i==0 || a[i] != a[i-1]) {
                newA[m++] = a[i];
            }
        }
        
        int best = 0;
        int left = 0;
        
        for (int right = 0; right < m; right++) {
            while (newA[right] - newA[left] > 4) {
                left++;
            }
            best = Math.max(best, right - left + 1);
        }

        System.out.println(5-best);

    }
}