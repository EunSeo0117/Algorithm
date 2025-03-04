#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int n;
vector<vector<int>> graph;
vector<vector<bool>> visited;
vector<int> answer;
 
int bfs(int x,int y) {
    deque<pair<int,int>> q;
    q.push_back({x,y});
    vector<int> dx = {-1,1,0,0};
    vector<int> dy = {0,0,-1,1};
    visited[x][y] = true;
    int count =1;
    


    while (!q.empty()) {
        int cx = q.front().first;
        int cy = q.front().second;
        q.pop_front();

        for (int i=0; i<4; i++) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];

            if (0<=nx && nx<n && 0<=ny && ny<n && visited[nx][ny]!=true && graph[nx][ny]!=0) {
                visited[nx][ny] = true;
                q.push_back({nx,ny});
                count +=1;
            }
        }
    }


    return count;
}
// 0이 아니고 visit가 false인 경우만 조회
int main() {

    cin >> n;
    graph.resize(n, vector<int>(n));
    visited.resize(n, vector<bool>(n));

    for (int i=0; i<n;i++) {
        string row;
        cin >> row; 
        for (int j=0; j<n; j++) {
            graph[i][j] = row[j] - '0';
        }
    }

    int temp;
    for (int i=0; i<n; i++) {
        for (int j=0; j<n; j++) {
            if(graph[i][j]==1 && visited[i][j] != true) {
                temp = bfs(i,j);
                if (temp==0) {
                    continue;
                } 
                answer.push_back(temp);
                
            }
        }
    }
    

    sort(answer.begin(), answer.end());
    cout << answer.size()<<"\n";
    for (int i=0; i<answer.size(); i++) {
        cout << answer[i]<< "\n";
    }

    return 0;
}
