import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int a= sc.nextInt();
        int b= sc.nextInt();

        int total = 0;
        for (int i=a; i<=b; i++) {
            if (i%2==0) total+=i;
        }

        System.out.println(total);

    }
}