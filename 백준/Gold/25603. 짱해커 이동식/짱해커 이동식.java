import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[] arr;

    static boolean c(int max) {
        int cnt = 0;
        for (int i=0; i<N; i++) {
            if (arr[i] > max) {
                cnt++;
                if (cnt == K) return false;
            } else {
                cnt = 0;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];

        int min = Integer.MAX_VALUE;
        int max = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        int l = min;
        int r = max;
        int answer = max;

        while (l<=r) {
            int mid = (l+r)/2;

            if (c(mid)) {
                answer = mid;
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        System.out.println(answer);
    }

}
