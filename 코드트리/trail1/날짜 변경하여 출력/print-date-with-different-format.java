import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String[] t = a.split("\\.");

        System.out.printf("%s-%s-%s", t[1], t[2], t[0]);

    }
}