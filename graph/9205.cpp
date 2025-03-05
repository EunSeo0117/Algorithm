#include<iostream>
#include<vector>
#include<deque>
#include<sstream>
#include<cmath>

using namespace std;

#define MAX_DISTANCE 1000

struct Point {
    int x, y;
};

int t, n;
vector<Point> locations;
vector<vector<int>> dist;

int getDistance(Point a, Point b) {
    return abs(a.x - b.x) + abs(a.y - b.y);
}

int bfs() {
    deque<int>q;
    vector<bool> visited(n+2, false);
    q.push_back(0);
    visited[0] = true;
    
    while (!q.empty()) {
        int now = q.front();
        q.pop_front();

        if (now == n+1) return true; // 페스티벌 도달시

        for (int next = 0; next< n+2; next++) {
            if (!visited[next] && getDistance(locations[now], locations[next]) <= MAX_DISTANCE) {
                visited[next] = true;
                q.push_back(next);
            }
        }
    }



    return false;
}

int main() {

    cin >> t; // 2
    while (t--) { 
        cin >> n;
        locations.clear();

        for (int i=0; i<n+2; i++) { // 4
            int x, y; // 1000 0
            cin >> x >> y;
            locations.push_back({x,y});
        }

        if (bfs()) cout << "happy\n";
            else cout << "sad\n";
    
    }
    
    return 0;
}
