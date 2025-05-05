#include <iostream>
#include <vector>
#include <queue>

using namespace std;

vector<vector<int>> graph;
vector<bool> visited;
vector<int> parents;
int n;

void bfs(int x) {
    deque<int> q;
    q.push_back(x);
    visited[x]= true;

    while (!q.empty()) {
        int current = q.front();
        q.pop_front();

        for (int i=0; i<graph[current].size(); i++) {
            int cn = graph[current][i];
            if (visited[cn] != true) {
                visited[cn] = true;
                parents[cn] = current;
                q.push_back(cn);
            }
            
        }
    }
}

int main() {

    ios::sync_with_stdio(false); // C와 C++의 입출력 동기화 끄기
    cin.tie(0); 

    cin >> n;
    graph.resize(n+1);
    parents.resize(n+1);
    visited.resize(n+1);

    for (int i = 0; i < n-1; i++) {
        int a, b;
        cin >> a >> b;
        graph[a].push_back(b);
        graph[b].push_back(a);
    }

    bfs(1);
    for (int i=2; i<parents.size(); i++) {
        cout << parents[i] << "\n";
    }


    

    return 0;
}