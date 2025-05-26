#include <iostream>
#include <vector>

using namespace std;

// 치킨 거리는 집과 가장 가까운 치킨집 사이의 거리이다.

int N, M;
struct position {
    int x, y;
};
int selected[13];
vector<position> home;
vector<position> chicken;
vector<position> picked;
int total_min = 987654321;

int distance(position a, position b) {
    return abs(a.x-b.x) + abs(a.y-b.y);
}

void find_min_dist() {
    int answer=0;
    for (int i=0; i<home.size(); i++) {
        int min_dist = 987654321;
        for (int j=0; j<picked.size(); j++) {
            min_dist = min(min_dist, distance(home[i], picked[j]));
        }
        answer += min_dist;
    }
    total_min = min(total_min, answer);
}

void find_min_combination(int x, int count) {
    if (count==M) {
        find_min_dist();
        return;
    }

    for (int i=x; i<chicken.size(); i++) {
        if (selected[i] == true) continue;

        selected[i] = true;
        picked.push_back({chicken[i].x, chicken[i].y});
        find_min_combination(i, count+1);
        selected[i] = false;
        picked.pop_back();

    }
}

int main() {

    ios::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> N >> M;
    for (int i=0; i<N; i++) {
        for (int j=0; j<N; j++) {
            int temp;
            cin >> temp;

            if (temp==1) home.push_back({i,j});
            else if (temp==2) chicken.push_back({i,j});
        }
    }

    find_min_combination(0,0);
    cout << total_min << endl;
    
   


    return 0;
}