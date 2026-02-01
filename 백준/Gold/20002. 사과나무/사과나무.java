import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N + 1][N + 1];
        int[][] ps = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2차원 누적합
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                ps[i][j] =
                        ps[i - 1][j]
                      + ps[i][j - 1]
                      - ps[i - 1][j - 1]
                      + arr[i][j];
            }
        }

        int answer = Integer.MIN_VALUE;

        // K = 정사각형 크기
        for (int k = 1; k <= N; k++) {
            for (int i = k; i <= N; i++) {
                for (int j = k; j <= N; j++) {

                    int sum =
                            ps[i][j]
                          - ps[i - k][j]
                          - ps[i][j - k]
                          + ps[i - k][j - k];

                    answer = Math.max(answer, sum);
                }
            }
        }

        System.out.println(answer);
    }
}
