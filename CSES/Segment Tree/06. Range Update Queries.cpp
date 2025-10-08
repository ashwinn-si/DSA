#include <bits/stdc++.h>
using namespace std;
#define INF 0


long long int lookup(long long int segmentArray[], int currNode, int nodeStart, int nodeEnd, int queryStart, int queryEnd){
  if(queryStart > nodeEnd || queryEnd < nodeStart){
    return 0;
  }
  if(nodeStart >= queryStart && nodeEnd <= queryEnd){
    return segmentArray[currNode];
  }

  int mid = (nodeStart + nodeEnd) / 2;
  return segmentArray[currNode]
       + lookup(segmentArray, currNode * 2,     nodeStart, mid,      queryStart, queryEnd)
       + lookup(segmentArray, currNode * 2 + 1, mid + 1,  nodeEnd,   queryStart, queryEnd);
}

void update(long long int segmentArray[], int currNode, int nodeStart, int nodeEnd, int queryStart, int queryEnd, int updateValue){
  if(queryStart > nodeEnd || queryEnd < nodeStart) return;

  if(nodeStart >= queryStart && nodeEnd <= queryEnd){
    segmentArray[currNode] += updateValue;
    return;
  }

  int mid = (nodeStart + nodeEnd) / 2;
  update(segmentArray, currNode * 2, nodeStart, mid, queryStart, queryEnd, updateValue);
  update(segmentArray, currNode * 2 + 1, mid + 1, nodeEnd, queryStart, queryEnd, updateValue);
}

int findLength(int N){
  int result = 0;
  while((1 << result) < N){
    result++;
  }
  return 1 << result;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N, Q;
    
    cin >> N >> Q;

    int length = findLength(N);

    long long int segmentArray[length * 2 + 1];

    fill(segmentArray, segmentArray + (2 * length + 1), 0);

    for (int index = 0; index < N; index++){
      cin >> segmentArray[index + length];
    }

    for (int index = 0; index < Q; index++)
    {
      int qtype;
      cin >> qtype;
      if (qtype == 2){
        int searchIndex;
        cin >> searchIndex;
        cout << lookup(segmentArray, 1, 1, length, searchIndex, searchIndex) << "\n";
      }else{
        int startIndex, endIndex, updateValue;
        cin >> startIndex >> endIndex >> updateValue;
        update(segmentArray, 1, 1, length, startIndex, endIndex, updateValue);
      }
      }
}