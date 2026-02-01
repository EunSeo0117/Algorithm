import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int maxSum = 0;
        int minSum = 0;

        int curMax = 0;
        int curMin = 0;

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());

            // 왼쪽 = +1, 오른쪽 = -1
            int v = (x == 1) ? 1 : -1;

            // 최대 연속합
            curMax = Math.max(v, curMax + v);
            maxSum = Math.max(maxSum, curMax);

            // 최소 연속합
            curMin = Math.min(v, curMin + v);
            minSum = Math.min(minSum, curMin);
        }

        System.out.println(Math.max(maxSum, Math.abs(minSum)));
    }
}
