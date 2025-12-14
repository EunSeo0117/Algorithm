import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.*;
import java.util.logging.XMLFormatter;

public class Main {

    static int N, M;
    static char[][] grid;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count = 0;

    public static void bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});
        visited[y][x] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cy = cur[0];
            int cx = cur[1];

            for (int d = 0; d < 4; d++) {
                int ny = cy + dy[d];
                int nx = cx + dx[d];

                if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
                if (visited[ny][nx] || grid[ny][nx] == 'X') continue;

                visited[ny][nx] = true;
                if (grid[ny][nx] == 'P') count++;

                q.add(new int[]{ny, nx});
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new char[N][M];
        visited = new boolean[N][M];

        int sy = 0, sx = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                grid[i][j] = line.charAt(j);
                if (grid[i][j] == 'I') {
                    sy = i;
                    sx = j;
                }
            }
        }

        bfs(sy, sx);

        System.out.println(count == 0 ? "TT" : count);

    }
}