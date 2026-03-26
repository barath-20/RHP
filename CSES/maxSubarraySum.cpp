#include<iostream>
using namespace std;
#define ll long long
void solve(){
    int n;
    cin>>n;
    int arr[n];
    for(int i=0;i<n;i++)    cin>>arr[i];
    ll Max = arr[0], sum = 0;
    for(int i=0;i<n;i++){
        sum += arr[i];
        Max = max(Max,sum);
        if(sum<0)   sum = 0;
    }
    cout<<Max;
}
int main(){
    int tc = 1;
    while(tc-->0){
        solve();
    }
    return 0;

}