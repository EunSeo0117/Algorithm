import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[][] A = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= M-W; i++) {
            for (int j = 0; j <= N-W; j++) {
                ArrayList<Integer> l = new ArrayList<>();
                for (int x = 0; x < W; x++) {
                    for (int y = 0; y < W; y++) {
                        l.add(A[i+x][j+y]);
                    }
                }
                Collections.sort(l);
                int m = l.get(l.size()/2);
                sb.append(m);
                if (j < N-W) sb.append(" ");
            }
            sb.append("\n");

        }
        
        System.out.println(sb.toString());
    }

}
