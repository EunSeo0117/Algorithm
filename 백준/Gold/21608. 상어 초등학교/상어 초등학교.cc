#include <iostream>

using namespace std;

int N;
struct people {
    int student;
    int like_people[4];
};
people arr[400];
int classroom[20][20]={0};

int answer=0;
int dx[4] = {1,-1, 0, 0};
int dy[4] = {0,0, 1,-1};

int happy(int y, int x) {
    int count = 0;
    int student = classroom[y][x];
    
    int idx = -1;
    for (int i = 0; i < N*N; i++) {
        if (arr[i].student == student) {
            idx = i;
            break;
        }
    }

    for (int i=0; i<4; i++) {
        int nx = x+ dx[i];
        int ny = y+dy[i];
        if (nx>=0 && nx<N && ny>=0 && ny<N) {
            for (int j=0; j<4; j++) {
            
            if (classroom[ny][nx] == arr[idx].like_people[j])
                count +=1;
            
        }

        }
        
    }
    return count;
}
 
// idx 의 상하좌우에 좋아하는애 몇명인지 검증하는 함수 
int find_like_people_how_many(int p, int y, int x) {
    int count = 0;
    int position=-1;
    for (int i=0; i<4; i++) {
        int nx = x+dx[i];
        int ny = y+dy[i];
        if (nx>=0 && nx<N && ny>=0 && ny<N) {
            for (int j=0; j<4; j++) {
                if (classroom[ny][nx]==arr[p].like_people[j]) {
                    count+=1;
                }
            }
        }
    }

    return count;
}

int find_empty_position(int y, int x) {
    int count =0;
    for (int i=0; i<4; i++) {
        int nx = x+dx[i];
        int ny = y+dy[i];
        if (nx>=0 && nx<N && ny>=0 && ny<N) {
            if (classroom[ny][nx]==0) count+=1;
        }
    }
    return count;
}

void find_best_position(int idx) {
    
    int max_people_position=-1;
    int max_empty_position=-1;
    int x =0,y=0;
    for(int i=0; i<N; i++) {
        for (int j=0; j<N; j++) {
            if (classroom[i][j]!=0) continue;
            int temp = find_like_people_how_many(idx, i,j);
            int temp_empty = find_empty_position(i,j);

            if (max_people_position < temp) {
                max_people_position = temp;
                max_empty_position= temp_empty;
                y=i;
                x=j;
            } else if (max_people_position == temp) {
                if (max_empty_position < temp_empty) {
                    max_people_position = temp;
                    max_empty_position= temp_empty;
                    y=i;
                    x=j;
                } 
            }
        }
    }


    classroom[y][x] = arr[idx].student;
}

int main() {

    cin >> N;

    for (int i=0; i<N*N; i++) {
        cin >> arr[i].student;
        for (int j=0; j<4; j++) {
            cin >> arr[i].like_people[j];
        }
    }

    // 1개씩 탐색
    for (int i=0; i<N*N;i++) {
        find_best_position(i);
    }

    for (int i=0; i<N; i++) {
        for (int j=0; j<N; j++) {
            int count = happy(i,j);

            if (count==1) answer+=1;
            else if (count==2) answer+=10;
            else if (count==3) answer+=100;
            else if (count==4) answer+=1000;
        }
    }

    cout << answer;
    return 0;
}