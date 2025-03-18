#include<iostream>
#include<vector>
#include<queue>

using namespace std;

int n, m;
int r, c, d;
int arr[55][55];
int ch[55][55];
// 방향: 북(0), 동(1), 남(2), 서(3)
int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, 1, 0, -1};

vector<vector<int>> room;
vector<vector<bool>> cleand;

int main() {

    cin >> n >> m;
    room.resize(n, vector<int>(m));
    cleand.resize(n, vector<bool>(m, false));

    cin >> r >> c >> d;
    for (int i=0; i<n; i++) {
        for (int j=0; j<m; j++) {
            cin >> room[i][j];
        }
    }

    int cleandedCount =0;

    while (true) {
        // 청소되지않았으면 청소
        if (!cleand[r][c]) {
            cleand[r][c] = true;
            cleandedCount++;
        }

        bool moved = false;

        // 주변 4칸 확인
        for (int i=0; i<4; i++) {
            d = (d+3) % 4; //반시계 90도
            int nx = r+dx[d];
            int ny = c + dy[d];

            if (0<nx && nx< n && 0<=ny && ny<m && room[nx][ny]==0 && !cleand[nx][ny]) {
                r = nx;
                c = ny;
                moved = true;
                break;
            }
        }

        if (!moved) {
            // 후진
            int backDir = (d+2) % 4;
            int bx = r+dx[backDir];
            int by = c+dy[backDir];

            if (0<=bx&& bx<n && 0<=by && by<m && room[bx][by]==0) {
                r = bx;
                c = by;
            } else {
                break;
            }
        }
    }

    cout << cleandedCount << endl;
    return 0;
}