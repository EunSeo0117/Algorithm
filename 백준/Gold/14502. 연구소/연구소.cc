#include <iostream>
#include <queue>

using namespace std;

int N, M;
int arr[8][8];
int temp[8][8];
int answer = 0;
int max_safe_zone = -1;

int dx[4] = {1, -1, 0, 0};
int dy[4] = {0 ,0 , 1 , -1};
bool visited[8][8];

// 어레이 복사
void copyMap(int (*a)[8], int (*b)[8]) {
    for (int i=0; i<N; i++) {
        for (int j=0; j<M; j++) {
            a[i][j] = b[i][j];
        }
    }
}

// 바이러스 전파
void moveVirus() {
    int spread[8][8];
    copyMap(spread, temp);
    queue<pair<int,int>> q;

    for(int i=0; i<N; i++) {
        for (int j=0; j<M; j++) {
            if (spread[i][j]==2)
                q.push({i,j});
        }
    }

    while (!q.empty()) {
        int y= q.front().first;
        int x=q.front().second;
        q.pop();
        
        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                if (spread[ny][nx]==0) {
                    spread[ny][nx] = 2;
                    q.push({ny,nx});
                }
            }
        }
    }

    int count =0;
    for (int i=0; i<N; i++) {
        for(int j=0; j<M; j++) {
            if (spread[i][j]==0) count+=1;
        }
    }

    max_safe_zone = max(count, max_safe_zone);
}


// 벽세우기 부르트포스로 다 세우보기
void installWall(int depth) {
    if (depth==3) {
        moveVirus();
        return;
    }

    for (int i=0 ;i<N; i++) {
        for (int j=0; j<M; j++) {
            if (temp[i][j]==0) {
                temp[i][j]=1;
                installWall(depth+1);
                temp[i][j]=0;
            }
        }
    }

}
    
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N >> M;
    for (int i=0; i<N; i++) {
        for (int j=0; j<M; j++) {
            cin >> arr[i][j];
        }
    }

    for (int i=0; i<N; i++) {
        for (int j=0; j<M; j++) {
            if (arr[i][j]==0) {
                copyMap(temp, arr);
                temp[i][j] = 1;
                installWall(1);
                temp[i][j] =0;
            }
        }
    }


    cout << max_safe_zone << endl;
    return 0;
}