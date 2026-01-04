import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.dgc.VMID;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] line = new int[K];
        int max = 0;
        
        for (int i = 0; i < K; i++) {
            line[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, line[i]);
        }
        
        long s =1;
        long e = max;
        
        while (s <= e) {
            long mid = (s + e) / 2;
            long count = 0;
            
            for (int len: line) {
                count += (len / mid);
            }
            
            if (count >= N) {
                s = mid + 1;
            } else {
                e = mid -1;
            }
        }

        System.out.println(e);

    }
}