import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int cnt = 0;
        for (int i=0; i<4; i++) {
            for (int j=0; j<4; j++) {
                int tmp = sc.nextInt();
                if (tmp%5==0) cnt+=1;
            }
        }

        System.out.println(cnt);
    }
}