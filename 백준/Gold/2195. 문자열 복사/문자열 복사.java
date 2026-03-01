import java.awt.image.ImageProducer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc =  new Scanner(System.in);

        String S = sc.nextLine();
        String P = sc.nextLine();

        int count =0;
        int i = 0;

        while (i<P.length()) {
            int len = 1;
            while (i+len <= P.length() && S.contains(P.substring(i, i+len))) {
                len++;
            }
            i += len-1;
            count++;
        }
        System.out.println(count);

    }

}
