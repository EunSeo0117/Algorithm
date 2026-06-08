import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.

        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();

        if (y%4!=0 || (y%100==0 && y%400!=0)) System.out.println("false");
        else System.out.println("true");
    }
}