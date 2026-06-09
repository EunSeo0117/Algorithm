import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        int cnt=0;
        for (int i=1; i<=100; i++) {
            cnt+=i;
            if (cnt>=a) {
                System.out.print(i); 
                break;
            }
        }
    }
}