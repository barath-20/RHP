#include <iostream>
using namespace std;
int main(){
    int n;
    int arr[n];
    int lis[n];
    for(int i=0;i<n;i++) cin>>arr[i];
    for(int i=0;i<n;i++) lis[i] = 1;
    int maxLen = 1;
    for(int i=1;i<n;i++){
        for(int j=0;j<i;j++){
            if(arr[i]>arr[j]){
                int candidate = lis[j] + 1;
                lis[i] = (candidate > lis[i]) ? candidate : lis[i];
            }
        }
        maxLen = (lis[i] > maxLen) ? lis[i] : maxLen;
    }
    cout<<maxLen;
}