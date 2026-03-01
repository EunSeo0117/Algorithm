import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();  // 이미 2^k 형태로 들어옴
        }

        Arrays.sort(arr);  // 오름차순 정렬

        long[] plug = new long[M];

        for (int i = N - 1; i >= 0; i--) {

            int idx = 0;
            for (int j = 1; j < M; j++) {
                if (plug[j] < plug[idx]) {
                    idx = j;
                }
            }

            plug[idx] += arr[i];
        }

        long answer = 0;
        for (int i = 0; i < M; i++) {
            answer = Math.max(answer, plug[i]);
        }

        System.out.println(answer);
    }
}