import java.io.*;
import java.util.*;

public class Main {

    static int N, M, L;
    static int[] rest;

    // 최대 구간 길이를 D 이하로 만들 수 있는지 판별
    static boolean possible(int D) {
        int need = 0;

        for (int i = 1; i < rest.length; i++) {
            int gap = rest[i] - rest[i - 1];
            need += (gap - 1) / D;
        }

        return need <= M;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        rest = new int[N + 2];
        rest[0] = 0;
        rest[N + 1] = L;

        if (N > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                rest[i] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(rest);

        int lo = 1;
        int hi = L;
        int answer = L;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (possible(mid)) {
                answer = mid;
                hi = mid - 1;   // 더 줄여본다
            } else {
                lo = mid + 1;   // 늘려야 한다
            }
        }

        System.out.println(answer);
    }
}
