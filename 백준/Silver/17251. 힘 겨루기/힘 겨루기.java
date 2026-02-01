import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] leftMax = new int[N];
        int[] rightMax = new int[N];

        // 왼쪽 최대
        leftMax[0] = arr[0];
        for (int i = 1; i < N; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }

        // 오른쪽 최대
        rightMax[N - 1] = arr[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
        }

        int red = 0;
        int blue = 0;

        // 기준선 k: k | k+1
        for (int k = 0; k < N - 1; k++) {
            int r = leftMax[k];
            int b = rightMax[k + 1];

            if (r > b) red++;
            else if (r < b) blue++;
        }

        if (red > blue) System.out.println("R");
        else if (red < blue) System.out.println("B");
        else System.out.println("X");
    }
}
