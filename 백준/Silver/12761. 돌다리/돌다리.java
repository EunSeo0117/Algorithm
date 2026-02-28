import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final int MAX = 100000;


    public static void main(String[] args) throws IOException {

        Scanner sc =  new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int N = sc.nextInt();
        int M = sc.nextInt();

        System.out.println(bfs(A,B,N,M));

    }

    static int bfs(int A, int B, int start, int target) {
        boolean[] visited = new boolean[MAX + 1];
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{start,0});
        visited[start] = true;
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int position = current[0];
            int count = current[1];
            if(position == target){
                return count;
            }
            
            int[] nextPosition = {
                    position + 1,
                    position - 1,
                    position + A,
                    position - A,
                    position + B,
                    position - B,
                    position * A,
                    position * B,
            };
            
            for (int next : nextPosition) {
                if (next >= 0 && next <= MAX && !visited[next]){
                    visited[next] = true;
                    queue.offer(new int[]{next, count+1});
                }
            }
        }
        return -1;
    }


}
