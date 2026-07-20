import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[200];

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt() + 100;
            int b = sc.nextInt() + 100;

            for (int j=a; j<b; j++) {
                arr[j]++;
            }

        }

        int max=0;
        for (int i=0; i<200; i++) {
            if (arr[i]>max) max = arr[i];
        }
        
        System.out.println(max);
    }
}