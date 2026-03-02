import java.awt.image.ImageProducer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s1 = sc.next();
            String s2 = sc.next();

            int wtb = 0;
            int btw = 0;

            for (int i =0; i< n; i++) {
                char init = s1.charAt(i);
                char target = s2.charAt(i);
                if (init != target) {
                    if (init == 'W' && target == 'B') {
                        wtb++;
                    } else if (init == 'B' && target == 'W') {
                        btw++;
                    }
                }
            }
            int minOper = Math.max(wtb, btw);
            System.out.println(minOper);


        }


    }

}
