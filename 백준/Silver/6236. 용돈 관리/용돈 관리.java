import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] money;

    // K로 가능한지 판별
    static boolean possible(int K) {
        int count = 0;
        int remain = 0;

        for (int day : money) {
            if (remain < day) {
                count++;
                remain = K;
            }
            remain -= day;
        }
        return count <= M;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        money = new int[N];

        int max = 0;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, money[i]);
            sum += money[i];
        }

        int lo = max;
        int hi = sum;
        int answer = sum;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (possible(mid)) {
                answer = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
