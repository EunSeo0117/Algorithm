#include <iostream>
#include <vector>

using namespace std;

int A[51][51] ={0};
int visited[51][51] = { false };
int N, M;
vector<pair<int, int>> cloud;

int dx[8] = {-1, -1, 0, +1, +1,+1, 0, -1};
int dy[8] = {0, -1, -1, -1, 0, +1, +1, +1};

// 구름 이동
void moveCloud(int d, int s) {
    for (int i=0; i<cloud.size(); i++) {
        
        int y = cloud[i].first;
        int x = cloud[i].second;

        y = (y+dy[d]*s % N + N * 50) % N;
        x = (x + dx[d]*s % N + N*50 ) % N;

        cloud[i] = {y,x};
        visited[y][x] = true;
        
    }

}

// 비내리기
void rainToBacket() {
    for (int i=0; i<cloud.size(); i++) {
        int y = cloud[i].first;
        int x = cloud[i].second;
        A[y][x] +=1;
    }
}

// 대각선 4개에 물이 있으면 +1
void useRainMagic() {
    for (int i=0; i<cloud.size();i++) {
        for (int j=1; j<8; j+=2) {
            int ny = cloud[i].first +dy[j];
            int nx = cloud[i].second + dx[j];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            if (A[ny][nx] > 0) {
                A[cloud[i].first][cloud[i].second] +=1;
            }
        }
    }
}

void makeCloud() {
    // 이전 구름 제외하고 구름 만들기
    vector<pair<int, int>> newCloud;
    for(int i=0; i<N; i++) {
        for (int j=0; j<N; j++) {
            if (!visited[i][j] && A[i][j] >=2) {
                newCloud.push_back({i,j});
                A[i][j] -=2;   
            }
        }
    }
    cloud = newCloud;
}

int main() {

    ios::sync_with_stdio(false);
    cin.tie(NULL);

    // 양동이 입력
    cin >> N >> M;
    for (int r=0; r<N; r++) {
        for (int c=0; c<N; c++) {
            cin >> A[r][c];
        }
    }

    // 구름생성
    cloud.push_back({N-1,0});
    cloud.push_back({N-1,1});
    cloud.push_back({N-2,0});
    cloud.push_back({N-2,1});


    // 구름이동 
    for (int i=0; i<M; i++) {
        int d, s;
        cin >> d >> s;
        // 구름 이동
        moveCloud(d-1, s);
        rainToBacket();
        useRainMagic();

        // cloud리셋, visited리셋
        cloud.clear();
        makeCloud();
        for (int j=0; j<N; j++) fill(visited[j], visited[j]+N, false);
    }

    int answer = 0;
    for (int i=0; i<N; i++) {
        for (int j=0; j<N; j++) {
            answer += A[i][j];
        }
    }

    cout << answer << endl;

    return 0;
}