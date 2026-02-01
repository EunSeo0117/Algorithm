import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] a = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int answer = 0;

        for (int i = 0; i < N; i++) {

            sum += a[i];

            if (i >= L) {
                sum -= a[i - L];
            }

            if (129 <= sum && sum <= 138) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
