import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] T = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            T[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int count = 0;
        int answer = Integer.MAX_VALUE;

        for (int right = 0; right < N; right++) {

            if (T[right] == 1) {
                count++;
            }

            // 라이언이 K개 이상이면 왼쪽 줄이기
            while (count >= K) {
                answer = Math.min(answer, right - left + 1);

                if (T[left] == 1) {
                    count--;
                }
                left++;
            }
        }

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }
}
