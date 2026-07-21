import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int cnt = 1;
        int max = 1;
        for (int i=1; i<n;i++) {
            if (arr[i-1] < arr[i]) cnt++;
            else {
                if (max < cnt) max=cnt;
                cnt=1;
            }
        }
        max = Math.max(max, cnt);
        System.out.println(max);
    }
}