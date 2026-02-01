import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        long[] deptSum = new long[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken()); // 직원 수

            long sum = 0;
            for (int j = 0; j < cnt; j++) {
                sum += Long.parseLong(st.nextToken());   // 직원별 면담 시간
            }
            deptSum[i] = sum; // 부서 총 면담 시간
        }

        Arrays.sort(deptSum); // 부서 총시간 오름차순

        long prefix = 0;
        long ans = 0;
        for (int i = 0; i < N; i++) {
            prefix += deptSum[i]; // 누적합 = i번째 부서 퇴근시각
            ans += prefix;        // 퇴근시각 합
        }

        System.out.println(ans);
    }
}
