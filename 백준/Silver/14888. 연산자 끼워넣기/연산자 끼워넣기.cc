#include <iostream>

using namespace std;

int N;
int arr[12];
int op[4];
int max_num=-1000000001;
int min_num=1000000001;


void cal(int res, int idx) {
    
    if (idx==N) {
        if (res > max_num) max_num = res;
        if (res < min_num) min_num = res;
        return;
    }

    for (int i=0; i<4; i++) {
        if (op[i] > 0) {
            op[i]--;
            if (i==0) cal(res+arr[idx], idx+1);
            else if (i==1) cal(res-arr[idx], idx+1);
            else if (i==2) cal(res*arr[idx], idx+1);
            else cal(res/arr[idx], idx+1);
            op[i]++;
        }
    }

    return;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> N;
    for (int i=0; i<N; i++) {
        cin >> arr[i];
    }

    for (int i=0; i<4; i++) {
        cin >> op[i];
    }

    cal(arr[0], 1);
    cout << max_num << endl;
    cout << min_num << endl;




    return 0;
}