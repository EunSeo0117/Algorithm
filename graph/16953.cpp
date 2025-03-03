// 16953 (A->B)
#include <iostream>
#include <queue>
#include <unordered_set>

using namespace std;


int a, b;
int count;

int bfs(int x) {
    deque<pair<int,int>> q;
    unordered_set<long> visited; // 방문저장을 위한 set
    q.push_back({x, 1});
    visited.insert(x);

    while (!q.empty()) {
        int current= q.front().first;
        int c_depth = q.front().second;
        q.pop_front();

        if (current == a) {
            return c_depth;
        }

        if (current % 2 == 0 && visited.find(current/2) == visited.end()) {
            q.push_back({current/2, c_depth+1});
            visited.insert(current/2);
        }


        // 오른쪽에 1을 붙인것 => 1을뺴고 /10한것(-1안해도 int라 짤림)
        // find()는 존재하면 해당 값을 반환하고, 존재하지 않으면 visited.end()를 반환
        if (current % 10 == 1 && visited.find(current/10)== visited.end()) {
            q.push_back({current/10, c_depth+1});
            visited.insert(current/10);
        }
    }

    return -1;
}

int main() {
    ios::sync_with_stdio(false); 
    cin.tie(0); 

    cin >> a >> b;

    int answer;
    answer = bfs(b);

    cout << answer ;


}
