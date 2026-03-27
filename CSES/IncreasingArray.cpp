#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>
#include<numeric>
using namespace std;
# define ll long long int
# define MOD 1000000007

int main(){
    int n;
    cin>>n;
    vector<int> arr(n);
    for(int i=0;i<n;++i){
        cin>>arr[i];
    }
    long sum = 0;
    for(int i=1;i<n;i++){
        if(arr[i]<arr[i-1]){
            sum += arr[i-1] - arr[i];
            arr[i] = arr[i-1];
        }
    }
    cout<<sum;
    
}