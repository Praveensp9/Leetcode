#include <iostream>
#include <vector>
#include <algorithm>
#include <set>
using namespace std;
struct Segment {
  int start;
  int end;

  bool operator <(const Segment& a) const{
		return start<a.start;
  }
};

class DownloadTask {
public:
  void add(Segment s) {
	set<Segment>::iterator it = file.lower_bound({s.start,s.start}); 
	if(file.size() && it!=file.begin())--it;
	vector<Segment>deleteSegment;
	
	// We iterate from left to right, we check only valid segments
	while(it!=file.end()){
		/*
			segment                     [start,  end]
			iterator   [start  end]
		*/
		if(it->end<=s.start ){
			it++;
			continue;
		}
		
		/*
			segment    [start,  end]
			iterator   					[start  end]
		*/
		if(it->start>=s.end)break;
		
		// Combine. now the segment covers a greater range and we'll delete old segments in the set
		s.start=min(s.start,it->start);
		s.end=max(s.end,it->end);
		fileSize-=(it->end-it->start);
		deleteSegment.push_back(*it);
		
		it++;
	}
	
	for(int i=0;i<deleteSegment.size();i++)
		file.erase(deleteSegment[i]);
	
	if(s.end>s.start){
		fileSize+=s.end-s.start;
		file.insert(s);// We add the segment only once time
	}  
	// We delete segments many times but we only add once time, then in average we deleted once time,
	// Complexity O(log(n))
  }

  int getFileSize() {
	cout<<fileSize<<endl;
	//Complexity O(1)
	return fileSize;
  }
public:
	int fileSize = 0;
	set<Segment> file;
};

int main() {
  DownloadTask task;
  task.add({1, 5});
  task.add({4, 6});
  task.getFileSize(); // returns 5
  task.add({10, 20});
  task.add({25, 30});
  task.getFileSize(); // returns 20
  task.add({19, 29});
  task.getFileSize(); // returns 25
}
