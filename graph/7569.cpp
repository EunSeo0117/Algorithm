#include<iostream>
#include<sstream>
#include<vector>
#include<queue>
#include<tuple>

using namespace std;

int m,n,h;
vector<vector<vector<int>>> tomato;
vector<vector<vector<bool>>> visited;
int unripe_count = 0;
int max_days = 0;


int bfs() {
    queue<tuple<int,int,int,int>> q;

    // 익은 토마토 찾아서 큐에 넣기
    for (int i=0; i<h; i++) {
        for (int j=0; j<n; j++) {
            for (int k=0; k<m; k++) {
                if (tomato[i][j][k] == 1) {
                    q.push({i,j,k,0});
                    visited[i][j][k] = true;
                }

                if (tomato[i][j][k]==0) {
                    unripe_count++;
                }
            }
        }
    }



    vector<int> dh = {1,-1,0,0,0,0};
    vector<int> dx = {0,0,1,-1,0,0};
    vector<int> dy = {0,0,0,0,1,-1};
    
    while (!q.empty()) {
        int ch, cx, cy, days;
        tie(ch,cx,cy,days) = q.front();
        q.pop();

        max_days = max(max_days, days);

        for (int i=0; i<6; i++) {
            int nh, nx, ny;
            nh = ch + dh[i];
            nx = cx + dx[i];
            ny = cy + dy[i];

            if (0<=nh && nh<h && 0<=nx && nx<n && 0<=ny && ny<m
                && !visited[nh][nx][ny] && tomato[nh][nx][ny]==0) {
                tomato[nh][nx][ny] = 1;
                visited[nh][nx][ny] = true;
                q.push({nh,nx,ny, days+1});
                unripe_count--;
            }  
        }
    }

    return unripe_count==0 ? max_days : -1;
}

int main() {

    cin >> m >> n >> h;
    cin.ignore(); // 버퍼남은거 삭제
    tomato.resize(h, vector<vector<int>>(n, vector<int>(m)));
    visited.resize(h, vector<vector<bool>>(n, vector<bool>(m, false)));

    for (int i=0; i<h; i++) {
        for (int j=0; j<n; j++) {
            string line;
            getline(cin, line);
            istringstream iss(line);
            int num;
            int k =0;
            while (iss >> num) {
                tomato[i][j][k++] =num;
            }
        }
    }

     
    cout << bfs() << endl;
    return 0;
}
