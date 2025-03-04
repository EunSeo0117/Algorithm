#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int n, m;
vector<vector<int>> graph;
vector<vector<bool>> visited;

int bfs(int x, int y) {
    deque<pair<int,int>> q;
    q.push_back({x,y});
    visited[x][y] = true;
    vector<int> dx = {-1, 1, 0, 0};
    vector<int> dy = {0, 0, -1, 1};
    
    while (!q.empty()) {
        int cx = q.front().first;
        int cy = q.front().second;
        q.pop_front();

        for (int i=0; i<4; i++) {
            int nx = cx+dx[i];
            int ny = cy+dy[i];

            if (0<=nx && nx<n && 0<=ny && ny<m && visited[nx][ny]!=true && graph[nx][ny] != 0) {
                q.push_back({nx,ny});
                visited[nx][ny]=true;
                graph[nx][ny] = graph[cx][cy]+1;
            }
        }
    }
    
    return graph[n-1][m-1];



}

int main() {

    cin >> n >> m;
    graph.resize(n, vector<int>(m));
    visited.resize(n, vector<bool>(m));

    for (int i=0; i<n; i++) {
        string temp;
        cin >> temp;
        for (int j=0; j<m; j++) {
            graph[i][j] = temp[j] - '0';
        }
    }

    int answer = bfs(0,0);

    cout << answer;

    return 0;

}
