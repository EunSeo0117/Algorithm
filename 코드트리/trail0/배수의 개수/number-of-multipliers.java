import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[10];
        for (int i=0; i<10; i++) {
            arr[i] = sc.nextInt();
        }

        int cnt3=0;
        int cnt5=0;
        for (int i=0; i<10; i++) {
            if (arr[i]%3==0) cnt3+=1;
            if (arr[i]%5==0) cnt5+=1;
        }
        System.out.println(cnt3 + " " + cnt5);
    }
}