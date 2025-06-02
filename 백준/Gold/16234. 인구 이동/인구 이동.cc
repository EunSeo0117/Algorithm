#include <iostream>
#include <queue>

using namespace std;

int N, L, R;
int A[50][50];

int dx[4] = {1,-1, 0,0};
int dy[4] = {0,0, 1,-1};
int visited[50][50];
int map[50][50];

int answer = 0;
int group = 0;
int total[2500]= {0};
int cnt[2500] = {0};

vector<pair<int,int>> unionList;

int bfs(int y, int x, int group) {
    queue<pair<int,int>> q;
    q.push({y,x});

    unionList.clear();
    unionList.push_back({y,x});

    visited[y][x] = true;
    map[y][x] = group;

    while (!q.empty()) {
        int y = q.front().first;
        int x = q.front().second;
        q.pop();

        for (int i=0 ;i<4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (nx >=0 && nx < N && ny >= 0 && ny < N && !visited[ny][nx]) {
                int temp = abs(A[ny][nx]-A[y][x]);
                if (temp >= L && temp <= R) {
                    q.push({ny,nx});
                    visited[ny][nx] = true;
                    map[ny][nx] = group;
                    unionList.push_back({ny,nx});
                }
            }
        }
    }

    return unionList.size();

} 

// 연합 생성
int makeUnion() {
    bool isMoved=false;
    for (int i=0 ; i<N; i++) {
        for (int j=0; j<N; j++) {
            if (visited[i][j]==false) {
                int unionSize = bfs(i,j,group);
                if (unionSize>1) isMoved = true;
                group+=1;
            }
        }
    }

    return isMoved;
}

// 인구 이동
void movePeople() {
    // 인구 이동
    for (int i=0; i<N; i++) {
        for (int j=0; j<N;j++) {
            int idx = map[i][j];
            total[idx] += A[i][j];
            cnt[idx]+=1;
        }
    }

    // 인구이동 계산
    for (int i=0; i<group; i++) {
        total[i] = int(total[i]/cnt[i]);
    }

    for (int i=0; i<N; i++) {
        for (int j=0; j<N; j++) {
            int idx = map[i][j];
            A[i][j] = total[idx];
        }
    }
}

void unionReset() {

    for (int i=0; i<N; i++) {
        for (int j=0; j<N; j++) {
            visited[i][j] = false;
            map[i][j] = 0;
        }
    }

    for (int i=0; i<group; i++) {
        total[i] = 0;
        cnt[i] = 0;
    }

    group = 0;
    
}



int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N >> L >> R;
    for (int i=0; i<N; i++) {
        for (int j=0; j<N; j++) {
            cin >> A[i][j];
        }
    }
    
    while (1) {
        bool moved = makeUnion();
        if (!moved) break;

        movePeople();
        unionReset();

        answer +=1;
    }

    cout << answer << endl;

    return 0;

}