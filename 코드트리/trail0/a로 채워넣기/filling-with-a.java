import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        String a = sc.next();

        String tmp = a.substring(0,1) + "a" + a.substring(2, a.length()-2) + "a" + a.substring(a.length()-1);

        System.out.println(tmp);
    }
}