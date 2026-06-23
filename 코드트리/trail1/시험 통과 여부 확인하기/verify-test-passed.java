import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if (a >= 80) System.out.println("pass");
        else System.out.printf("%d more score", 80-a);
    }
}