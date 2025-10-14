import java.util.*;
import java.io.*;

public class Main {

    static List<Integer> num = new ArrayList<>();

    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();



        int t = Integer.parseInt(br.readLine());
        int max = 0;
        int[] n = new int[t];
        for (int i=0; i<t; i++) {
            n[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, n[i]);
        }

        int[][] dp = new int[max+1][4];

        for (int i=1; i<=3; i++) {
            dp[0][i] = 1;
        }

        for (int i=1; i<=max; i++) {
            for (int j=1; j<=3; j++) {
                dp[i][j] = dp[i][j-1];
                if (i-j >=0) dp[i][j] += dp[i-j][j];
            }
        }

        for (int x : n) {
            sb.append(dp[x][3]).append("\n");
        }

        System.out.print(sb);


    }

}
