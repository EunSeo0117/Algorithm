import java.util.*;

public class Main {
    public static int prod(int n) {
        if (n/10 ==0) return (n%10)*(n%10);
        return prod(n/10) + (n%10)*(n%10);
    }
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(prod(n));

        
    }
}