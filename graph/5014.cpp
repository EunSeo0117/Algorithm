#include <iostream>
#include <vector>
#include <queue>


using namespace std;

int f,s,g,u,d;
vector<int> graph;
vector<bool> visited;

int bfs() {
    deque<int> q;
    q.push_back(s);
    visited[s] = true;
    graph[s] = 0;

    while (!q.empty()) {
        int current = q.front();
        q.pop_front();

        int s1 = current+u;
        int s2 = current-d;
        if (s1 <=f && visited[s1]!=true) {
            visited[s1] = true;
            graph[s1] = graph[current]+1;
            if (s1==g) {
                return graph[s1];
            }
            q.push_back(s1);
            //cout << s1 << ": 다운" << "\n";
        }

        if (s2 >=1 && visited[s2]!=true) {
            visited[s2] = true;
            graph[s2] = graph[current]+1;
            if (s2==g) { // 추가하기전에 만족 검증
                return graph[s2];
            }
            q.push_back(s2);
            //cout << s2 << ": 업" << "\n";
        }




    }

    return -1;
}

int main() {

    cin >> f >> s >> g >> u >> d;
    graph.resize(f+1);
    visited.resize(f+1);

    if (s==g) {
        cout << 0;
        return 0;
    }
    
    int answer = bfs();

    if (answer==-1) {
        cout << "use the stairs";
    } else {
        cout << answer;
    }


    return 0;
}
