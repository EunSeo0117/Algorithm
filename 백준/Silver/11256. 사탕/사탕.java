import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {



    public static void main(String[] args) throws IOException {

        Scanner sc =  new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int j = sc.nextInt();
            int n = sc.nextInt();
            int[] box = new int[n];
            for (int i = 0; i < n; i++) {
                int r = sc.nextInt();
                int c = sc.nextInt();
                box[i] = r * c;
            }
            Arrays.sort(box);
            int count = 0;
            for (int i = n-1; i >=0; i--) {
                j -= box[i];
                count +=1;
                if (j <= 0) {
                    System.out.println(count);
                    break;
                }
            }
        }

    }

}
