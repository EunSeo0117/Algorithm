#include<iostream>

using namespace std;

int N, M;
int dx[4] = {1,-1,0,0};
int dy[4] = {0,0,-1,1};
int arr[500][500] = {0,};
int visited[500+1][500+1] = {false,};
int answer;

void dfs(int x, int y, int depth, int sum) {
    // dfs로 4칸 탐색후 4일때 합산한거 max중 제일큰거 저장
    if (depth==4) {
        answer = max(answer, sum);
        return;
    }
    
    if (!visited[y][x]) {
        sum += arr[y][x];
        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;

            visited[y][x] = true;
            dfs(nx, ny, depth+1, sum);
            visited[y][x] = false; // 백트레킹? 돌아와서 다시시도하는 지점
        }
    }

    // ㅗ ㅜ ㅏ ㅓ의 경우 dfs로 탐색이 안되기때문에(가지가 여러개) 개별검증
    // ㅓ
    if (x-1 >=0 && y-1 >=0 && y+1 < N)
        answer = max(answer , arr[y][x-1] + arr[y-1][x] + arr[y][x] + arr[y+1][x]);
    // ㅏ
    if (x+1 < M && y-1 >=0 && y+1 < N) 
        answer = max(answer, arr[y-1][x]+ arr[y][x] + arr[y][x+1]+ arr[y+1][x]);
    // ㅗ
    if (x-1 >=0 && x+1 < M && y-1 >=0)
        answer = max(answer, arr[y][x-1] + arr[y][x] + arr[y-1][x]+arr[y][x+1]);
    // ㅜ
    if (x-1 >=0 && x+1 < M && y+1 < N)
        answer = max(answer, arr[y][x-1] + arr[y][x] + arr[y+1][x]+arr[y][x+1]);
}


int main() {

    ios::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> N >> M;
    for (int i=0; i<N; i++) {
        for (int j=0; j<M; j++) {
            cin >> arr[i][j];
        }
    }

    for (int i =0; i<N; i++) {
        for (int j=0; j<M; j++) {
            dfs(j, i, 0, 0);
        }
    }

    cout << answer;

    return 0;
}