import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        while (T-- > 0) {
            st = new  StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            if (M==N) {
                long total = 0;
                for (int x : arr) total +=x;
                System.out.println(total < K ? 1 : 0);
                continue;
            }
            
            long sum = 0;
            
            for (int i = 0; i < M; i++) {
                sum += arr[i];
            }
            
            int cnt = 0;
            
            for (int i = 0; i < N; i++) {
                if (sum < K) cnt++;
                sum = sum - arr[i] + arr[(i+M) % N];
            }
            System.out.println(cnt);
        }
    }

}
