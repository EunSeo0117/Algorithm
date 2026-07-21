import java.util.Scanner;
public class Main {
    public static final int MAX_N = 100000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[2*MAX_N+1];
        int[] arrw = new int[2*MAX_N+1];
        int[] arrb = new int[2*MAX_N+1];
        
        int idx = MAX_N;
        int w=0,b=0;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            char d = sc.next().charAt(0);
            
            if (d=='L') {
                while (x-- > 0) {
                    arr[idx]=1;
                    if(x>0) idx--;
                }
            } else {
                while (x-- > 0) {
                    arr[idx]=2;
                    if(x>0) idx++;
                }
            }

        }

        for (int i=0; i<2*MAX_N+1; i++) {
            if (arr[i]==1) w++;
            else if (arr[i]==2) b++;
        }

        System.out.printf("%d %d", w, b);
    }
}