import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        String[] arr = {"apple", "banana", "grape", "blueberry", "orange"};
        String a = sc.next();
        int cnt =0;
        for (int i=0 ;i<5; i++) {
            String tmp1 = arr[i].substring(2,3);
            String tmp2 = arr[i].substring(3,4);
            if (tmp1.equals(a) || tmp2.equals(a)) {
                cnt+=1;
                System.out.println(arr[i]);
            }
        }

        System.out.print(cnt);
        
    }
}