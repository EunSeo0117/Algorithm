import java.awt.image.ImageProducer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        StringBuilder result = new StringBuilder();
        int c = 0;

        while (c<n.length()) {
            if (n.charAt(c)=='.') {
                result.append('.');
                c++;
                continue;
            }
            
            int j=c;
            while (j< n.length() && n.charAt(j)=='X') {
                j++;
            }
            int len =  j-c;
            if (len%2==1) {
                System.out.println(-1);
                return;
            }
            
            while (len >= 4) {
                result.append("AAAA");
                len -= 4;
            }
            
            while (len >= 2) {
                result.append("BB");
                len -= 2;
            }
            
            c = j;
            
        }
        System.out.println(result.toString());

    }

}
