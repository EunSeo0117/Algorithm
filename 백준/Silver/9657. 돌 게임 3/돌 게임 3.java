import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        boolean[] win = new boolean[N + 1];
        win[0] = false;

        for (int i = 1; i <= N; i++) {
            boolean canWin = false;

            if (i - 1 >= 0 && !win[i - 1]) canWin = true;
            if (i - 3 >= 0 && !win[i - 3]) canWin = true;
            if (i - 4 >= 0 && !win[i - 4]) canWin = true;

            win[i] = canWin;
        }

        System.out.println(win[N] ? "SK" : "CY");
    }
}
