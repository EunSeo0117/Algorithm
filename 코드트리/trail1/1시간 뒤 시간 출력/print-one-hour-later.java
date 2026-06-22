import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        String a = sc.next();
        String[] strarr = a.split(":");
        int b = Integer.parseInt(strarr[0]);
        b+=1;
        System.out.println(b + ":" + strarr[1]);
    }
}