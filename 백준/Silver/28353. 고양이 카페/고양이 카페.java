import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.dgc.VMID;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] w =new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            w[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(w);

        int left = 0;
        int right = N-1;
        int happy = 0;

        while (left < right) {
            if (w[left] + w[right] <=K) {
                happy++;
                left++;
                right--;
            } else {
                right--;
            }
        }
        System.out.println(happy);
    }
}