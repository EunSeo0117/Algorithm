import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] a = new int[D + 1];
        int[] b = new int[D + 1];

        
        a[1] = 1; b[1] = 0;
        a[2] = 0; b[2] = 1;

        
        for (int i = 3; i <= D; i++) {
            a[i] = a[i - 1] + a[i - 2];
            b[i] = b[i - 1] + b[i - 2];
        }

        
        for (int A = 1; A <= K; A++) {
            int remain = K - a[D] * A;
            if (remain <= 0) continue;
            if (remain % b[D] == 0) {
                int B = remain / b[D];
                if (A <= B) {
                    System.out.println(A);
                    System.out.println(B);
                    break;
                }
            }
        }
    }
}
