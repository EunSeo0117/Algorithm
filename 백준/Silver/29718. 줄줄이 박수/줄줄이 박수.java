import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int A = Integer.parseInt(br.readLine());

        int[] Msum = new int[M];

        for (int i = 0; i < M; i++) {      
            for (int j = 0; j < N; j++) {  
                Msum[i] += arr[j][i];
            }
        }

        long w = 0;
        for (int i = 0; i < A; i++) {
            w += Msum[i];
        }

        long max = w;

        for (int i = A; i < M; i++) {
            w = w - Msum[i-A] + Msum[i];
            max = Math.max(max, w);
        }

        System.out.println(max);

    }

}
