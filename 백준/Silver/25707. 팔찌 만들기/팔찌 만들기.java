import java.awt.image.ImageProducer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] ball = new int[n];
        for (int i = 0; i < n; i++) {
            ball[i] = sc.nextInt();
        }

        Arrays.sort(ball);
        int ans = 0;
        for (int i = 0; i < n-1; i++) {
            ans += Math.abs(ball[i] - ball[i+1]);
        }
        ans += Math.abs(ball[0] - ball[n-1]);

        System.out.println(ans);


    }

}
