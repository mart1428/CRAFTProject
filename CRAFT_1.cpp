#include <iostream>
#include <vector>
#include <string>

using namespace std;

class Department {

public:
	Department(int x, int y) {
		this->num = x;
		this->tiles = y;
	}
	string name = "";
	int num = 0;
	int tiles = 0;
	std::vector<int> closeness;
};

int MainTiles[50][50] = {};			//represent tiles
vector<Department> Departments;
vector<int> Indexes;


int main() {

	int depIndex = 0;

	int desAr;	//desired area, currently its just the length of tiles for the square
	cout << "Enter square length: ";
	cin >> desAr;
	cin.clear();
	cout << endl;

	bool inputFlag = true;
	do {
		depIndex++;
		int depnum = 0;
		string depname;
		int area = 0;

		//cin.ignore();
		//cout << "\n\nEnter Dep. Name: ";
		//getline(cin, depname);
		cout << "Enter num. of tiles: ";
		cin >> area;

		Departments.push_back(Department(depIndex, area));

		cout << "again? ";
		cin >> inputFlag;
		cin.clear();
	} while (inputFlag);

	//cout << "totalindex" << depIndex << endl;

	
	//---------------------//
	int currentDep = 0;
	int currentx = 0;
	int currenty = 0;

	for (currentDep; currentDep < depIndex; currentDep++) {
		int arNeeded = Departments[currentDep].tiles;
		int depind = Departments[currentDep].num;
		//cout << "\nNUM" << depind;
		//cout << "\tAR" << arNeeded;
		//cout << "\ncurrxy" << currentx << currenty << endl;
		bool fillFlag = true;
		int currarea = 0;

		for (currentx; currentx < desAr; currentx++) {
			for (currenty; currenty < desAr; currenty++) {
				MainTiles[currentx][currenty] = depind;
				//cout << "\tTILES" << MainTiles[currentx][currenty];
				//cout << "\tpointsxy" << currentx << currenty;
				currarea++;
				//cout << "\tarea" << currarea;
				if (currarea == (arNeeded)) {
					fillFlag = false;
					//currenty++;
					//currentx++;
					break;
				}
			}
			if (!fillFlag) {
				//cout << "CURRENTy" << currenty;
				if (currenty == (desAr - 1)) {
					
					currentx++;
					currenty = 0;
				}
				else {
					currenty++;
					//cout << "YADDED" << currenty;
				}

				//cout << "\tBROKEN" << desAr-1;
				break;
			}
			currenty = 0;
		}
	}

	cout << endl;

	for (int x = 0; x < desAr; x++) {
		for (int y = 0; y < desAr; y++) {
			cout << MainTiles[x][y] << " ";
		}
		cout << endl;
	}

	//---------------------//


}