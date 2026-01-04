import java.io.*;
import java.util.*;

public class Main {

    static int N, C;
    static int[] house;

    // 거리 dist로 C개 설치 가능한지 판별
    static boolean canInstall(int dist) {
        int count = 1;               // 첫 집에 설치
        int last = house[0];

        for (int i = 1; i < N; i++) {
            if (house[i] - last >= dist) {
                count++;
                last = house[i];
            }
        }
        return count >= C;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        house = new int[N];
        for (int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        int lo = 1;
        int hi = house[N - 1] - house[0];
        int answer = 0;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (canInstall(mid)) {
                answer = mid;     // 가능한 거리 저장
                lo = mid + 1;     // 더 크게 시도
            } else {
                hi = mid - 1;     // 줄여야 함
            }
        }

        System.out.println(answer);
    }
}
