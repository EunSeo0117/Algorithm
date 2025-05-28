#include <iostream>
#include <vector>
#include <deque>
#include <queue>

using namespace std;

int N, K, L;
int arr[101][101];
int answer = 0;
int dir_idx = 1;
int dx[4] = {0, 1, 0, -1};
int dy[4] = {-1, 0, 1, 0};

int main() {

    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N >> K;
    for (int i=0; i<K; i++) {
        int x, y;
        cin >> y >> x;
        arr[y][x] = 2;
    }

    queue<pair<int,char>> time;
    cin >> L;
    for (int i=0; i<L; i++) {
        int x;
        char c;
        cin >> x >> c;
        time.push({x,c});
    }

    deque<pair<int,int>> snake;
    arr[1][1] = 1;
    snake.push_back({1,1});

    while (1) {
        answer +=1;
        // 다음칸으로 위치이동
        int row = snake.back().first + dy[dir_idx];
        int col = snake.back().second + dx[dir_idx];

        // 범위넘으면 게임종료
        if (row <=0 || row > N || col <=0 || col > N || arr[row][col]==1)
            break; 

        // 사과가 없다면 꼬리 삭제
        if (arr[row][col]!=2) {
            arr[snake.front().first][snake.front().second] = 0;
            snake.pop_front();
        }

        // 앞으로 이동
        arr[row][col] = 1;
        snake.push_back({row, col});

        if (answer == time.front().first) {
            if (time.front().second == 'D')
                dir_idx = (dir_idx+1) % 4;
            else
                dir_idx = (dir_idx-1 +4 ) % 4;
            time.pop();
        }
    }

    cout << answer << endl;




    return 0;
}