#include <iostream>
using namespace std;

int main() {
	
	int a, b;
	cin >> a >> b;
	int c = b / 100; //3
	int d = (b % 100) / 10; //8
	int e = (b % 100) % 10; //5
	
	cout << a*e << endl;
	cout << a * d << endl;
	cout << a * c << endl;
	cout << a*b << endl;
	

	return 0;
}