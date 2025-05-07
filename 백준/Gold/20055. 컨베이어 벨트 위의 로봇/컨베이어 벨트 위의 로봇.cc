
#include <iostream>

using namespace std;

int n, k;
int stop = 0;
int init = -1;
int start, endd;
bool robot[202]= {false};
int belt[202];
int result=1;
int cnt = 0;

void rotation() {
    if (start == 0) start = (n*2)-1;
    else start--;

    if (endd == 0) endd=(n*2)-1;
    else endd--;

    if (robot[endd]) robot[endd] = false;
}

void moveRobot() {
    if (init != -1) {
        int idx = endd;
        for (int i=0; i<n-1; i++) {
            int next = idx;
            if (idx ==0) idx = (n*2)-1;
            else idx--;

            if (!robot[next] && robot[idx] && belt[next]>0) {
                belt[next] -=1;

                if (belt[next]==0) {
                    cnt+=1;
                    if (cnt>=k) {
                        stop = true;
                        break;
                    }
                }

                robot[next] = true;
                robot[idx] = false;
            }
        }
        robot[endd] = false;
    }

}

void inserRobot() {
    if (belt[start] >0) {
        belt[start]--;
        if (belt[start]==0) {
            cnt+=1;
            if (cnt>=k) stop = true;;
         
        }
        robot[start] = true;
        init = 0;
    }

}

int main() {

    cin >> n >> k;
    for(int i=0; i<n*2; i++) {
        cin >> belt[i];
    }

    start = 0;
    endd = n-1;

    while (1) {
        rotation();
        moveRobot();
        inserRobot();
        if (stop) break;
        result+=1;

    }

    cout << result << endl;

    return 0;
}
