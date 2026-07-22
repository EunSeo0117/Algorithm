import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 개발자들
        int K = sc.nextInt(); // 악수횟수(전염병) (한사람당 전염 가능횟수)
        int P = sc.nextInt(); // 전염병개발자
        int T = sc.nextInt(); // t번에 걸쳐
        int[][] shakes = new int[251][2];

        for (int i = 0; i < T; i++) {
            int t = sc.nextInt(); // t초 악수
            shakes[t][0] = sc.nextInt(); // x개발자
            shakes[t][1] = sc.nextInt(); // y개발자
        }

        int[] virus = new int[N+1]; // 감염자 멤버
        virus[P] = 1;

        int[] can = new int[N+1]; // 감염 가능횟수
        for (int i=1;i<=N;i++) {
            can[i]=K;
        }

        int cnt = 0; //전체 감염횟수(감염자끼리 만나도 카운트)
        for (int i=1;i<=250;i++) {
            int x = shakes[i][0];
            int y = shakes[i][1];

            boolean xVirus = virus[x] == 1;
            boolean yVirus = virus[y] == 1;

            if (x==0 && y==0) continue;
            if (xVirus && can[x]>0) {
                can[x]--;
                virus[y]=1;
                cnt++;
            }
            
            if (yVirus && can[y]>0) {
                can[y]--;
                virus[x]=1;
                cnt++;
            }
        }

        for (int i=1;i<=N;i++) {
            System.out.print(virus[i]);
        }
    }
}