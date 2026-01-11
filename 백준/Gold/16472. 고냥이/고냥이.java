import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.dgc.VMID;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int[] count = new int[26];
        int left = 0;
        int kind = 0;
        int answer = 0;
        for (int right = 0; right < s.length(); right++) {
            int r = s.charAt(right) - 'a';
            if (count[r] == 0) kind++;
            count[r]++;

            while (kind > N) {
                int l = s.charAt(left) - 'a';
                count[l]--;
                if (count[l] == 0) kind--;
                left++;
            }

            answer = Math.max(answer, right - left + 1);
        }
        System.out.println(answer);

    }
}