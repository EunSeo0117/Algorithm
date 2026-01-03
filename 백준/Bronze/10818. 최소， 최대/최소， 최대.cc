#include <iostream>
#include <vector>
using namespace std;

int main() {
	
	vector<int> v;
	int a;
	cin >> a;
	for (int i = 0; i < a; i++) {
		int t;
		cin >> t;
		v.push_back(t);
	}
	int max = v[0], min = v[0];
	for (int i = 0; i < v.size(); i++) {
		if (max < v[i])
			max = v[i];
		if (min > v[i])
			min = v[i];
	}
	
	cout << min << " " << max << endl;
	
	return 0;
}
