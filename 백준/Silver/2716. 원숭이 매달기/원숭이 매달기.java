import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        for (int j=0; j<n; j++) {
            int depth = 0;
            int max = 0;

            String line = br.readLine();
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (c =='[') {
                    depth+=1;
                    max = Math.max(max, depth);
                } else if (c==']') {
                    depth-=1;

                }
            }
            // depth마다 2배씩 증가하므로 제곱2
            System.out.println((int)Math.pow(2, max));
        }



    }
}