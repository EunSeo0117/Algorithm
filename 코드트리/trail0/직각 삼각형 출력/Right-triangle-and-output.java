import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i=0; i<n; i++) {

            for (int k=0; k<2*i+1; k++) {
                System.out.print("*"); 
            } 
        
            System.out.println();
        }
    

    }
}