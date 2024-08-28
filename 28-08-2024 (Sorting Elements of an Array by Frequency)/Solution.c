//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends


//=======================================================(GeeksforGeeks Solution Start)============================================================================================================

class Solution {
  public:
   
  vector<int> sortByFreq(vector<int>& arr) {
    unordered_map<int, int> mp;
    for(int num : arr) 
        mp[num]++;
    
    vector<pair<int, int>> freqVec;
    for(auto& it : mp) {
        freqVec.push_back({it.second, it.first});
    }
 
    sort(freqVec.begin(), freqVec.end(), [](pair<int, int>& a, pair<int, int>& b) {
        if (a.first == b.first) 
            return a.second < b.second; 
        return a.first > b.first; 
    });
    
    vector<int> result;
    for(auto& p : freqVec) {
        result.insert(result.end(), p.first, p.second);
    }
    
    return result;
}
};



//=======================================================(GeeksforGeeks Solution End)============================================================================================================

//{ Driver Code Starts.

int main() {

    int t;
    cin >> t;
    cin.ignore();
    while (t--) {

        string input;
        int num;
        vector<int> arr;

        getline(cin, input);
        stringstream s2(input);
        while (s2 >> num) {
            arr.push_back(num);
        }
        Solution obj;
        vector<int> v;
        v = obj.sortByFreq(arr);
        for (int i : v)
            cout << i << " ";
        cout << endl;
    }

    return 0;
}

// } Driver Code Ends
