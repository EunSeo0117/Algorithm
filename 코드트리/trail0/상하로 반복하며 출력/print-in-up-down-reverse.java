import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        for (int i=0; i<n;i++) {
            for (int j=0; j<n; j++) {
                arr[i][j] = j+1;
            }
        }

        for (int i=0; i<n;i++) {
         
            for (int j=0; j<n; j++) {
                if (j%2==0) {
                    System.out.print(arr[j][i]);
                } else {
                    System.out.print(arr[j][n-i-1]);
                }
            }

        
            
            
        
            System.out.println();
        }
    }
}