import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        
        if (a >=1.0) System.out.println("High");
        else if (a >=0.5) System.out.println("Middle");
        else System.out.println("Low");


    }
}