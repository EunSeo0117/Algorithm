import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int MAX_NUM = 100000;
        int[] arr = new int[2*MAX_NUM+1];
        int[] cntb = new int[2*MAX_NUM+1];
        int[] cntw = new int[2*MAX_NUM+1];
        int w=0,b=0,g=0;
        int idx = MAX_NUM;
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            char d = sc.next().charAt(0);

            if (d=='L') {
                while(x-- > 0) {
                    arr[idx] =1;
                    cntw[idx]++;
                    if(x>0) idx--;
                }
            } else {
                while (x-- > 0) {
                    arr[idx] = 2;
                    cntb[idx]++;
                    if (x>0) idx++;
                }
            }
        }

        for(int i=0; i<=2*MAX_NUM; i++) {
            if (cntb[i]>=2 && cntw[i] >= 2) g++;
            else if (arr[i]==1) w++;
            else if (arr[i]==2) b++;
        }
        
        System.out.printf("%d %d %d", w,b,g);
    }
}