import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[101];

        for (int i=0; i<n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            for (int j=a; j<=b; j++) {
                arr[j]++;
            }
            
        }

        int max = 0;
        for (int i=0; i<101; i++) {
            if (arr[i]>max) max = arr[i];
        }

        System.out.println(max);
    }
}