import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.*;
import java.util.logging.XMLFormatter;

public class Main {

    static int M, N, K;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[M][N];
        visited = new boolean[M][N];

        for (int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()); // x1
            int y1 = Integer.parseInt(st.nextToken()); // x2
            int x2 = Integer.parseInt(st.nextToken()); // y1
            int y2 = Integer.parseInt(st.nextToken()); // y2

            for (int j=y1; j<y2; j++) {
                for (int k=x1; k<x2; k++) {
                    arr[j][k]=1;
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int y=0; y<M; y++) {
            for (int x=0; x<N; x++) {
                if (arr[y][x]==0 && !visited[y][x]) {
                    int wide=bfs(y,x);
                    list.add(wide);
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for (int a : list) {
            System.out.print(a + " ");
        }

    }

    static int bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});
        visited[y][x]=true;

        int count = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cy = cur[0];
            int cx = cur[1];

            for (int k=0; k<4; k++) {
                int nx = cx + dx[k];
                int ny = cy + dy[k];

                if (ny < 0 || nx < 0 || nx >= N || ny >= M) continue;
                if (arr[ny][nx]==1) continue;
                if (visited[ny][nx]) continue;

                visited[ny][nx]=true;
                q.add(new int[]{ny, nx});
                count++;
            }
        }
        return count;
    }

}