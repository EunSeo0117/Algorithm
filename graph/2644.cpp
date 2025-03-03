// 2644 (촌수계산)

#include <iostream>
#include <vector>
#include <queue>

using namespace std;
vector<vector<int>> graph;
vector<bool> visited;
vector<int> depth;
int n, a, b, m;

int bfs(int a) {
    deque<int> q;
    q.push_back(a);
    visited[a] = true;
    depth[a] = 0;
    
    while (!q.empty()) {
        int current = q.front();
        q.pop_front();
        
        for (int i=0; i< graph[current].size(); i++) {
            int cn = graph[current][i];
            if (visited[cn] != true) {
                // 뎁스
                visited[cn] = true;
                depth[cn] = depth[current]+1;
                q.push_back(cn);
            }

            if (cn==b) {
                return depth[cn];
            }
        }
    }

    
    return -1;
}

int main() {
    cin >> n;  
    graph.resize(n+1);
    visited.resize(n+1);
    depth.resize(n+1);

    cin >> a >> b;

    cin >> m;
    for (int i=0; i<m; i++) {
        int x, y;
        cin >> x >> y;
        graph[x].push_back(y);
        graph[y].push_back(x);
    }

    int answer = 0;
    answer = bfs(a);
    cout << answer;
    
    return 0;
}
