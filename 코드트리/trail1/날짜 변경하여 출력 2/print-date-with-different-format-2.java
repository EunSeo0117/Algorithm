import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String[] t = a.split("-");

        System.out.println(t[2]+"."+t[0]+"."+ t[1]);
    }
}